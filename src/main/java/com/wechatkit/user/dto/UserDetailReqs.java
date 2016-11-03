/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author youguilin
 */
public class UserDetailReqs implements Serializable {

    private static final long serialVersionUID = 6651566574141176684L;

    @JsonProperty("user_list")
    private List<UserDetailReq> users;

    public UserDetailReqs() {
    }

    public UserDetailReqs(List<UserDetailReq> users) {
        this.users = users;
    }

    public List<UserDetailReq> getUsers() {
        return users;
    }

    public void setUsers(List<UserDetailReq> users) {
        this.users = users;
    }

}
