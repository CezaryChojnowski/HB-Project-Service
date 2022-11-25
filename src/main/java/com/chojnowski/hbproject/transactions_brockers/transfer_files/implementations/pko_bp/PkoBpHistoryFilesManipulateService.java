package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CardOperation;
import com.chojnowski.hbproject.service.util_service.csv.CsvOption;
import com.chojnowski.hbproject.service.util_service.csv.CsvService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.ImportedFilesManipulateService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public abstract class PkoBpHistoryFilesManipulateService implements ImportedFilesManipulateService<PkoCsv, CardOperation> {

    private final PkoBpHistoryOperationTypeManagementServiceAbstractFactory pkoBpHistoryOperationTypeManagementServiceAbstractFactory;

    private final CsvService<PkoCsv> csvService;

    private final CsvOption<PkoCsv> csvOption;

    protected PkoBpHistoryFilesManipulateService(CsvService<PkoCsv> csvService, PkoBpHistoryOperationTypeManagementServiceAbstractFactory pkoBpHistoryOperationTypeManagementServiceAbstractFactory) {
        this.pkoBpHistoryOperationTypeManagementServiceAbstractFactory = pkoBpHistoryOperationTypeManagementServiceAbstractFactory;
        this.csvService = csvService;
        csvOption = CsvOption.<PkoCsv>builder()
                .separator(',')
                .build();
    }


    @SneakyThrows
    @Override
    public List<PkoCsv> extractObject(MultipartFile file) {
        return csvService.readCsvFile(file, csvOption);
    }

    public List<CardOperation> mapToEntitiesDefaultValue(List<PkoCsv> extractedObject) {
        return extractedObject.stream().map(this::mapToCardOperation).toList();
    }

    private CardOperation mapToCardOperation(PkoCsv pkoCsv) {


        CardOperation cardOperation = CardOperation.builder()
                .operationDate(pkoCsv.operationDate)
                .valueDate(pkoCsv.valueDate)
                .typeOperation(pkoCsv.typeOperation)
                .amount(pkoCsv.getAmount())
                .currency(pkoCsv.getCurrency())
                .balanceAfterOperation(pkoCsv.getBalanceAfterOperation())
//                .title(
//                        pkoBpHistoryOperationTypeManagementServiceAbstractFactory
//                                .getOperationTypeManagementServiceFactory(pkoCsv.getDescription())
//                )
                .build();
        return null;
    }
}
