package com.example.gemini_ai.question;

import java.util.List;

public class Question {
	private int id;
	private String question;
	private List<Choice> choices;
	private int answerId;
	private String explain;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public Question(int id, String question, List<Choice> choices, int answerId, String explain) {
		this.id = id;
		this.question = question;
		this.choices = choices;
		this.answerId = answerId;
		this.explain = explain;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
}
