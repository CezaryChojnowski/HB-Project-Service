package com.chojnowski.hbproject.transactions_brockers.transfer_files.logic;

import java.util.List;

public interface ImportedFilesManipulatorServiceDefaultValues<T1, R1> {
    List<R1> mapToEntitiesDefaultValue(List<T1> extractedObject);
}
