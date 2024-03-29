package com.f1distributedsystem.f1clientapp.service;

import com.f1distributedsystem.f1clientapp.dto.MainDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class PostSender {

    @Value("${api.url.endpoint}")
    private String URL;
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public void sendPost(String additionalUrl, MainDto dto, String uniqueId){
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(makeBody(dto)))
                .uri(URI.create(URL+additionalUrl))
                .header("Content-Type", "application/json")
                .header("Unique-Key", uniqueId)
                .build();
        try {
            httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String makeBody(MainDto dto){
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = "";
        try {
            requestBody = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return requestBody;
    }
}
