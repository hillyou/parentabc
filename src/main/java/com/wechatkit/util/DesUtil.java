/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author youguilin
 */
public class DesUtil {

    private static final Logger LOG = LoggerFactory.getLogger(DesUtil.class);

    public static String decrypt(String value, int saltLength) {
        LOG.debug("Decrypting original value is {}", value);
        if (saltLength <= 0) {
            LOG.debug("No decrypting executed, returning original value {}", value);
            return value;
        }
        String positions = value.substring(value.length() - saltLength);
        String source = value.substring(0, value.length() - saltLength);
        for (int i = 0; i < positions.length(); i++) {
            int position = Integer.parseInt(String.valueOf(positions.charAt(i)));
            String replaceStr = getPositionValue(source, position);
            source = source.replaceFirst(replaceStr, "");
        }
        LOG.debug("Decrypted value is {}", source);
        return source;
    }

    public static String encrypt(String value) {
        return value;
    }

    private static String getPositionValue(String source, int position) {
        return source.substring(position, position * 2);
    }

}
