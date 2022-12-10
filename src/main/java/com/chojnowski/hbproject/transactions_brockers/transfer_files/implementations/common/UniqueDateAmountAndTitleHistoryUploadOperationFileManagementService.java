package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.common;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public abstract class UniqueDateAmountAndTitleHistoryUploadOperationFileManagementService<T1,R1> extends HistoryUploadOperationFileManagementService<T1, R1> {

    @Override
    protected List<T1> getUniqueTransfers(List<T1> list){
        return list;
    }
}
