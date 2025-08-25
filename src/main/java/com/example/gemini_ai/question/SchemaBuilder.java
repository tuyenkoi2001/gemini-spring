package com.example.gemini_ai.question;
import com.google.genai.types.Schema;
import com.google.genai.types.Type;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SchemaBuilder {

    /**
     * Xây dựng Schema cho lớp Choice.
     */
    public static Schema buildChoiceSchema() {
        // Tạo Schema cho trường 'text' (chuỗi)
        Schema contentSchema = Schema.builder()
            .type(Type.Known.STRING)
            .description("The content of the choice.")
            .build();

        // Tạo Schema cho trường 'isCorrect' (boolean)
        Schema isAnswerSchema = Schema.builder()
            .type(Type.Known.BOOLEAN)
            .description("Indicates if the choice is correct.")
            .build();

        // Gom các Schema thành một Map cho đối tượng Choice
        Map<String, Schema> choiceProperties = new HashMap<>();
        choiceProperties.put("content", contentSchema);
        choiceProperties.put("isAnswer", isAnswerSchema);

        // Trả về Schema cuối cùng cho Choice
        return Schema.builder()
            .type(Type.Known.OBJECT)
            .properties(choiceProperties)
            .build();
    }

    /**
     * Xây dựng Schema cho lớp Question.
     */
    public static Schema buildQuestionSchema() {
        // 1. Tạo Schema cho trường 'question' (chuỗi)
        Schema questionTextSchema = Schema.builder()
            .type(Type.Known.STRING)
            .description("The text of the question.")
            .build();

        // 2. Tạo Schema cho trường 'choices' (danh sách các đối tượng Choice)
        Schema choicesListSchema = Schema.builder()
            .type(Type.Known.ARRAY)
            .items(buildChoiceSchema()) // Sử dụng lại Schema của Choice đã tạo
            .description("A list of choices for the question.")
            .build();
        
     
        Schema explainTextSchema = Schema.builder()
            .type(Type.Known.STRING)
            .description("Explain the answer by Vietnamese")
            .build();

        // 3. Gom các Schema thành một Map cho đối tượng Question
        Map<String, Schema> questionProperties = new HashMap<>();
        questionProperties.put("question", questionTextSchema);
        questionProperties.put("choices", choicesListSchema);
        questionProperties.put("explain", explainTextSchema);

        // 4. Trả về Schema cuối cùng cho Question
        return Schema.builder()
            .type(Type.Known.OBJECT)
            .properties(questionProperties)
            .propertyOrdering(Arrays.asList("question", "choices", "explain")) // Chỉ định thứ tự các trường: "question" rồi đến "choices"
            .build();
    }
    
    /**
     * Xây dựng Schema để trả về một danh sách các câu hỏi.
     */
    public static Schema buildQuestionsListSchema() {
        return Schema.builder()
            .type(Type.Known.ARRAY)
            .items(buildQuestionSchema()) // Đặt Schema của Question làm kiểu dữ liệu cho mảng
            .description("A list of questions.")
            .build();
    }
}