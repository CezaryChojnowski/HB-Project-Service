package com.chojnowski.hbproject.dto.google.notiication;


import com.chojnowski.hbproject.entity.Notification;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotificationRequest {
    private Message message;
    private String subscription;

    public Notification mapToNotification(){
        return Notification.builder()
                .data(this.getMessage().getData())
                .messageId(this.getMessage().getMessageId())
                .publishTime(this.getMessage().getPublishTime())
                .subscription(this.getSubscription())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
