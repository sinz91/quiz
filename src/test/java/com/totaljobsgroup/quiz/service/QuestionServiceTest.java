package com.totaljobsgroup.quiz.service;
import com.totaljobsgroup.quiz.model.Question;
import com.totaljobsgroup.quiz.repository.StaticQuestionRepository;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Tests for Question Service
 */
public class QuestionServiceTest {

    @Test
    public void findAll_should_return_questions(){
        // given
        StaticQuestionRepository mockQuestionRepository = mock(StaticQuestionRepository.class);
        BasicQuestionService questionService = new BasicQuestionService(mockQuestionRepository);

        // when
        List<String> questions = questionService.getQuestions();

        // then
        assertNotNull(questions);
    }

    @Test
    public void getAnswers_should_return_answers(){
        // given
        StaticQuestionRepository mockQuestionRepository = mock(StaticQuestionRepository.class);
        BasicQuestionService questionService = new BasicQuestionService(mockQuestionRepository);

        // when
        List<String> questions = new ArrayList<>();
        questions.add("What is the capital of Cuba?");
        questions.add("What is the capital of France?");
        questions.add("What is the capital of Poland?");
        questions.add("What is the capital of Germany?");

        HashMap<String, String> questionAndAnswers = questionService.getAnswers(questions);

        // then
        assertNotNull(questionAndAnswers);
    }

    @Test
    public void setQuestionObject_should_return_QuestionObject(){
        // given
        StaticQuestionRepository mockQuestionRepository = mock(StaticQuestionRepository.class);
        BasicQuestionService questionService = new BasicQuestionService(mockQuestionRepository);

        // when
        List<String> userAnswers = new ArrayList<>();
        userAnswers.add("Havana");
        userAnswers.add("PARIS");
        userAnswers.add("answer");
        userAnswers.add("berlin");
        Question question = questionService.setQuestionObject(userAnswers);

        // then
        assertNotNull(question);
    }

    @Test
    public void calculateScore_should_return_score(){
        // given
        StaticQuestionRepository mockQuestionRepository = mock(StaticQuestionRepository.class);
        BasicQuestionService questionService = new BasicQuestionService(mockQuestionRepository);

        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>();

        map1.put("What is the capital of Cuba?", "Havana");
        map1.put("What is the capital of France?", "Havana");
        map2.put("What is the capital of Cuba?", "havana");
        map2.put("What is the capital of France?", "");

        // when
        Question question = new Question(map1, map2);
        int score = questionService.calculateScore(question);

        // then
        assertEquals(1, score);
        assertNotEquals(0, score);
    }
}
