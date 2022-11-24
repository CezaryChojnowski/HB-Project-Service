package com.chojnowski.hbproject.service.util_service.csv;

import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

@Component
public class CsvService<T> {
    private final Class<? extends T> T = (Class<? extends T>) PkoCsv.class;
//    private Class<T> tClass;
//
//    public CsvService(Class<T> tClass) {
//        this.tClass = tClass;
//    }

    @SneakyThrows
    public List<T> readCsvFile(MultipartFile multipartfile, CsvOption csvOption) throws FileNotFoundException {
        Reader reader = new InputStreamReader(multipartfile.getInputStream());
        CsvToBean<T> csvtobean= new CsvToBeanBuilder<T>(reader)
                .withType(T)
                .withSkipLines(1)
                .withSeparator(csvOption.getSeparator())
                .build();
        return csvtobean.parse();
    }
}
