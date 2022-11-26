package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model;


import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.converter.LocalDateConverter;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDate;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PkoCsv {

    @CsvCustomBindByPosition(position = 0, converter = LocalDateConverter.class)
    private LocalDate operationDate;

    @CsvCustomBindByPosition(position = 1, converter = LocalDateConverter.class)
    private LocalDate valueDate;

    @CsvBindByPosition(position = 2)
    private String typeOperation;

    @CsvBindByPosition(position = 3)
    private BigDecimal amount;

    @CsvBindByPosition(position = 4)
    private String currency;

    @CsvBindByPosition(position = 5)
    private BigDecimal balanceAfterOperation;

    @CsvBindByPosition(position = 6)
    private String description;

    @CsvBindByPosition(position = 7)
    private String details1;

    @CsvBindByPosition(position = 8)
    private String details2;

    @CsvBindByPosition(position = 9)
    private String details3;

    @CsvBindByPosition(position = 10)
    private String details4;

    @CsvBindByPosition(position = 11)
    private String details5;

    @CsvBindByPosition(position = 12)
    private String details6;

    private String concatenatedIrregularField;

    public void concatenateIrregularField(){
        this.concatenatedIrregularField = String.format("%s|%s|%s|%s|%s|%s|%s",
                StringUtils.trim(this.description),
                StringUtils.trim(this.details1),
                StringUtils.trim(this.details2),
                StringUtils.trim(this.details3),
                StringUtils.trim(this.details4),
                StringUtils.trim(this.details5),
                StringUtils.trim(this.details6)
        );
    }
}
