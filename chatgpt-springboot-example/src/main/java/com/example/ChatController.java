package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Value("${chatgpt.api.key}")
    private String apiKey;

    private final String chatGptApiUrl = "https://api.openai.com/v1/chat/completions";

    @PostMapping
    @ResponseBody
    public String chatWithGpt(@RequestBody RequestDto requestDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{ \"prompt\": \"" + requestDto.getMessage() + "\", \"max_tokens\": 50 }";

        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(chatGptApiUrl, HttpMethod.POST, requestEntity, String.class);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity.getBody();
        } else {
            return "Error occurred while communicating with the ChatGPT API.";
        }
    }
}