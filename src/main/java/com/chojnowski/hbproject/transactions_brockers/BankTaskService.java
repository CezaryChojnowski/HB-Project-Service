package com.chojnowski.hbproject.transactions_brockers;

import com.chojnowski.hbproject.enums.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class BankTaskService {

    private final BankManagementServiceAbstractFactory bankManagementServiceAbstractFactory;

    public void uploadFile(MultipartFile file, Bank bank) {
        bankManagementServiceAbstractFactory.getTransferFileManagementServiceFactory(bank)
                .uploadFile(file);
    }
}
