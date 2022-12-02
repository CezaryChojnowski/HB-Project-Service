package com.chojnowski.hbproject.service.util_service.csv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Component
public class CsvService<T> {

    public List<T> readCsvFile(MultipartFile multipartfile, CsvOption<T> csvOption) throws IOException {
        Reader reader = new InputStreamReader(multipartfile.getInputStream());
        CsvToBean<T> csvBean= new CsvToBeanBuilder<T>(reader)
                .withType(csvOption.getAClass())
                .withSkipLines(1)
                .withSeparator(csvOption.getSeparator())
                .build();
        return csvBean.parse();
    }
}
