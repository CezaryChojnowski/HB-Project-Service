/**
 * 25 lis 2022 14:24:40
 */
package com.chojnowski.hbproject.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cchojnowski
 */
@Data
@Builder
public class OriginalAmount {
    private BigDecimal amount;
    private BigDecimal currency;
}
