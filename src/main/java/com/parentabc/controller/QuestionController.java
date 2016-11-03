/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.controller;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.Question;
import com.parentabc.service.IQuestionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author youguilin
 */
@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private IQuestionService questionService;

    @RequestMapping(value = "/gotoask", method = RequestMethod.GET)
    public ModelAndView gotoAskQuestion() {
        ModelAndView modelAndView = new ModelAndView("askques");
        return modelAndView;
    }

    @RequestMapping(value = "/ask", method = RequestMethod.POST)
    public ModelAndView askQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
        questionService.askQuestion(question);
        ModelAndView modelAndView = new ModelAndView("message");
        modelAndView.addObject("message", "提问成功");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getQuestions(BasePageQueryReq req) {
        BasePaginationResult list = questionService.getQuestions(req);
        ModelAndView modelAndView = new ModelAndView("queslist");
        modelAndView.addObject("data", list);
        return modelAndView;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView getQuesDetail(@PathVariable("id") int id) {
        Question detail = questionService.getQuesDetail(id);
        ModelAndView modelAndView = new ModelAndView("quesdetail");
        modelAndView.addObject("data", detail);
        return modelAndView;
    }

}
