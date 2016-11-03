/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.controller;

import com.wechatkit.base.IMsgValidation;
import com.wechatkit.util.Constants;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/validate")
public class ValidationSourceController {

    @Autowired
    private IMsgValidation msgValidation;

    @ResponseBody
    @RequestMapping(value = "/resource", method = RequestMethod.GET)
    public String validateResource(HttpServletRequest request, @RequestParam(Constants.ECHOSTR) String echostr) {
        Map<String, String[]> paramMap = request.getParameterMap();
        boolean isValid = msgValidation.validate(paramMap);
        return isValid ? echostr : "error";
    }
}
