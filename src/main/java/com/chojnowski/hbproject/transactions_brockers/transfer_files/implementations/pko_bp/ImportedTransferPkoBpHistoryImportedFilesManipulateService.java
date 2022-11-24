package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CardOperation;
import com.chojnowski.hbproject.service.util_service.csv.CsvService;
import com.chojnowski.hbproject.transactions_brockers.OperationTypeManagementServiceAbstractFactory;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImportedTransferPkoBpHistoryImportedFilesManipulateService extends PkoBpHistoryFilesManipulateService {
    public ImportedTransferPkoBpHistoryImportedFilesManipulateService(CsvService<PkoCsv> csvService, OperationTypeManagementServiceAbstractFactory operationTypeManagementServiceAbstractFactory) {
        super(csvService, operationTypeManagementServiceAbstractFactory);
    }

    @Override
    public List<CardOperation> mapToEntities(List<PkoCsv> extractedObject) {
        List<CardOperation> cardOperations = mapToEntitiesDefaultValue(extractedObject);
        return null;
    }
}
