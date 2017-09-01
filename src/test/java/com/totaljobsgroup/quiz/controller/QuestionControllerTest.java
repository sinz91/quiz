package com.totaljobsgroup.quiz.controller;

import com.totaljobsgroup.quiz.service.BasicQuestionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for Question Controller
 */
@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BasicQuestionService basicQuestionService;

    @Test
    public void getQuestions() throws Exception {
        // given
        String urlPath = "/questions";

        //when
        ResultActions result = mockMvc.perform(get(urlPath));

        // then
        result.andExpect(status().isOk());
        result.andExpect(model().attributeExists("questionList"));
    }

    @Test
    public void submitAnswers() throws Exception {
        // given
        String urlPath = "/score";
        Object answers[] = new String[]{"havana", "paris", "xyz", "berlin"};

        //when
        ResultActions result = mockMvc.perform(post(urlPath, answers));

        // then
        result.andExpect(status().isOk());
        result.andExpect(model().attributeExists("score"));
        result.andExpect(model().attributeExists("total"));
    }

}
