package com.example.gemini_ai.question;

public class Choice {
	private String content;
	private boolean isAnswer;
	
	public Choice() {
		// TODO Auto-generated constructor stub
	}
	public Choice(String content, boolean isAnswer) {
		this.content = content;
		this.isAnswer = isAnswer;
	}
	public boolean isAnswer() {
		return isAnswer;
	}
	public void setAnswer(boolean isAnswer) {
		this.isAnswer = isAnswer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
