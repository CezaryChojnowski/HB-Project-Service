package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CashOperation;
import com.chojnowski.hbproject.service.util_service.csv.CsvService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management.CardPaymentOperationTypePkoBpHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportedTransferPkoBpHistoryImportedFilesManipulateService extends PkoBpHistoryFilesManipulateService {
    public ImportedTransferPkoBpHistoryImportedFilesManipulateService(CsvService<PkoCsv> csvService, CardPaymentOperationTypePkoBpHistory cardPaymentOperationTypePkoBpHistory) {
        super(cardPaymentOperationTypePkoBpHistory, csvService);
    }

    @Override
    public List<CashOperation> mapToEntities(List<PkoCsv> extractedObject) {
        List<CashOperation> cashOperations = mapToEntitiesDefaultValue(extractedObject);
        return null;
    }
}
