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
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.apache.commons.lang.StringUtils;
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

    /**
     * 获取访问者IP
     *
     * 在一般情况下使用Request.getRemoteAddr()即可，但是经过nginx等反向代理软件后，这个方法会失效。
     *
     * 本方法先从Header中获取X-Real-IP，如果不存在再从X-Forwarded-For获得第一个IP(用,分割)， 如果还不存在则调用Request .getRemoteAddr()。
     *
     * @param request
     * @return
     */
    private static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }
}
