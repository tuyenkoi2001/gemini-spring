package com.example.gemini_ai.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.gemini_ai.gemini.GeminiService;
import com.example.gemini_ai.question.ExerciseBuilder;
import com.example.gemini_ai.question.ExerciseConfig;

@RestController
public class ExerciseController {
	
	private final GeminiService geminiClient;
	
	public ExerciseController(GeminiService geminiClient) {
		this.geminiClient = geminiClient;
	}
	
	@PostMapping("/api/v1/exercises")
	public String GetSingleExerciseWithConfig (@RequestBody ExerciseConfig config) {
		ExerciseBuilder promptBuilder = new ExerciseBuilder();

        promptBuilder.withNumberOfQuestions(config.getNumberOfQuestions());

        if (config.getType() != null) {
            promptBuilder.withType(config.getType());
        }
        if (config.getLevel() != null) {
            promptBuilder.withLevel(config.getLevel());
        }
        config.getTopic().ifPresent(promptBuilder::withTopic);
        config.getFormat().ifPresent(promptBuilder::withFormat);

        String finalPrompt = promptBuilder.build();
        return geminiClient.JsonConfig().generateResponse(
        		finalPrompt
	            ).text();
	}
	
	@PostMapping("/upload")
	public String testupload (@RequestPart("file") MultipartFile file, @RequestPart("config") ExerciseConfig config) {
		ExerciseBuilder promptBuilder = new ExerciseBuilder();

        promptBuilder.withNumberOfQuestions(config.getNumberOfQuestions());

        if (config.getType() != null) {
            promptBuilder.withType(config.getType());
        }
        if (config.getLevel() != null) {
            promptBuilder.withLevel(config.getLevel());
        }
        config.getTopic().ifPresent(promptBuilder::withTopic);
        config.getFormat().ifPresent(promptBuilder::withFormat);

        String finalPrompt = promptBuilder.build();
        
		return geminiClient.JsonConfig().uploadFile(file, finalPrompt).text();
	}
}
