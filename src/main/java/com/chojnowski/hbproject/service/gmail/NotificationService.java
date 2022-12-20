/**
 * 20 gru 2022 11:50:39
 */
package com.chojnowski.hbproject.service.gmail;

import com.chojnowski.hbproject.dto.google.notiication.NotificationRequest;
import com.chojnowski.hbproject.entity.Notification;
import com.chojnowski.hbproject.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author cchojnowski
 */
@RequiredArgsConstructor
@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public Notification saveNotification(NotificationRequest notificationRequest){
        return notificationRepository.save(notificationRequest.mapToNotification());
    }
}
