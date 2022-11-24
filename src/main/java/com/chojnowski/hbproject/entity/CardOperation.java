package com.chojnowski.hbproject.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CardOperation {

    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime createdAt;

    private LocalDate operationDate;

    private LocalDate valueDate;

    private String typeOperation;

    private BigDecimal amount;

    private String currency;

    private BigDecimal balanceAfterOperation;

}
