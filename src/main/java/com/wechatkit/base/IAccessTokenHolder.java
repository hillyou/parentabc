/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base;

/**
 *
 * @author youguilin
 */
public interface IAccessTokenHolder {

    String getAccessToken();

    int getExpiresIn();

}
