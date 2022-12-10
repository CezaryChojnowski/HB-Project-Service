package com.chojnowski.hbproject.controller.internal.v1.google;


import com.chojnowski.hbproject.config.GoogleCredentials;
import com.chojnowski.hbproject.dto.google.gmail.HistoryListRequest;
import com.chojnowski.hbproject.dto.google.gmail.WatchRequest;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController(value = "Internal gmail controller")
@RequestMapping(path = "/internal/api/v1/gmail")
public class GmailController {

    private final Gmail gmailService;
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    @Value(value = "${gmail.application_name}")
    private String applicationName;

    @Value(value = "${gmail.user_id}")
    private String userId;

    public GmailController(GoogleCredentials googleCredentials) throws GeneralSecurityException, IOException {
        NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        gmailService = new Gmail.Builder(httpTransport, JSON_FACTORY, googleCredentials.getCredentials(httpTransport))
                .setApplicationName(applicationName)
                .build();
    }

    @PostMapping("/watch")
    public ResponseEntity<?> watch(@RequestBody WatchRequest watchRequest) throws IOException {
        return ResponseEntity
                .ok()
                .body(
                        gmailService
                                .users()
                                .watch(userId, watchRequest.map())
                                .execute());
    }

    @PostMapping("/history")
    public ResponseEntity<?> getHistoryList(@RequestBody HistoryListRequest historyListRequest) throws IOException {
        return ResponseEntity
                .ok()
                .body(
                        gmailService
                                .users()
                                .history()
                                .list(userId)
                                .setStartHistoryId(historyListRequest.getStartHistoryId())
                                .setMaxResults(historyListRequest.getMaxResults())
                                .setHistoryTypes(historyListRequest.getHistoryTypes())
                                .setLabelId(historyListRequest.getLabelId())
                                .setPageToken(historyListRequest.getPageToken())
                                .execute());
    }

    @GetMapping(value = "/history")
    public ResponseEntity<?> getStartHistoryId() throws IOException {
        return ResponseEntity
                .ok()
                .body(
                        gmailService
                                .users()
                                .getProfile(userId)
                                .execute()
                );
    }

    @GetMapping(value = "messages/{idMessage}")
    public ResponseEntity<?> getMessages(@PathVariable String idMessage) throws IOException {
        return ResponseEntity
                .ok()
                .body(
                        gmailService
                                .users()
                                .messages()
                                .get(userId, idMessage)
                                .execute());
    }
}
