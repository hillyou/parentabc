/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.controller;

import com.parentabc.entity.MemberUser;
import com.parentabc.service.IUserService;
import com.wechatkit.base.IMsgValidation;
import com.wechatkit.util.Constants;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author youguilin
 */
@Controller
@RequestMapping(value = {"/validate", "/test"})
public class ValidationSourceController {

    @Autowired
    private IMsgValidation msgValidation;
    @Autowired
    private IUserService userService;

    @ResponseBody
    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public String validateResource(HttpServletRequest request, @RequestParam(Constants.ECHOSTR) String echostr) {
        Map<String, String[]> paramMap = request.getParameterMap();
        boolean isValid = msgValidation.validate(paramMap);
        return isValid ? echostr : "error";
    }

    @ResponseBody
    @RequestMapping(value = "/tokenvalidation", method = {RequestMethod.GET, RequestMethod.POST})
    public String validateToken(HttpServletRequest request) {
        String openId = request.getParameter("openid");
        if (openId != null && !openId.isEmpty()) {
            MemberUser memberUser = userService.getById(openId);
            if (memberUser != null) {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", memberUser);
                session.setAttribute("currentUserId", memberUser.getId());
            }
        }
        Map<String, String[]> paramMap = request.getParameterMap();
        boolean isValid = msgValidation.validate(paramMap);
        return String.valueOf(isValid);
    }
}
