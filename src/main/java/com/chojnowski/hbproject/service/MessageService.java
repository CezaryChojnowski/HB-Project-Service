/**
 * 26 gru 2022 20:35:28
 */
package com.chojnowski.hbproject.service;

import com.chojnowski.hbproject.entity.Message;
import com.chojnowski.hbproject.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author cchojnowski
 */
@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public void saveMessage(Message message){
        if(!messageRepository.existsByMessageGoogleId(message.getMessageGoogleId())){
            messageRepository.save(message);
        }
    }
}
