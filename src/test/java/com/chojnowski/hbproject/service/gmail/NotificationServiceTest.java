package com.chojnowski.hbproject.service.gmail;

import com.chojnowski.hbproject.dto.google.notiication.Message;
import com.chojnowski.hbproject.dto.google.notiication.NotificationRequest;
import com.chojnowski.hbproject.entity.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author cchojnowski
 */
@SpringBootTest
class NotificationServiceTest {

    @Autowired
    NotificationService notificationService;

    @Test
    void saveNotification() throws IOException {
        NotificationRequest notificationRequest = NotificationRequest.builder()
                .message(Message.builder()
                        .data("eyJlbWFpbEFkZHJlc3MiOiJjaG9qbm93c2tpLmN6YXJla0BnbWFpbC5jb20iLCJoaXN0b3J5SWQiOjMxMjE0NDJ9")
                        .build())
                .build();
        Notification notification = notificationService.saveNotification(notificationRequest);
    }
}