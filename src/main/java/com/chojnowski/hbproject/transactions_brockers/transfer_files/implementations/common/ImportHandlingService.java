package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.common;

import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.ImportedFilesManipulateService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImportHandlingService<T1, R1> {
    void handleImportedFile(MultipartFile file, ImportedFilesManipulateService<T1, R1> importedFilesManipulateService, T1 extractedObject, List<R1> uniqueImportedTransfers);

}
