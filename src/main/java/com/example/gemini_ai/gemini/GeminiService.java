package com.example.gemini_ai.gemini;

import org.springframework.stereotype.Service;
import com.example.gemini_ai.question.SchemaBuilder;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Schema;

@Service
public class GeminiService {

    private final Client geminiClient;
    private GenerateContentConfig config;

    // Spring sẽ tự động tiêm bean 'geminiChatModel' vào đây
    public GeminiService(Client geminiClient) {
        this.geminiClient = geminiClient;
    }
    
    public GeminiService JsonConfig() {
    	// Tạo đối tượng Schema từ class của bạn
    	Schema questionSchema = SchemaBuilder.buildQuestionsListSchema();

        // 2. Xây dựng GenerateContentConfig với Schema đã tạo
        GenerateContentConfig config = GenerateContentConfig.builder()
            .responseMimeType("application/json")
            .responseSchema(questionSchema)
            .build();
    	this.config = config;
    	return this;
    }

    public GenerateContentResponse generateResponse(String userPrompt) {
        return geminiClient.models.generateContent(
	            "gemini-2.5-flash",
	            userPrompt,
	            config);
    }
}
