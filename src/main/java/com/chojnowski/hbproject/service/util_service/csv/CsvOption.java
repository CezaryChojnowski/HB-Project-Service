package com.chojnowski.hbproject.service.util_service.csv;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CsvOption<T> {
    private char separator;

    private final Class<T> aClass;
}
