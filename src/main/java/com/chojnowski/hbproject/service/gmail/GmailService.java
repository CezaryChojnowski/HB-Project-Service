/**
 * 26 gru 2022 12:30:57
 */
package com.chojnowski.hbproject.service.gmail;

import com.chojnowski.hbproject.config.GoogleCredentials;
import com.chojnowski.hbproject.dto.google.gmail.HistoryListRequest;
import com.chojnowski.hbproject.dto.google.gmail.WatchRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListHistoryResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.Profile;
import com.google.api.services.gmail.model.WatchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * @author cchojnowski
 */
@Service
public class GmailService {

    private final Gmail gmailService;
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @Value(value = "${gmail.application_name}")
    private String applicationName;

    @Value(value = "${gmail.user_id}")
    private String userId;

    public GmailService(GoogleCredentials googleCredentials) throws GeneralSecurityException, IOException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        gmailService = new Gmail.Builder(httpTransport, JSON_FACTORY, googleCredentials.getCredentials(httpTransport))
                .setApplicationName(applicationName)
                .build();
    }

    public WatchResponse watch(WatchRequest watchRequest) throws IOException {
        return gmailService
                .users()
                .watch(userId, watchRequest.map())
                .execute();
    }

    public ListHistoryResponse getHistoryList(HistoryListRequest historyListRequest) throws IOException {
        return gmailService
                .users()
                .history()
                .list(userId)
                .setStartHistoryId(historyListRequest.getStartHistoryId())
                .setMaxResults(historyListRequest.getMaxResults())
                .setHistoryTypes(historyListRequest.getHistoryTypes())
                .setLabelId(historyListRequest.getLabelId())
                .setPageToken(historyListRequest.getPageToken())
                .execute();
    }

    public Void stop() throws IOException {
        return gmailService
                .users()
                .stop(userId)
                .execute();
    }

    public Profile getStartHistoryId() throws IOException {
        return gmailService
                .users()
                .getProfile(userId)
                .execute();
    }

    public Message getMessages(String idMessage) throws IOException {
        return gmailService
                .users()
                .messages()
                .get(userId, idMessage)
                .execute();
    }
}
