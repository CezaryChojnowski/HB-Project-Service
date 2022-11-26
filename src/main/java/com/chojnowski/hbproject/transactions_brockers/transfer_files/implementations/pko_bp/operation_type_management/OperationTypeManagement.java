package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management;

import com.chojnowski.hbproject.dto.Localization;

/**
 * @author cchojnowski
 */
public interface OperationTypeManagement<T>{
    String findTitle(T t);
    String findDataOperation(T t);
    String findMaskCardNumber(T t);
    Localization findLocalization(T t);
    String findPhoneNumber(T t);
    String findOperation(T t);
    String findReferenceNumber(T t);
    String findRecipientAccount(T t);
    String findAtm(T t);
    String findRecipientName(T t);
}
