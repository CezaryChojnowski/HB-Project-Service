package com.chojnowski.hbproject.repository;

import com.chojnowski.hbproject.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cchojnowski
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
    boolean existsByMessageGoogleId(String messageGoogleId);
}
