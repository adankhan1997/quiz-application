package com.akhan.quiz.quizapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
public class QuizResponse {

    private int overallGrade;
    private List<TopicResult> topicWiseResults;

    @AllArgsConstructor
    public static class TopicResult {

        private String topicName;
        private int percentage;
    }
}
