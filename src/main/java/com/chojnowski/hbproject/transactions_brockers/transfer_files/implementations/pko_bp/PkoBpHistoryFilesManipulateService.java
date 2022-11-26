package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CashOperation;
import com.chojnowski.hbproject.service.util_service.csv.CsvOption;
import com.chojnowski.hbproject.service.util_service.csv.CsvService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management.CardPaymentOperationTypePkoBpHistory;
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
public abstract class PkoBpHistoryFilesManipulateService implements ImportedFilesManipulateService<PkoCsv, CashOperation> {

    private final CardPaymentOperationTypePkoBpHistory cardPaymentOperationTypePkoBpHistory;

    private final CsvService<PkoCsv> csvService;

    private final CsvOption<PkoCsv> csvOption;

    protected PkoBpHistoryFilesManipulateService(CardPaymentOperationTypePkoBpHistory cardPaymentOperationTypePkoBpHistory, CsvService<PkoCsv> csvService) {
        this.cardPaymentOperationTypePkoBpHistory = cardPaymentOperationTypePkoBpHistory;
        this.csvService = csvService;
        csvOption = CsvOption.<PkoCsv>builder()
                .aClass(PkoCsv.class)
                .separator(',')
                .build();
    }

    @SneakyThrows
    @Override
    public List<PkoCsv> extractObject(MultipartFile file) {
        return csvService.readCsvFile(file, csvOption);
    }

    public List<CashOperation> mapToEntitiesDefaultValue(List<PkoCsv> extractedObject) {
        return extractedObject.stream().map(this::mapToCardOperation).toList();
    }

    private CashOperation mapToCardOperation(PkoCsv pkoCsv) {
        pkoCsv.concatenateIrregularField();
        return CashOperation.builder()
                .operationDate(pkoCsv.getOperationDate())
                .valueDate(pkoCsv.getValueDate())
                .typeOperation(pkoCsv.getTypeOperation())
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
