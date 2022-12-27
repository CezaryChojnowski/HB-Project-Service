/**
 * 26 gru 2022 20:31:03
 */
package com.chojnowski.hbproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author cchojnowski
 */

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, columnDefinition = "TEXT")
    private String messageGoogleId;

    private String data;

    private LocalDateTime createdAt = LocalDateTime.now();
}
