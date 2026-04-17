package com.akhan.quiz.quizapp.DTO;

import java.util.Map;

public class QuizSubmission {

    private String email;
    private Map<Long, String> answers;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<Long, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, String> answers) {
        this.answers = answers;
    }
}
