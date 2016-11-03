/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.controller;

import com.parentabc.entity.Answer;
import com.parentabc.service.IAnswerService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author youguilin
 */
@Controller
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private IAnswerService answerService;

    @RequestMapping(value = "/answerques", method = RequestMethod.POST)
    public ModelAndView askQuestion(@Valid @ModelAttribute("answer") Answer answer, BindingResult result) {
        answerService.answerQues(answer);
        ModelAndView modelAndView = new ModelAndView("message");
        modelAndView.addObject("message", "感谢你的解答");
        return modelAndView;
    }

}
