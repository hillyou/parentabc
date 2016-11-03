/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user.impl;

import com.wechatkit.base.IAccessTokenHolder;
import com.wechatkit.entity.UserDetail;
import com.wechatkit.entity.UsersDetail;
import com.wechatkit.entity.WeChatUser;
import com.wechatkit.user.IUserManager;
import com.wechatkit.user.dto.UserDetailReq;
import com.wechatkit.user.dto.UserDetailReqs;
import com.wechatkit.user.service.WeChatUserService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class UserManagerImpl implements IUserManager {

    private static final Logger LOG = LoggerFactory.getLogger(UserManagerImpl.class);
    @Resource(name = "weChatUserService")
    private WeChatUserService userService;
    @Autowired
    private IAccessTokenHolder accessTokenHolder;

    @Override
    public WeChatUser getUserList(String nextId) {
        String token = accessTokenHolder.getAccessToken();
        WeChatUser weChatUser = userService.getUserList(token, nextId);
        if (weChatUser.hasError()) {
            LOG.error("Request user id list failed {}:{}", weChatUser.getErrCode(), weChatUser.getErrMsg());
            throw new IllegalStateException("Request user id list failed");
        }
        return weChatUser;
    }

    @Override
    public UserDetail getUserDetail(UserDetailReq req) {
        String token = accessTokenHolder.getAccessToken();
        UserDetail userDetail = userService.getUserDetail(token, req);
        if (userDetail.hasError()) {
            LOG.error("Request user deatil {}:{}", userDetail.getErrCode(), userDetail.getErrMsg());
            throw new IllegalStateException("Request user deatil failed");
        }
        return userDetail;
    }

    @Override
    public UsersDetail getUsersDetail(List<UserDetailReq> users) {
        String token = accessTokenHolder.getAccessToken();
        UserDetailReqs reqs = new UserDetailReqs(users);
        UsersDetail usersDetail = userService.getUsersDetail(token, reqs);
        if (usersDetail.hasError()) {
            LOG.error("Request users deatil {}:{}", usersDetail.getErrCode(), usersDetail.getErrMsg());
            throw new IllegalStateException("Request users deatil failed");
        }
        return usersDetail;
    }

}
