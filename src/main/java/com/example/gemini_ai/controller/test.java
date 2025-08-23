package com.example.gemini_ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gemini_ai.gemini.GeminiService;

@RestController
public class test {
	
	private final GeminiService geminiClient;
	
	public test(GeminiService geminiClient) {
		this.geminiClient = geminiClient;
	}
	@GetMapping("/askme")
    public String testWithParam(@RequestParam("promt") String promt) {
        return geminiClient.generateResponse(
        		promt
	            ).text();
    }
}
