package com.example.gemini_ai.question;

public class ExerciseBuilder {
	private String prompt;
    private final String basePrompt = "Tạo một bài tập tiếng Nhật theo các yêu cầu sau";
    private final String filePrompt = "Tôi vừa upload 1 tệp có nội dung liên quan tới ngữ pháp tiếng Nhật, "
    		+ "hãy phân tích nội dung của tệp, "
    		+ "phân tích các ngữ pháp, từ vựng, ví dụ được sử dụng trong tệp";

    // Constructor mặc định
    public ExerciseBuilder() {
        this.prompt = basePrompt;
    }
    
    public ExerciseBuilder(boolean hasFileAsInput) {
    	if(hasFileAsInput) {
    		this.prompt = filePrompt;
    	}
    	this.prompt = basePrompt;
    }

    /**
     * Thêm số lượng câu hỏi.
     * @param numberOfQuestions Số lượng câu hỏi bạn muốn tạo.
     * @return Đối tượng ExerciseBuilder để có thể gọi chuỗi các phương thức.
     */
    public ExerciseBuilder withNumberOfQuestions(int numberOfQuestions) {
        this.prompt += " Số lượng: " + numberOfQuestions + " câu hỏi.";
        return this;
    }

    /**
     * Thêm loại bài tập.
     * @param type Loại bài tập (ví dụ: VOCABULARY, GRAMMAR).
     * @return Đối tượng ExerciseBuilder.
     */
    public ExerciseBuilder withType(ExerciseType type) {
        this.prompt += " Loại bài tập: " + type.getDescription().toLowerCase() + ".";
        return this;
    }

    /**
     * Thêm độ khó.
     * @param level Trình độ (ví dụ: N3).
     * @return Đối tượng ExerciseBuilder.
     */
    public ExerciseBuilder withLevel(Level level) {
        this.prompt += " Trình độ: " + level.name() + ".";
        return this;
    }

    /**
     * Thêm một chủ đề nếu có.
     * @param topic Chủ đề cụ thể (có thể null).
     * @return Đối tượng ExerciseBuilder.
     */
    public ExerciseBuilder withTopic(String topic) {
        if (topic != null && !topic.isEmpty()) {
            this.prompt += " Chủ đề: " + topic + ".";
        }
        return this;
    }
    
    /**
     * Thêm một định dạng cụ thể cho bài tập.
     * @param format Định dạng (ví dụ: MULTIPLE_CHOICE).
     * @return Đối tượng ExerciseBuilder.
     */
    public ExerciseBuilder withFormat(ExerciseFormat format) {
        if (format != null) {
            this.prompt += " Định dạng: " + format.getDescription().toLowerCase() + ".";
        }
        return this;
    }

    /**
     * Hoàn thành và trả về chuỗi prompt cuối cùng.
     * @return Chuỗi prompt đã hoàn chỉnh.
     */
    public String build() {
        return this.prompt.trim();
    }
}
