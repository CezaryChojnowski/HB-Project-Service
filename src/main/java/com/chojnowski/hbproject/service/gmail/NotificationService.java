/**
 * 20 gru 2022 11:50:39
 */
package com.chojnowski.hbproject.service.gmail;

import com.chojnowski.hbproject.dto.google.gmail.HistoryListRequest;
import com.chojnowski.hbproject.dto.google.notiication.NotificationData;
import com.chojnowski.hbproject.dto.google.notiication.NotificationRequest;
import com.chojnowski.hbproject.entity.Message;
import com.chojnowski.hbproject.entity.Notification;
import com.chojnowski.hbproject.repository.NotificationRepository;
import com.chojnowski.hbproject.service.MessageService;
import com.google.api.services.gmail.model.History;
import com.google.api.services.gmail.model.HistoryMessageAdded;
import com.google.api.services.gmail.model.ListHistoryResponse;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

/**
 * @author cchojnowski
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final GmailService gmailService;
    private final MessageService messageService;

    public Notification saveNotification(NotificationRequest notificationRequest) throws IOException {
        com.chojnowski.hbproject.dto.google.notiication.Message message = notificationRequest.getMessage();
        byte[] dataFromBase64ByteArray = Base64.getUrlDecoder().decode(message.getData());
        String dataFromBase64Result = new String(dataFromBase64ByteArray);
        NotificationData notificationData = new Gson().fromJson(dataFromBase64Result, NotificationData.class);
        Notification notification = notificationRepository.save(mapToNotification(notificationRequest, notificationData));
        getDataFromMessage(notificationData);
        return notification;
    }

    private static Notification mapToNotification(NotificationRequest notificationRequest, NotificationData notificationData){
        return Notification.builder()
                .data(notificationRequest.getMessage().getData())
                .messageId(notificationRequest.getMessage().getMessageId())
                .publishTime(notificationRequest.getMessage().getPublishTime())
                .subscription(notificationRequest.getSubscription())
                .createdAt(LocalDateTime.now())
                .emailAddress(notificationData.getEmailAddress())
                .historyId(notificationData.getHistoryId())
                .build();
    }

    public void getDataFromMessage(NotificationData notificationData){
        try {
            HistoryListRequest historyListRequest = HistoryListRequest.builder()
                    .startHistoryId(new BigInteger(notificationData.getHistoryId()))
                    .historyTypes(List.of(
                            "messageAdded"
                    ))
                    .build();
            ListHistoryResponse listHistoryResponse = gmailService.getHistoryList(historyListRequest);
            for (int i = 0; i < listHistoryResponse.size(); i++) {
                History history = listHistoryResponse.getHistory().get(i);
                List<HistoryMessageAdded> historyMessageAddedList = history.getMessagesAdded();
                for (int j = 0; j < historyMessageAddedList.size(); j++) {
                    HistoryMessageAdded historyMessageAdded = historyMessageAddedList.get(i);
                    List<String> labels = historyMessageAdded.getMessage().getLabelIds();
                    if(labels.contains("Label_7685515506865666656")) {
                        String messageId = historyMessageAdded.getMessage().getId();
                        com.google.api.services.gmail.model.Message message1 = gmailService.getMessages(messageId);
                        String messageData = message1.getPayload().getParts().get(0).getBody().getData();
                        byte[] messageDataByteArray = Base64.getUrlDecoder().decode(messageData);
                        String messageDataResult = new String(messageDataByteArray);
                        Message gmailMessage = Message.builder().messageGoogleId(messageId).data(messageDataResult).build();
                        messageService.saveMessage(gmailMessage);
                    }
                }
            }
        }catch (NullPointerException | IOException e){
            log.error("error", e);
        }
    }
}
