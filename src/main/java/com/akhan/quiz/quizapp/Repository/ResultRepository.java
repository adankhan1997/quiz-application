package com.akhan.quiz.quizapp.Repository;

import com.akhan.quiz.quizapp.Entity.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<QuizResult, Long> {
}
