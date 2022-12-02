package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.common;

import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.ImportedFilesManipulateService;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.logic.UploadOperationFileManagementService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public abstract class HistoryUploadOperationFileManagementService<T1, R1> implements UploadOperationFileManagementService {
    protected abstract ImportedFilesManipulateService<T1, R1> getImportedFilesManipulationService();

    protected abstract ImportHandlingService<T1, R1> getImportHandlingService();

    protected abstract List<T1> getUniqueTransfers(List<T1> importedFilesManipulator);

    @Override
    public void uploadFile(MultipartFile file) {
        final ImportedFilesManipulateService<T1, R1> importedFilesManipulateService = getImportedFilesManipulationService();
        final ImportHandlingService<T1, R1> importHandlingService = getImportHandlingService();

        final List<T1> extractedObject = importedFilesManipulateService.extractObject(file);

        final List<R1> importedTransfers = importedFilesManipulateService.mapToEntities(extractedObject);
        int a=5;
    }
}
