package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.common;

import com.chojnowski.hbproject.entity.CardOperation;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.ImportedFilesManipulateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RequiredArgsConstructor
@Service
@Slf4j
public class ImportedOperationImportHandlingService<T> implements ImportHandlingService<T, CardOperation> {

    @Override
    public void handleImportedFile(MultipartFile file, ImportedFilesManipulateService<T, CardOperation> importedFilesManipulateService, T extractedObject, List<CardOperation> uniqueImportedTransfers) {

    }
}
