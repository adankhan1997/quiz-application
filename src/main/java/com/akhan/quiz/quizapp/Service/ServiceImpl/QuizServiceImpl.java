package com.akhan.quiz.quizapp.Service.ServiceImpl;

import com.akhan.quiz.quizapp.DTO.AuthRequest;
import com.akhan.quiz.quizapp.DTO.QuizResponse;
import com.akhan.quiz.quizapp.DTO.QuizSubmission;
import com.akhan.quiz.quizapp.Entity.Question;
import com.akhan.quiz.quizapp.Entity.QuizResult;
import com.akhan.quiz.quizapp.Entity.User;
import com.akhan.quiz.quizapp.Repository.QuestionRespository;
import com.akhan.quiz.quizapp.Repository.ResultRepository;
import com.akhan.quiz.quizapp.Repository.UserRepository;
import com.akhan.quiz.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        user.setEmail(authRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(authRequest.getPassword()));
        userRepository.save(user);
        return "User Registered Successfully.";

    }

    @Override
    public User loginUser(AuthRequest authRequest) {

        User user = userRepository.findByEmail(authRequest.getEmail());
        if(user != null && bCryptPasswordEncoder.matches(authRequest.getPassword(), user.getPassword()))
            return user;

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

            String t = q.getTopicName();
            tTotal.put(t, tTotal.getOrDefault(t, 0) + 1);
            String ans  = submission.getAnswers().get(q.getId());
            if(ans != null && ans.equals(q.getCorrectOption())) {
                correct++;
                tCorrect.put(t, tCorrect.getOrDefault(t, 0) + 1);
            }
        }

        int score = (correct * 100) / questions.size();

        //Save to DB
        QuizResult qr = new QuizResult();
        qr.setUserEmail(submission.getEmail());
        qr.setOverallGrade(score);
        resultRepository.save(qr);

        //Prepare Response
        List<QuizResponse.TopicResult> breakdown = new ArrayList<>();
        tTotal.forEach((name, total) -> {
            int perc = (tCorrect.getOrDefault(name, 0) * 100) / total;
            breakdown.add(new QuizResponse.TopicResult(name, perc));
        });

        QuizResponse response = new QuizResponse();
        response.setOverallGrade(score);
        response.setTopicWiseResults(breakdown);

        return response;
    }
}
