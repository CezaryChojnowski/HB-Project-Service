package com.chojnowski.hbproject.entity;

import com.chojnowski.hbproject.enums.OperationType;
import com.chojnowski.hbproject.enums.VerificationStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class CashOperation {

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

    private String title;

    private String cardNumber;

    private String operation;

    private String referenceNumber;

    private String recipientName;

    private String country;

    private String city;

    private String address;

    private String dataOperation;

    private String phoneNumber;

    private String atm;

    private String recipientAccount;

    private LocalDateTime lastStatusUpdate;

    @Enumerated(value = EnumType.STRING)
    private VerificationStatus verificationStatus;

    @Enumerated(value = EnumType.STRING)
    private OperationType operationType;
}
