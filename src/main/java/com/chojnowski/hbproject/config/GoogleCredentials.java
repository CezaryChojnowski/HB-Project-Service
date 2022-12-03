package com.chojnowski.hbproject.config;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.GmailScopes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

@Component
public class GoogleCredentials {

    @Value("${credentials_file_path}")
    private String credentialFilePath;

    @Value("${tokens_directory_path}")
    private String tokensDirectoryPath;

    public static final Set<String> REQUIRED_AUTH_SCOPES = GmailScopes.all();
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public Credential getCredentials(final NetHttpTransport httpTransport) throws IOException {
        InputStream inputStream = GoogleCredentials.class.getResourceAsStream(credentialFilePath);
        if (inputStream == null) {
            throw new FileNotFoundException("No file: " + credentialFilePath + " Put it in " + credentialFilePath);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(inputStream));
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                httpTransport, JSON_FACTORY, clientSecrets, REQUIRED_AUTH_SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(tokensDirectoryPath)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }
}
