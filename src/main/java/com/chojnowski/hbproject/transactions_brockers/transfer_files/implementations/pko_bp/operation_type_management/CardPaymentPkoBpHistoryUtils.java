package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management;

import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class CardPaymentPkoBpHistoryUtils {
    public static final String RECIPIENT_NAME = "Nazwa odbiorcy:";
    public static final String TITLE = "Tytuł:";
    public static final String OPERATION_DATE = "Data i czas operacji:";
    public static final String CARD_NUMBER = "Numer karty:";
    public static final String LOCALIZATION = "Lokalizacja:";
    public static final String CITY = "Miasto:";
    public static final String ADDRESS = "Adres:";
    public static final String COUNTRY = "Kraj:";
    public static final String PHONE_NUMBER = "Numer telefonu:";
    public static final String OPERATION = "Operacja:";
    public static final String NUMER_REFERENCYJNY = "Numer referencyjny:";
    public static final String RECIPIENT_ACCOUNT = "Rachunek odbiorcy:";
    public static final String AMT = "Bankomat:";

    public static final char SEPARATOR = '|';

    public static final List<String> LIST_OF_LOCALIZATION_PLACE_HOLDERS =List.of(
            CITY,
            ADDRESS,
            COUNTRY
    );
}
