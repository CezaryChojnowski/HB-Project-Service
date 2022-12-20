/**
 * 20 gru 2022 11:50:59
 */
package com.chojnowski.hbproject.repository;

import com.chojnowski.hbproject.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cchojnowski
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
