package com.akhan.quiz.quizapp.Service.ServiceImpl;

import com.akhan.quiz.quizapp.DTO.AuthRequest;
import com.akhan.quiz.quizapp.DTO.QuizResponse;
import com.akhan.quiz.quizapp.DTO.QuizSubmission;
import com.akhan.quiz.quizapp.Entity.Question;
import com.akhan.quiz.quizapp.Entity.User;
import com.akhan.quiz.quizapp.Repository.QuestionRespository;
import com.akhan.quiz.quizapp.Repository.ResultRepository;
import com.akhan.quiz.quizapp.Repository.UserRepository;
import com.akhan.quiz.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuestionRespository questionRespository;
    @Autowired
    private ResultRepository resultRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public String registerUser(AuthRequest authRequest) {

        User user = new User();

        return "";
    }

    @Override
    public User loginUser(AuthRequest authRequest) {

        // yet to write logic

        return null;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRespository.findAll();
    }

    @Override
    public QuizResponse calculateResult(QuizSubmission submission) {

        List<Question> questions = questionRespository.findAll();
        int correct = 0;
        Map<String, Integer> tTotal = new HashMap<>();
        Map<String, Integer> tCorrect = new HashMap<>();

        for (Question q : questions) {
            // yet to write
        }
        return null;
    }
}
