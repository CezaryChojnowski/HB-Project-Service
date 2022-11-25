/**
 * 25 lis 2022 14:07:07
 */
package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management;

import com.chojnowski.hbproject.dto.Address;
import com.chojnowski.hbproject.dto.OriginalAmount;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;

import java.time.LocalDate;

/**
 * @author cchojnowski
 */
public class CardPaymentOperationTypePkoBpHistory implements OperationTypeManagement{

    @Override
    public String findTitle(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public LocalDate findDataOperation(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public String findMaskCardNumber(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public Address findAddress(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public OriginalAmount findOriginalAmount(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public String findPhoneNumber(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public String findOperation(PkoCsv pkoCsv) {
        return null;
    }

    @Override
    public String findReferenceNumber(PkoCsv pkoCsv) {
        return null;
    }

    /**
     * dataExtractor(entry, "Tytuł:"))
     private String dataExtractor(TransferRow entry, String placeholder) {
     String line = entry.getOperationData();
     return Arrays.stream(line.split("\\|"))
     .filter(part -> part.matches(String.format("^%s(.*?)$", placeholder)))
     .map(part -> part.replace(placeholder, ""))
     .findFirst()
     .orElseThrow(() -> new IllegalArgumentException(String.format("Cannot find %s for entry %s", placeholder, entry.getOperationData())))
     .strip();
     }     */
}
