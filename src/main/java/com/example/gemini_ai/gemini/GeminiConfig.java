package com.example.gemini_ai.gemini;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.genai.Client;

import org.springframework.beans.factory.annotation.Value;

@Configuration
public class GeminiConfig {

    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    @Bean // Đánh dấu phương thức này sẽ tạo ra một Spring Bean
    public Client geminiClient() {
        return Client.builder().apiKey(apiKey).build();
    }
}