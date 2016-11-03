/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author youguilin
 */
public class UsersInfo implements Serializable {

    private static final long serialVersionUID = -5079152392366861223L;

    private List<String> openid;

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }

    public String getFirstOpenId() {
        if (openid != null && !openid.isEmpty()) {
            return openid.get(0);
        }
        return null;
    }

    public String getOpenId(int index) {
        if (openid != null && !openid.isEmpty() && openid.size() > index) {
            return openid.get(index);
        }
        return null;
    }

    public String getLastOpenId() {
        if (openid != null && !openid.isEmpty()) {
            return openid.get(openid.size() - 1);
        }
        return null;
    }

}
