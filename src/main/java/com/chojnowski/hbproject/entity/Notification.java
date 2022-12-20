/**
 * 20 gru 2022 11:45:55
 */
package com.chojnowski.hbproject.entity;

import com.chojnowski.hbproject.dto.google.notiication.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author cchojnowski
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subscription;

    private LocalDateTime createdAt;

    private String data;

    private String messageId;

    private String publishTime;
}
