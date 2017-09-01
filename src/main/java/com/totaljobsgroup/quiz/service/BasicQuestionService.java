package com.totaljobsgroup.quiz.service;

import com.totaljobsgroup.quiz.model.Question;
import com.totaljobsgroup.quiz.repository.QuestionRepository;
import com.totaljobsgroup.quiz.repository.StaticQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Question Service implementation
 */
@Service
public class BasicQuestionService implements QuestionService {

    private static QuestionRepository questionRepository = new StaticQuestionRepository();

    @Autowired
    public BasicQuestionService(StaticQuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }

    public List<String> getQuestions() {
        return questionRepository.findAll();
    }

    public HashMap<String, String> getAnswers(List<String> questions) {
        HashMap<String, String> questionAndAnswer = new HashMap<>();

        List<String> answers = questionRepository.getAnswers();
        try {
            questions.stream().forEach(q -> {
                questionAndAnswer.put(q, answers.get(questions.indexOf(q)));
            });
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return questionAndAnswer;
    }

    public Question setQuestionObject(List<String> userAnswerList) {
        Question question = new Question();

        HashMap<String, String> questionAndUserAnswerMap = new HashMap<>();
        try {
            userAnswerList.forEach(ua -> {
                questionAndUserAnswerMap.put(getQuestions().get(userAnswerList.indexOf(ua)), ua);
            });
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        question.setQuestionAndAnswerMap(getAnswers(getQuestions()));
        question.setQuestionAndUserAnswerMap(questionAndUserAnswerMap);

        return question;
    }

    public int calculateScore(Question question) {
        int score = 0;
        for (Map.Entry<String, String> entry : question.getQuestionAndAnswerMap().entrySet()) {

            String key = entry.getKey();
            if (entry.getValue().equalsIgnoreCase(question.getQuestionAndUserAnswerMap().get(key))) {
                score++;
            }
        }
        return score;
    }
}
