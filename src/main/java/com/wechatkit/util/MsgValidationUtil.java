/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author youguilin
 */
public class MsgValidationUtil {

    private static final Logger LOG = LoggerFactory.getLogger(MsgValidationUtil.class);

    public static boolean isMatchSignature(String token, String timestamp, String nonce, String expectedSignature) {
        String resultSignature = getSignature(token, timestamp, nonce);
        LOG.info("Expected signature is {}", expectedSignature);
        return resultSignature.equals(expectedSignature);
    }

    public static String getSignature(String token, String timestamp, String nonce) {
        LOG.debug("token={}, timestamp={}, nonce={}", token, timestamp, nonce);
        String[] params = new String[]{token, timestamp, nonce};
        List<String> paramList = Arrays.asList(params);
        Collections.sort(paramList);
        StringBuilder paramBuilder = new StringBuilder();
        for (String param : paramList) {
            paramBuilder.append(param);
        }
        return SHA1(paramBuilder.toString());
    }

    public static String SHA1(String inStr) {
        String outStr = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");     //选择SHA-1，也可以选择MD5
            byte[] digest = md.digest(inStr.getBytes());       //返回的是byet[]，要转化为String存储比较方便
            outStr = bytetoString(digest);
            LOG.info("Convert byte array to String by method, result {}", outStr);
        } catch (NoSuchAlgorithmException nsae) {
            LOG.error("SHA1加密算法出错", nsae);
        }
        return outStr;
    }

    private static String bytetoString(byte[] digest) {
        StringBuilder str = new StringBuilder();
        String tempStr;
        for (int i = 0; i < digest.length; i++) {
            tempStr = (Integer.toHexString(digest[i] & 0xff));
            if (tempStr.length() == 1) {
                str.append("0");
            }
            str.append(tempStr);
        }
        return str.toString().toLowerCase();
    }

}
