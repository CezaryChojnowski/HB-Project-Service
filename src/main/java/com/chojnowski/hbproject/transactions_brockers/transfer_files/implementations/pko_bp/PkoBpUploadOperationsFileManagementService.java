package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CardOperation;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.common.UniqueDateAmountAndTitleHistoryUploadOperationFileManagementService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.common.ImportedOperationImportHandlingService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.ImportedFilesManipulateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PkoBpUploadOperationsFileManagementService extends UniqueDateAmountAndTitleHistoryUploadOperationFileManagementService<PkoCsv, CardOperation> {

    private final ImportedTransferPkoBpHistoryImportedFilesManipulateService pkoBpImportedFilesManipulateService;
    private final ImportedOperationImportHandlingService<PkoCsv> importedOperationImportHandlingService;

    @Override
    protected ImportedFilesManipulateService<PkoCsv, CardOperation> getImportedFilesManipulationService() {
        return pkoBpImportedFilesManipulateService;
    }

    @Override
    protected ImportedOperationImportHandlingService<PkoCsv> getImportHandlingService() {
        return importedOperationImportHandlingService;
    }
}
