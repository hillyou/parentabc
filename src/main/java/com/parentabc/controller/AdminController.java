/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.controller;

import com.parentabc.entity.MemberUser;
import com.parentabc.entity.Question;
import com.parentabc.service.IQuestionService;
import com.parentabc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author youguilin
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IQuestionService questionService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView gotoAdmin() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping(value = "/user/block/{userId}", method = RequestMethod.PATCH)
    public ModelAndView blockUser(@PathVariable("userId") int userId) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (userId > 0) {
            MemberUser user = userService.getById(userId);
            if (user != null) {
                user.setStatus(9);
                userService.updateUser(user);
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/question/block/{quesId}", method = RequestMethod.PATCH)
    public ModelAndView blockQues(@PathVariable("quesId") int quesId) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (quesId > 0) {
            Question question = questionService.getQuesSimple(quesId);
            if (question != null) {
                question.setStatus(9);
                questionService.updateQuestion(question);
            }
        }
        return modelAndView;
    }

}
