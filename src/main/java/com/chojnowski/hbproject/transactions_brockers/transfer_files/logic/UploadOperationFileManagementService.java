package com.chojnowski.hbproject.transactions_brockers.transfer_files.logic;

import org.springframework.web.multipart.MultipartFile;

public interface UploadOperationFileManagementService {
    void uploadFile(MultipartFile file);

}
