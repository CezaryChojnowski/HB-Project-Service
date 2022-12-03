package com.chojnowski.hbproject.dto.google.notiication;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationRequest {
    private Message message;
    private String subscription;
}
