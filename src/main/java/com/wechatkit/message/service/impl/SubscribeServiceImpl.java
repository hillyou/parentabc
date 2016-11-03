/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.message.service.impl;

import com.parentabc.service.IRegistrationService;
import com.wechatkit.message.dto.SubscribeReqMsg;
import com.wechatkit.message.service.SubscribeService;
import com.wechatkit.util.ConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class SubscribeServiceImpl implements SubscribeService {

    private static final Logger LOG = LoggerFactory.getLogger(SubscribeServiceImpl.class);
    private static final String OK = "OK";
    private static final String ERROR = "ERROR";
    @Autowired
    private IRegistrationService registrationService;

    @Override
    public String subscribe(String reqMsg) {
        SubscribeReqMsg msg = ConverterUtil.convertToEntity(reqMsg, SubscribeReqMsg.class);
        if (msg == null) {
            LOG.error("Could not process subscribe event message: {}", reqMsg);
            return ERROR;
        }
        return subscribe(msg);
    }

    private String subscribe(SubscribeReqMsg msg) {
        registrationService.subscribe(msg);
        return OK;
    }

    @Override
    public String unsubscribe(SubscribeReqMsg reqMsg) {
        LOG.info("Got unsubscribe message: {}", reqMsg);
        return OK;
    }

}
