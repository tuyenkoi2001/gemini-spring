package com.example.gemini_ai.question;

import java.util.Optional;

public class ExerciseConfig {
	private String description;
	private ExerciseType type;
    private Level level;
    private Optional<ExerciseFormat> format;
    private int numberOfQuestions;
    private Optional<String> topic;
    
    public ExerciseConfig() {
        this.format = Optional.empty();
        this.topic = Optional.empty();
    }

    // Constructor có tham số (nếu có)
    public ExerciseConfig(ExerciseType type, Level level, Optional<ExerciseFormat> format, int numberOfQuestions, Optional<String> topic) {
        this.type = type;
        this.level = level;
        this.format = format;
        this.numberOfQuestions = numberOfQuestions;
        this.topic = topic;
    }
    
    public Optional<String> getTopic() {
        return topic;
    }

    public void setTopic(Optional<String> topic) {
        this.topic = topic;
    }
    
    public Optional<ExerciseFormat> getFormat() {
        return format;
    }

    public void setFormat(Optional<ExerciseFormat> format) {
        this.format = format;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExerciseType getType() {
		return type;
	}

	public void setType(ExerciseType type) {
		this.type = type;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * @return the numberOfQuestions
	 */
	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	/**
	 * @param numberOfQuestions the numberOfQuestions to set
	 */
	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}
}
