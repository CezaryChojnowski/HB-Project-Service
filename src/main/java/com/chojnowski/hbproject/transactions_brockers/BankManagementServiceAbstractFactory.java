package com.chojnowski.hbproject.transactions_brockers;

import com.chojnowski.hbproject.enums.Bank;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.PkoBpUploadOperationsFileManagementService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.UploadOperationFileManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BankManagementServiceAbstractFactory {

    private final PkoBpUploadOperationsFileManagementService pkoBpUploadOperationsFileManagementService;

    public UploadOperationFileManagementService getTransferFileManagementServiceFactory(Bank bank) {
        return switch (bank) {
            case PKO_BP -> pkoBpUploadOperationsFileManagementService;
            default -> throw new IllegalArgumentException(String.format("%s bank doesn't have any UploadTransferFileManagementService implementations", bank));
        };
    }
}
