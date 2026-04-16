package com.akhan.quiz.quizapp.Repository;

import com.akhan.quiz.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRespository extends JpaRepository<Question, Long> {
}
