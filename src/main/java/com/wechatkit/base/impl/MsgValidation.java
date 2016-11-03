/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base.impl;

import com.wechatkit.base.IMsgValidation;
import com.wechatkit.util.Constants;
import com.wechatkit.util.MsgValidationUtil;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class MsgValidation implements IMsgValidation {

    private static final Logger LOG = LoggerFactory.getLogger(MsgValidation.class);
    @Value("${wechat.token}")
    private String token;

    @Override
    public boolean validate(Map<String, String[]> params) {
        String[] timestamps = params.get(Constants.TIMESTAMP);
        String timestamp;
        if (timestamps == null || timestamps.length < 1) {
            LOG.warn("Parameter {} is empty", Constants.TIMESTAMP);
            return false;
        }
        timestamp = timestamps[0];
        String[] nonces = params.get(Constants.NONCE);
        String nonce;
        if (nonces == null || nonces.length < 1) {
            LOG.warn("Parameter {} is empty", Constants.NONCE);
            return false;
        }
        nonce = nonces[0];
        String[] expectedSignatures = params.get(Constants.SIGNATURE);
        String expectedSignature;
        if (expectedSignatures == null || expectedSignatures.length < 1) {
            LOG.warn("Parameter {} is empty", Constants.SIGNATURE);
            return false;
        }
        expectedSignature = expectedSignatures[0];
        return MsgValidationUtil.isMatchSignature(token, timestamp, nonce, expectedSignature);
    }

}
