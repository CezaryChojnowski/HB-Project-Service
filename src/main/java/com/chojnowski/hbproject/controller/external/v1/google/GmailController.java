package com.chojnowski.hbproject.controller.external.v1.google;


import com.chojnowski.hbproject.dto.google.notiication.NotificationRequest;
import com.chojnowski.hbproject.entity.Notification;
import com.chojnowski.hbproject.service.gmail.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController(value = "External gmail controller")
@RequestMapping(path = "/external/api/v1/gmail")
@Slf4j
@RequiredArgsConstructor
public class GmailController {

    private final NotificationService notificationService;

    @PostMapping("/notifications")
    public ResponseEntity<Notification> receivingNotifications(@RequestBody NotificationRequest notificationRequest) throws IOException {
        log.info(String.format("Attempting to receive a notification: %s", notificationRequest));
        return ResponseEntity.ok(
                notificationService.saveNotification(notificationRequest)
        );
    }
}
