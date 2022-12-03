package com.chojnowski.hbproject.dto.google.gmail;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class WatchRequest {
    private String userId;
    private String labelFilterAction;
    private List<String> labelIds;
    private String topicName;

    public com.google.api.services.gmail.model.WatchRequest map(){
        com.google.api.services.gmail.model.WatchRequest watchRequest = new com.google.api.services.gmail.model.WatchRequest();
        watchRequest.setTopicName(this.topicName);
        watchRequest.setLabelIds(this.labelIds);
        watchRequest.setLabelFilterAction(this.labelFilterAction);
        return watchRequest;
    }
}
