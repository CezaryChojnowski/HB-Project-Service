package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CardOperation;
import com.chojnowski.hbproject.service.util_service.csv.CsvOption;
import com.chojnowski.hbproject.service.util_service.csv.CsvService;
import com.chojnowski.hbproject.transactions_brockers.OperationTypeManagementServiceAbstractFactory;
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

    private final OperationTypeManagementServiceAbstractFactory operationTypeManagementServiceAbstractFactory;

    private final CsvService<PkoCsv> csvService;

    private final CsvOption csvOption;

    protected PkoBpHistoryFilesManipulateService(CsvService<PkoCsv> csvService, OperationTypeManagementServiceAbstractFactory operationTypeManagementServiceAbstractFactory) {
        this.operationTypeManagementServiceAbstractFactory=operationTypeManagementServiceAbstractFactory;
        this.csvService = csvService;
        csvOption = CsvOption.builder()
                .separator(',')
                .build();
    }


    @SneakyThrows
    @Override
    public List<PkoCsv> extractObject(MultipartFile file) {
        return csvService.readCsvFile(file, csvOption);
    }

    public List<CardOperation> mapToEntitiesDefaultValue(List<PkoCsv> extractedObject) {
        return extractedObject.stream().map(PkoCsv::mapToCardOperation).toList();
    }

    public List<CardOperation> test(List<CardOperation> cardOperations){
        operationTypeManagementServiceAbstractFactory.
    }
}
