package com.chojnowski.hbproject.controller.external.v1.google;


import com.chojnowski.hbproject.dto.google.gmail.WatchRequest;
import com.chojnowski.hbproject.dto.google.notiication.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController(value = "External gmail controller")
@RequestMapping(path = "/external/api/v1/gmail")
@Slf4j
public class GmailController {

    @PostMapping("/notifications")
    public ResponseEntity<?> receivingNotifications(@RequestBody NotificationRequest notificationRequest) {
        log.info(String.format("Attempting to receive a notification: %s", notificationRequest));
        return null;
    }
}
