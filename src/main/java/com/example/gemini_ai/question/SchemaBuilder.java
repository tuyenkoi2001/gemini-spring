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
    	//Tạo schema cho id
    	Schema idSchema = Schema.builder()
                .type(Type.Known.INTEGER)
                .description("ID of the choice, set it auto increment from 0")
                .build();
    	
        // Tạo Schema cho trường 'text' (chuỗi)
        Schema contentSchema = Schema.builder()
            .type(Type.Known.STRING)
            .description("The content of the choice.")
            .build();

        // Gom các Schema thành một Map cho đối tượng Choice
        Map<String, Schema> choiceProperties = new HashMap<>();
        choiceProperties.put("id", idSchema);
        choiceProperties.put("content", contentSchema);

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
    	//Tạo schema cho id
    	Schema idSchema = Schema.builder()
                .type(Type.Known.INTEGER)
                .description("ID of the question, set it auto increment from 0")
                .build();
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
        //Tạo schema cho id câu trả lời
    	Schema answerIdSchema = Schema.builder()
                .type(Type.Known.INTEGER)
                .description("Id of the answer to the question, its value must be the id of the answer")
                .build();
     
        Schema explainTextSchema = Schema.builder()
            .type(Type.Known.STRING)
            .description("Explanation for the answer in the following format\r\n"
            		+ "Giải thích: explanation in Vietnamese\r\n"
            		+ "Dịch: translation for the question after choosing the correct answer")
            .build();

        // 3. Gom các Schema thành một Map cho đối tượng Question
        Map<String, Schema> questionProperties = new HashMap<>();
        questionProperties.put("id", idSchema);
        questionProperties.put("question", questionTextSchema);
        questionProperties.put("choices", choicesListSchema);
        questionProperties.put("answerId", answerIdSchema);
        questionProperties.put("explain", explainTextSchema);

        // 4. Trả về Schema cuối cùng cho Question
        return Schema.builder()
            .type(Type.Known.OBJECT)
            .properties(questionProperties)
            .propertyOrdering(Arrays.asList("id","question", "choices", "answerId", "explain")) // Chỉ định thứ tự các trường: "question" rồi đến "choices"
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