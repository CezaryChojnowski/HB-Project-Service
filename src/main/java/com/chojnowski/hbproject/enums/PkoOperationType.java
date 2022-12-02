package com.chojnowski.hbproject.enums;

public enum PkoOperationType {
    CARD_PAYMENT("Płatność kartą"),
    ATM_WITHDRAWAL_MOBILE_CODE("Wypłata w bankomacie - kod mobilny"),
    WEB_PAYMENT_MOBILE_CODE("Płatność web - kod mobilny"),
    TRANSER_TO_OUTGOING_EXTERNAL_PHONE("Przelew na telefon wychodzący zew."),
    PURCHASE_AT_THE_TERMINAL_MOBILE_CODE("Zakup w terminalu - kod mobilny"),
    BANK_TRANSFER("Przelew z rachunku")
    ;
    private final String humanFriendly;

    PkoOperationType(String humanFriendly) {
        this.humanFriendly=humanFriendly;
    }

    public String getHumanFriendly() {
        return humanFriendly;
    }
}
