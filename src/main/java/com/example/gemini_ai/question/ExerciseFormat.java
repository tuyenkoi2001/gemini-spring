package com.example.gemini_ai.question;

public enum ExerciseFormat {
	MULTIPLE_CHOICE("câu hỏi trắc nghiệm với các lựa chọn và một đáp án đúng"),
    FILL_IN_THE_BLANK("điền vào chỗ trống, chỉ ra từ hoặc cụm từ cần điền"),
    SENTENCE_REORDERING("sắp xếp lại các từ để tạo thành một câu hoàn chỉnh"),
    KANJI_READING("câu hỏi Hán tự, yêu cầu người học đọc Hán tự và viết Hiragana"),
    KANJI_WRITING("câu hỏi Hiragana, yêu cầu người học chọn Hán tự tương ứng");

    private final String description;

    ExerciseFormat(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
