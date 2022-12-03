package com.chojnowski.hbproject.dto.google.notiication;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    // This is the actual notification data, as base64url-encoded JSON.
    private String data;
    // This is a Cloud Pub/Sub message id, unrelated to Gmail messages.
    private String messageId;
    // This is the publish time of the message.
    private String publishTime;
}
