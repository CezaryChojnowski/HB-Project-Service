package com.chojnowski.hbproject.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

public class CardOperation {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime createdAt;

}
