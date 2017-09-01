package com.totaljobsgroup.quiz.controller;

import com.totaljobsgroup.quiz.model.Question;
import com.totaljobsgroup.quiz.model.QuizForm;
import com.totaljobsgroup.quiz.service.BasicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.*;

/**
 * Question Controller class
 */
@Controller
public class QuestionController {

    @Autowired
    private BasicQuestionService basicQuestionService;

    @ModelAttribute("quizForm")
    public QuizForm loadEmptyModelQuizForm(){ return new QuizForm(); }

    @ModelAttribute("score")
    public Integer loadEmptyModelScore(){
        return 0;
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String getQuestions(Model model) {
        model.addAttribute("questionList", basicQuestionService.getQuestions());
        return "questions";
    }

    @RequestMapping(value = "/score", method = RequestMethod.POST)
    public String submitAnswers(@ModelAttribute("quizForm") QuizForm quizForm , BindingResult result, Model model) {

        List<String> userAnswerList = new ArrayList<>();
        try {
            userAnswerList = Arrays.asList(quizForm.getAnswers());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Question question = basicQuestionService.setQuestionObject(userAnswerList);
        int score = basicQuestionService.calculateScore(question);

        model.addAttribute("score", score);
        model.addAttribute("total", basicQuestionService.getQuestions().size());
        return "score";
    }

}

