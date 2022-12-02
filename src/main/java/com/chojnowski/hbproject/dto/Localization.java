/**
 * 25 lis 2022 14:23:20
 */
package com.chojnowski.hbproject.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author cchojnowski
 */
@Builder
@Data
public class Localization {
    private String country;
    private String city;
    private String address;
}
