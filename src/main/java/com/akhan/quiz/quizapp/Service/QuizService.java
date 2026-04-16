package com.akhan.quiz.quizapp.Service;

import com.akhan.quiz.quizapp.DTO.AuthRequest;
import com.akhan.quiz.quizapp.DTO.QuizResponse;
import com.akhan.quiz.quizapp.DTO.QuizSubmission;
import com.akhan.quiz.quizapp.Entity.Question;
import com.akhan.quiz.quizapp.Entity.User;

import java.util.List;

public interface QuizService {

    String registerUser(AuthRequest authRequest);
    User loginUser(AuthRequest authRequest);
    List<Question> getAllQuestions();
    QuizResponse calculateResult(QuizSubmission submission);
}
