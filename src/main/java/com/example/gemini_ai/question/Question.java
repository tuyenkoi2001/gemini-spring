package com.example.gemini_ai.question;

import java.util.List;

public class Question {
	private String question;
	private List<Choice> choices;
	private String explain;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
	public Question(String question, List<Choice> choices, String explain) {
		this.question = question;
		this.choices = choices;
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
	/**
	 * @return the explain
	 */
	public String getExplain() {
		return explain;
	}
	/**
	 * @param explain the explain to set
	 */
	public void setExplain(String explain) {
		this.explain = explain;
	}
}
