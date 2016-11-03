/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base;

import java.util.Map;

/**
 *
 * @author youguilin
 */
public interface IMsgValidation {

    boolean validate(Map<String, String[]> params);

}
