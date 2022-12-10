/**
 * 25 lis 2022 14:07:07
 */
package com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management;

import com.chojnowski.hbproject.dto.Localization;
import com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.model.PkoCsv;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static com.chojnowski.hbproject.transactions_brockers.transfer_files.implementations.pko_bp.operation_type_management.CardPaymentPkoBpHistoryUtils.*;

/**
 * @author cchojnowski
 */
@Service
public class CardPaymentOperationTypePkoBpHistory implements OperationTypeManagement<PkoCsv>{

    @Override

    public String findTitle(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), TITLE);
    }

    @Override
    public String findDataOperation(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), OPERATION_DATE);
    }

    @Override
    public String findMaskCardNumber(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), CARD_NUMBER);
    }

    @Override
    public Localization findLocalization(PkoCsv pkoCsv) {
        String localization = dataExtractor(pkoCsv.getConcatenatedIrregularField(), LOCALIZATION);

        String localizationRef = addSeparatorToLocalizationString(localization);
        return Localization.builder()
                .city(dataExtractor(localizationRef, CITY))
                .address(dataExtractor(localizationRef, ADDRESS))
                .country(dataExtractor(localizationRef, COUNTRY))
                .build();
    }

    @Override
    public String findPhoneNumber(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), PHONE_NUMBER);
    }

    @Override
    public String findOperation(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), OPERATION);
    }

    @Override
    public String findReferenceNumber(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), NUMER_REFERENCYJNY);
    }

    @Override
    public String findRecipientAccount(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), RECIPIENT_ACCOUNT);
    }

    @Override
    public String findAtm(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), AMT);
    }

    @Override
    public String findRecipientName(PkoCsv pkoCsv) {
        return dataExtractor(pkoCsv.getConcatenatedIrregularField(), RECIPIENT_NAME);
    }

    private String dataExtractor(String line, String placeholder) {
        return Arrays.stream(line.split("\\|"))
                .filter(part -> part.matches(String.format("^%s(.*?)$", placeholder)))
                .map(part -> part.replace(placeholder, ""))
                .findFirst()
                .orElseGet(() -> "")
                .strip();
    }

    private String addSeparatorToLocalizationString(String localization){
        StringBuilder localizationStringBuilder = new StringBuilder(localization);
        LIST_OF_LOCALIZATION_PLACE_HOLDERS.forEach(localizationPlaceholder -> {
            int lozalizationPlaceholderIndex = localization.indexOf(localizationPlaceholder);
            if(lozalizationPlaceholderIndex!=-1 && lozalizationPlaceholderIndex!=0){
                localizationStringBuilder.setCharAt(lozalizationPlaceholderIndex - 1, SEPARATOR);
            }
        });
        return localizationStringBuilder.toString();
    }

}
