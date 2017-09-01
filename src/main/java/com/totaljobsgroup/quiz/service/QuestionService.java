package com.totaljobsgroup.quiz.service;

import java.util.HashMap;
import java.util.List;

/**
 *  Question Service Interface
 */
public interface QuestionService {

    List<String> getQuestions();

    HashMap<String, String> getAnswers(List<String> questions);

}
