package com.chojnowski.hbproject.transactions_brockers.transfer_files.logic;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImportedFilesManipulateService<T1,R1> extends ImportedFilesManipulatorServiceDefaultValues<T1,R1>{
    List<T1> extractObject(MultipartFile file);
    List<R1> mapToEntities(List<T1> extractedObject);

}
