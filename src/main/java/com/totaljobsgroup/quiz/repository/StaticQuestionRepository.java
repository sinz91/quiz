package com.totaljobsgroup.quiz.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * Static Question Repository implementation
 */
@Repository
public class StaticQuestionRepository implements QuestionRepository {
    public List<String> findAll() {
        return asList("What is the capital of Cuba?",
                "What is the capital of France?",
                "What is the capital of Poland?",
                "What is the capital of Germany?");
    }

    public List<String> getAnswers() {
       return asList("Havana",
               "Paris",
               "Warsaw",
               "Berlin");
    }
}
