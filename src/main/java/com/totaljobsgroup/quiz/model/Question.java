package com.totaljobsgroup.quiz.model;

import java.util.HashMap;

/**
 * Created by Satya on 31/08/2017.
 */
public class Question {

    private HashMap<String, String> questionAndAnswerMap;
    private HashMap<String, String> questionAndUserAnswerMap;

    public Question() { }

    public Question(HashMap<String, String> questionAndAnswerMap, HashMap<String, String> questionAndUserAnswerMap) {
        this.questionAndAnswerMap = questionAndAnswerMap;
        this.questionAndUserAnswerMap = questionAndUserAnswerMap;
    }

    public HashMap<String, String> getQuestionAndAnswerMap() {
        return questionAndAnswerMap;
    }

    public void setQuestionAndAnswerMap(HashMap<String, String> questionAndAnswerMap) {
        this.questionAndAnswerMap = questionAndAnswerMap;
    }

    public HashMap<String, String> getQuestionAndUserAnswerMap() {
        return questionAndUserAnswerMap;
    }

    public void setQuestionAndUserAnswerMap(HashMap<String, String> questionAndUserAnswerMap) {
        this.questionAndUserAnswerMap = questionAndUserAnswerMap;
    }
}
