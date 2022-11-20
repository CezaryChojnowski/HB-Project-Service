package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model;


import com.opencsv.bean.CsvBindByPosition;
import lombok.*;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PkoCsv {

    @CsvBindByPosition(position = 0)
    public String operationDate;

    @CsvBindByPosition(position = 1)
    public String valueDate;

    @CsvBindByPosition(position = 2)
    public String typeOperation;

    @CsvBindByPosition(position = 3)
    public String amount;

    @CsvBindByPosition(position = 4)
    public String currency;

    @CsvBindByPosition(position = 5)
    public String saldoAfterOperation;

    @CsvBindByPosition(position = 6)
    public String description;

    @CsvBindByPosition(position = 7)
    public String details1;

    @CsvBindByPosition(position = 8)
    public String details2;

    @CsvBindByPosition(position = 9)
    public String details3;

    @CsvBindByPosition(position = 10)
    public String details4;

    @CsvBindByPosition(position = 11)
    public String details5;

    @CsvBindByPosition(position = 12)
    public String details6;

    @CsvBindByPosition(position = 13)
    public String details7;
}
