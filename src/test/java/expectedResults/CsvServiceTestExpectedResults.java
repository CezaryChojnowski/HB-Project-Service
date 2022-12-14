package expectedResults;

import com.chojnowski.hbproject.enums.PkoOperationType;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import lombok.experimental.UtilityClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class CsvServiceTestExpectedResults {

    public static final List<PkoCsv> HISTORY_CSV_1 = List.of(
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 11, 17))
                    .valueDate(LocalDate.of(2022, 11, 15))
                    .typeOperation(PkoOperationType.CARD_PAYMENT.getHumanFriendly())
                    .amount(new BigDecimal("-28.99"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10654.34"))
                    .description("Tytuł: 010062941 74987502318800260748333")
                    .details1("Lokalizacja: Kraj: HOLANDIA Miasto: Hoofddorp Adres: Disney Plus")
                    .details2("Data i czas operacji: 2022-11-15")
                    .details3("Oryginalna kwota operacji: 28,99 PLN")
                    .details4("Numer karty: 542165******9497")
                    .details5("")
                    .details6("")
                    .build(),
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 11, 16))
                    .valueDate(LocalDate.of(2022, 11, 15))
                    .typeOperation(PkoOperationType.ATM_WITHDRAWAL_MOBILE_CODE.getHumanFriendly())
                    .amount(new BigDecimal("-15.00"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10625.35"))
                    .description("Tytuł: S1BK0050 7356 00000075521968134")
                    .details1("Numer telefonu: +48 333 777 753 ")
                    .details2("Lokalizacja: Kraj: POLSKA Miasto: WARSZAWA Adres: AL. PILSUDSKIEGO 14")
                    .details3("Bankomat: S1BK0050")
                    .details4("Operacja: 7356 00000070021968134")
                    .details5("Numer referencyjny: 7356 00000070021968134")
                    .details6("")
                    .build(),
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 11, 16))
                    .valueDate(LocalDate.of(2022, 11, 14))
                    .typeOperation(PkoOperationType.CARD_PAYMENT.getHumanFriendly())
                    .amount(new BigDecimal("-32.95"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10419.22"))
                    .description("Tytuł:  74988852318496327810513")
                    .details1("Lokalizacja: Kraj: POLSKA Miasto: WARSZAWA Adres: JMP S.A. BIEDRONKA 4444")
                    .details2("Data i czas operacji: 2022-11-14")
                    .details3("Oryginalna kwota operacji: 32,95 PLN")
                    .details4("Numer karty: 542165******2222")
                    .details5("")
                    .details6("")
                    .build(),
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 11, 15))
                    .valueDate(LocalDate.of(2022, 11, 14))
                    .typeOperation(PkoOperationType.WEB_PAYMENT_MOBILE_CODE.getHumanFriendly())
                    .amount(new BigDecimal("-386.27"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10094.90"))
                    .description("Tytuł: 00000070016565896")
                    .details1("Numer telefonu: +48 293 293 333 ")
                    .details2("Lokalizacja: Adres: allegro.pl")
                    .details3("Operacja: 0000007333365896")
                    .details4("Numer referencyjny: 00000070016565896")
                    .details5("")
                    .details6("")
                    .build(),
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 11, 4))
                    .valueDate(LocalDate.of(2022, 11, 4))
                    .typeOperation(PkoOperationType.TRANSER_TO_OUTGOING_EXTERNAL_PHONE.getHumanFriendly())
                    .amount(new BigDecimal("347.43"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10060.00"))
                    .description("Rachunek odbiorcy: 91 1050 1823 2222 0092 6520 3333")
                    .details1("Nazwa odbiorcy: TEST")
                    .details2("Tytuł: CYFROWY POLSAT OD: 48548962354 DO: 485*****202")
                    .details3("")
                    .details4("")
                    .details5("")
                    .details6("")
                    .build(),
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 11, 2))
                    .valueDate(LocalDate.of(2022, 10, 31))
                    .typeOperation(PkoOperationType.PURCHASE_AT_THE_TERMINAL_MOBILE_CODE.getHumanFriendly())
                    .amount(new BigDecimal("-49.99"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10016.15"))
                    .description("Tytuł: 00000069722146298")
                    .details1("Numer telefonu: +48 123 555 456 ")
                    .details2("Lokalizacja: Kraj: POLSKA Miasto: WARSZAWA Adres: STOKROTKA")
                    .details3("Operacja: 00000069757869298")
                    .details4("Numer referencyjny: 00000069444446298")
                    .details5("")
                    .details6("")
                    .build(),
            PkoCsv.builder()
                    .operationDate(LocalDate.of(2022, 10, 25))
                    .valueDate(LocalDate.of(2022, 10, 25))
                    .typeOperation(PkoOperationType.BANK_TRANSFER.getHumanFriendly())
                    .amount(new BigDecimal("-40.00"))
                    .currency("PLN")
                    .balanceAfterOperation(new BigDecimal("10402.37"))
                    .description("Nazwa odbiorcy: PKO BP FINAT SP. Z O.O.")
                    .details1("Tytuł: DOŁADOWANIE TELEFONU +48 123456789 ORANGE IDENTYFIKATOR OPERACJI: 107479806")
                    .details2("")
                    .details3("")
                    .details4("")
                    .details5("")
                    .details6("")
                    .build()
    );

    public static final List<PkoCsv> HISTORY_CSV_2 = List.of();
}