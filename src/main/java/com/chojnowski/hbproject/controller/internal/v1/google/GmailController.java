package com.chojnowski.hbproject.controller.internal.v1.google;


import com.chojnowski.hbproject.dto.google.gmail.HistoryListRequest;
import com.chojnowski.hbproject.dto.google.gmail.WatchRequest;
import com.chojnowski.hbproject.service.gmail.GmailService;
import com.google.api.services.gmail.model.ListHistoryResponse;
import com.google.api.services.gmail.model.Message;
import com.google.api.services.gmail.model.Profile;
import com.google.api.services.gmail.model.WatchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController(value = "Internal gmail controller")
@RequestMapping(path = "/internal/api/v1/gmail")
@RequiredArgsConstructor
public class GmailController {

    private final GmailService gmailService;

    @PostMapping("/watch")
    public ResponseEntity<WatchResponse> watch(@RequestBody WatchRequest watchRequest) throws IOException {
        return ResponseEntity
                .ok()
                .body(gmailService.watch(watchRequest));
    }

    @PostMapping("/stop")
    public ResponseEntity<Void> stop() throws IOException {
        return ResponseEntity
                .ok()
                .body(gmailService.stop());
    }

    @PostMapping("/history")
    public ResponseEntity<ListHistoryResponse> getHistoryList(@RequestBody HistoryListRequest historyListRequest) throws IOException {
        return ResponseEntity
                .ok()
                .body(gmailService
                                .getHistoryList(historyListRequest));
    }

    @GetMapping(value = "/history")
    public ResponseEntity<Profile> getStartHistoryId() throws IOException {
        return ResponseEntity
                .ok()
                .body(gmailService.getStartHistoryId());
    }

    @GetMapping(value = "messages/{idMessage}")
    public ResponseEntity<Message> getMessages(@PathVariable String idMessage) throws IOException {
        return ResponseEntity
                .ok()
                .body(gmailService.getMessages(idMessage));
    }
}
