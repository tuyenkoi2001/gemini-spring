package com.example.gemini_ai.question;

public enum ExerciseType {
	KANJI("tạo câu hỏi để kiểm tra kiến thức về chữ Hán"),
    VOCABULARY("tạo câu hỏi để kiểm tra từ vựng, các từ vựng đáp án phải là tiếng Việt"),
    GRAMMAR("tạo câu hỏi để kiểm tra ngữ pháp"),
    READING("tạo một đoạn văn và các câu hỏi để kiểm tra khả năng đọc hiểu"),
    LISTENING("tạo các câu hỏi dựa trên một đoạn hội thoại hoặc độc thoại"),
    TRANSLATION("tạo câu hỏi yêu cầu dịch từ tiếng Nhật sang tiếng Việt hoặc ngược lại");

	private final String description;

    ExerciseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
