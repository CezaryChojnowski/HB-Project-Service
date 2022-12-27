/**
 * 26 gru 2022 12:19:48
 */
package com.chojnowski.hbproject.dto.google.notiication;

import lombok.Builder;
import lombok.Data;

/**
 * @author cchojnowski
 */
@Data
@Builder
public class NotificationData {
    private String emailAddress;
    private String historyId;
}
