package com.example.gemini_ai.question;

public class Choice {
	private int id;
	private String content;
	
	public Choice() {
		// TODO Auto-generated constructor stub
	}
	public Choice(int id, String content, boolean isAnswer) {
		this.id = id;
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
