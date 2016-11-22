/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.controller;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.MemberUser;
import com.parentabc.entity.Question;
import com.parentabc.service.IQuestionService;
import com.parentabc.service.IUserService;
import com.parentabc.util.DateUtils;
import java.util.Date;
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
        ModelAndView modelAndView = new ModelAndView("admin/index");
        BasePageQueryReq pageQueryReq = new BasePageQueryReq();
        BasePaginationResult<MemberUser> userList = userService.getUsersByPage(pageQueryReq);
        modelAndView.addObject("users", userList);
        BasePaginationResult<MemberUser> newUserList = userService.getIncreamUsers();
        modelAndView.addObject("newusers", newUserList);
        BasePaginationResult<Question> allQues = questionService.getQuestions(pageQueryReq);
        modelAndView.addObject("questions", allQues);
        BasePaginationResult<Question> newQues = questionService.getIncreamUsers();
        modelAndView.addObject("newquestions", newQues);
        Date beginDate = DateUtils.getDateWithoutTime(new Date());
        pageQueryReq.setBeginDate(beginDate);
        BasePaginationResult<Question> unaQues = questionService.getUnansweredQues(pageQueryReq);
        modelAndView.addObject("unaquestions", unaQues);
        return modelAndView;
    }

    @RequestMapping(value = "/users/block/{userId}", method = RequestMethod.PATCH)
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

    @RequestMapping(value = "/questions/block/{quesId}", method = RequestMethod.PATCH)
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

    @RequestMapping(value = "/questions/unanswered", method = RequestMethod.GET)
    public ModelAndView unaQues() {
        ModelAndView modelAndView = new ModelAndView("admin/unaques");
        BasePageQueryReq pageQueryReq = new BasePageQueryReq();
        Date beginDate = DateUtils.getDateWithoutTime(new Date());
        pageQueryReq.setBeginDate(beginDate);
        BasePaginationResult<Question> unaQues = questionService.getUnansweredQues(pageQueryReq);
        modelAndView.addObject("data", unaQues);
        return modelAndView;
    }
    
    /**
     * show user Point & rank
     * @return
     */
    @RequestMapping(value = "/users/rank", method = RequestMethod.GET)
    public ModelAndView userPoints() {
        ModelAndView modelAndView = new ModelAndView("admin/useranklist");
        BasePageQueryReq pageQueryReq = new BasePageQueryReq();
        BasePaginationResult<MemberUser> userList = userService.getUsersByPage(pageQueryReq);
        modelAndView.addObject("data", userList);
        return modelAndView;
    }
    
    
}
