/**
 * 25 lis 2022 12:24:05
 */
package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management;

import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import org.springframework.stereotype.Service;

/**
 * @author cchojnowski
 */
@Service
public class TitleOperationTypeManagement implements OperationTypeManagement<String>{
    @Override
    public String find(PkoCsv pkoCsv) {
        return pkoCsv.getDescription();
    }
}
