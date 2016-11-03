/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user;

import com.wechatkit.entity.UserDetail;
import com.wechatkit.entity.UsersDetail;
import com.wechatkit.entity.WeChatUser;
import com.wechatkit.user.dto.UserDetailReq;
import java.util.List;

/**
 *
 * @author youguilin
 */
public interface IUserManager {

    WeChatUser getUserList(String nextId);

    UserDetail getUserDetail(UserDetailReq req);

    UsersDetail getUsersDetail(List<UserDetailReq> users);

}
