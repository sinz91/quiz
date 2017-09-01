package com.totaljobsgroup.quiz.repository;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Tests for Question Repository
 */

public class QuestionRepositoryTest {

    @Test
    public void findAll_should_return_questions(){
        // given
        StaticQuestionRepository questionRepository = new StaticQuestionRepository();

        // when
        List<String> questions = questionRepository.findAll();

        // then
        assertNotNull(questions);
        assertEquals(4, questions.size());
    }

    @Test
    public void getAnswers_should_return_Answers(){
        // given
        StaticQuestionRepository questionRepository = new StaticQuestionRepository();

        // when
        List<String> answers = questionRepository.getAnswers();

        // then
        assertNotNull(answers);
        assertEquals(4, answers.size());
    }
}
