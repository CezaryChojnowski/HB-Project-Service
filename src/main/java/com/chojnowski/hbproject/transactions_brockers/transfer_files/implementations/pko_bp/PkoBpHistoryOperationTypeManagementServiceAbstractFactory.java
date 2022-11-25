/**
 * 25 lis 2022 12:27:40
 */
package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.enums.PkoOperationType;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management.CardPaymentOperationTypePkoBpHistory;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management.OperationTypeManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author cchojnowski
 */
@Service
@RequiredArgsConstructor
public class PkoBpHistoryOperationTypeManagementServiceAbstractFactory {

    private final CardPaymentOperationTypePkoBpHistory cardPaymentOperationTypePkoBpHistory;

    public OperationTypeManagement getOperationTypeManagementServiceFactory(String typeOperation){
        return switch (typeOperation) {
            case PkoOperationType.CARD_PAYMENT.getHumanFriendly() -> cardPaymentOperationTypePkoBpHistory;
            default -> throw new IllegalArgumentException("");
        };
    }
}
