package com.akhan.quiz.quizapp.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class QuizSubmission {

    private String email;
    private Map<Long, String> answers;
}
