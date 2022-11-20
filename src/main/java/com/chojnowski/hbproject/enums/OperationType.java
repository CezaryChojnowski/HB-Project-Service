package com.chojnowski.hbproject.enums;

public enum OperationType {
    CARD_PAYMENT("Płatność kartą"),
    ATM_WITHDRAWAL_MOBILE_CODE("Wypłata w bankomacie - kod mobilny"),
    WEB_PAYMENT_MOBILE_CODE("Płatność web - kod mobilny"),
    ;
    private final String humanFriendly;

    OperationType(String humanFriendly) {
        this.humanFriendly=humanFriendly;
    }

    public String getHumanFriendly() {
        return humanFriendly;
    }
}
