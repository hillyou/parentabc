/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author youguilin
 */
public class WeChatUser extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -5443149634407049366L;

    private int total;
    private int count;
    @JsonProperty("data")
    private UsersInfo usersInfo;
    @JsonProperty("next_openid")
    private String nextOpenId;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public UsersInfo getUsersInfo() {
        return usersInfo;
    }

    public void setUsersInfo(UsersInfo usersInfo) {
        this.usersInfo = usersInfo;
    }

    public String getNextOpenId() {
        return nextOpenId;
    }

    public void setNextOpenId(String nextOpenId) {
        this.nextOpenId = nextOpenId;
    }

    public boolean hasNextUser() {
        return total > 0 && total > count;
    }

}
