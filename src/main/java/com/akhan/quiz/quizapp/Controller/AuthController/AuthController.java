package com.akhan.quiz.quizapp.Controller.AuthController;

import com.akhan.quiz.quizapp.DTO.AuthRequest;
import com.akhan.quiz.quizapp.Entity.User;
import com.akhan.quiz.quizapp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(quizService.registerUser(authRequest));

    }

    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        User user = quizService.loginUser(authRequest);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(401).body("Invalid Credentials");
    }
}
