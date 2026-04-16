package com.akhan.quiz.quizapp.Controller;

import com.akhan.quiz.quizapp.DTO.QuizResponse;
import com.akhan.quiz.quizapp.DTO.QuizSubmission;
import com.akhan.quiz.quizapp.Entity.Question;
import com.akhan.quiz.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin("*")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/questions")
    public List<Question> getQuestions() {
        return quizService.getAllQuestions();
    }

    public QuizResponse submit(@RequestBody QuizSubmission quizSubmission) {
        return  quizService.calculateResult(quizSubmission);
    }
}
