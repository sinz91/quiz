package com.totaljobsgroup.quiz.repository;

import java.util.List;

/**
 * Question Repository Interface
 */
public interface QuestionRepository {
    List<String> findAll();
    List<String> getAnswers();
}
