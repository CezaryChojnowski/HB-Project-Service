package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp;

import com.chojnowski.hbproject.entity.CardOperation;
import com.chojnowski.hbproject.service.util_service.csv.CsvOption;
import com.chojnowski.hbproject.service.util_service.csv.CsvService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.ImportedFilesManipulateService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Slf4j
public abstract class PkoBpHistoryFilesManipulateService implements ImportedFilesManipulateService<PkoCsv, CardOperation> {

    private final CsvService<PkoCsv> csvService;

    private final CsvOption csvOption;

    protected PkoBpHistoryFilesManipulateService(CsvService<PkoCsv> csvService) {
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
}
