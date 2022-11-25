package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management;

import com.chojnowski.hbproject.dto.Address;
import com.chojnowski.hbproject.dto.OriginalAmount;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;

import java.time.LocalDate;

/**
 * @author cchojnowski
 */
public interface OperationTypeManagement{
    String findTitle(PkoCsv pkoCsv);
    LocalDate findDataOperation(PkoCsv pkoCsv);
    String findMaskCardNumber(PkoCsv pkoCsv);
    Address findAddress(PkoCsv pkoCsv);
    OriginalAmount findOriginalAmount(PkoCsv pkoCsv);

    /*
    For Płatność web - kod mobilny type
     */
    String findPhoneNumber(PkoCsv pkoCsv);
    String findOperation(PkoCsv pkoCsv);
    String findReferenceNumber(PkoCsv pkoCsv);
}
