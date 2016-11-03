/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author youguilin
 */
public class UsersDetail extends BaseResponse implements Serializable {

    private static final long serialVersionUID = -7715002863323751990L;

    @JsonProperty("user_info_list")
    private List<UserDetail> usersDetail;

    public List<UserDetail> getUsersDetail() {
        return usersDetail;
    }

    public void setUsersDetail(List<UserDetail> usersDetail) {
        this.usersDetail = usersDetail;
    }

}
