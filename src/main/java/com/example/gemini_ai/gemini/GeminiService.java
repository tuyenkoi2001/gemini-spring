package com.example.gemini_ai.gemini;

import org.springframework.stereotype.Service;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

@Service
public class GeminiService {

    private final Client geminiClient;

    // Spring sẽ tự động tiêm bean 'geminiChatModel' vào đây
    public GeminiService(Client geminiClient) {
        this.geminiClient = geminiClient;
    }

    public GenerateContentResponse generateResponse(String userPrompt) {
        return geminiClient.models.generateContent(
	            "gemini-2.5-flash",
	            userPrompt,
	            null);
    }
}
