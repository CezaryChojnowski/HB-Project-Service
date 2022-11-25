package com.chojnowski.hbproject.service.util_service.csv;

import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static expectedResults.CsvServiceTestExpectedResults.HISTORY_CSV_1;
import static expectedResults.CsvServiceTestExpectedResults.HISTORY_CSV_2;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CsvServiceTest {

    @InjectMocks
    CsvService<PkoCsv> csvService;

    private static final String PATH_TO_FILES = "/exampleData/bankFiles/pko_bp/%s_history_pko.csv";


    @ParameterizedTest
    @DisplayName(value = "Should correct load data from csv file")
    @MethodSource(value = "csvFilesAndExpectedResults")
    void readCsvFile(String pathToFile, List<PkoCsv> expectedResultList) throws IOException {
        //given
        final File file = new File(Objects.requireNonNull(this.getClass().getResource(pathToFile)).getFile());
        final MockMultipartFile mockMultipartFile = new MockMultipartFile("1_history_pko.csv", Files.readAllBytes(file.toPath()));
        final CsvOption<PkoCsv> csvOption = CsvOption.<PkoCsv>builder()
                .separator(',')
                .aClass(PkoCsv.class)
                .build();

        //when
        List<PkoCsv> givenResult = csvService.readCsvFile(mockMultipartFile, csvOption);

        //then
        Assertions.assertIterableEquals(expectedResultList, givenResult);
    }

    private static Stream<Arguments> csvFilesAndExpectedResults() {
        return Stream.of(
                Arguments.of(String.format(PATH_TO_FILES, "1"), HISTORY_CSV_1),
                Arguments.of(String.format(PATH_TO_FILES, "2"), HISTORY_CSV_2)
        );
    }
}