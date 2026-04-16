package com.akhan.quiz.quizapp.DTO;

import lombok.Data;

@Data
public class AuthRequest {

    private String email;
    private String password;
}
