package com.mindmitra.backend.service;

import com.mindmitra.backend.model.OpenAIRequest;
import com.mindmitra.backend.model.OpenAIResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class AIService {

    @Value("${openai.api.key}")
    private String apiKey;

    public String getAIReply(String userMessage) {
        try {
            RestTemplate restTemplate = new RestTemplate();

            OpenAIRequest request = new OpenAIRequest();
            request.setModel("gpt-3.5-turbo");
            request.setMessages(Collections.singletonList(
                new OpenAIRequest.Message("user", userMessage)
            ));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            HttpEntity<OpenAIRequest> entity = new HttpEntity<>(request, headers);

            ResponseEntity<OpenAIResponse> response = restTemplate.postForEntity(
                "https://api.openai.com/v1/chat/completions",
                entity,
                OpenAIResponse.class
            );

            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody().getChoices().get(0).getMessage().getContent();
            } else {
                System.out.println("OpenAI response code: " + response.getStatusCode());
                return "Oops! I couldn't get a proper response from AI.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
