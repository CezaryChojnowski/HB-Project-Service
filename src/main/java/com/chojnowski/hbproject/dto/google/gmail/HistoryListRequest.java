package com.chojnowski.hbproject.dto.google.gmail;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
@Builder
public class HistoryListRequest {
    private List<String> historyTypes;
    private String labelId;
    private Long maxResults;
    private String pageToken;
    private BigInteger startHistoryId;
}
