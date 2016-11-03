/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user.dto;

import java.io.Serializable;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

/**
 *
 * @author youguilin
 */
public class UserDetailReq implements Serializable {

    private static final long serialVersionUID = 5601187810257431408L;
    @QueryParam("openid")
    private String openid;
    @DefaultValue("zh_CN")
    @QueryParam("lang")
    private String lang;

    public UserDetailReq() {
    }

    public UserDetailReq(String openid, String lang) {
        this.openid = openid;
        this.lang = lang;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

}
