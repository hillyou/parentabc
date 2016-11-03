/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dao.MemberDao;
import com.parentabc.entity.MemberUser;
import com.parentabc.service.IRegistrationService;
import com.wechatkit.entity.UserDetail;
import com.wechatkit.message.dto.SubscribeReqMsg;
import com.wechatkit.user.IUserManager;
import com.wechatkit.user.dto.UserDetailReq;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class RegistrationServiceImpl implements IRegistrationService {

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private IUserManager userManager;

    @Override
    public void subscribe(SubscribeReqMsg msg) {
        UserDetailReq req = new UserDetailReq();
        LOG.info("User openid {} subscribing", msg.getFromUserName());
        req.setOpenid(msg.getFromUserName());
        UserDetail userDetail = userManager.getUserDetail(req);
        regist(userDetail);
    }

    public void unsubscribe(SubscribeReqMsg msg) {
        MemberUser user = new MemberUser();
        LOG.info("User openid {} unsubscribing", msg.getFromUserName());
        user.setOpenid(msg.getFromUserName());
        user.setUpdateDate(new Date());
        memberDao.update4Unsubscribe(user);
    }

    @Override
    public void regist(UserDetail userDetail) {
        MemberUser user = new MemberUser();
        String[] ignoreProperties = new String[]{};
        BeanUtils.copyProperties(userDetail, user, ignoreProperties);
        regist(user);
    }

    @Override
    public void regist(MemberUser user) {
        String openid = user.getOpenid();
        MemberUser oldUser = memberDao.getUserByOpenId(openid);
        if (oldUser == null) {
            LOG.info("user openid {} is not found, going to create", openid);
            memberDao.saveUser(user);
        } else {
            LOG.info("user openid {} existed, going to update", openid);
            MemberUser newUser = new MemberUser();
            String[] ignoreProperties = new String[]{"id"};
            BeanUtils.copyProperties(newUser, oldUser, ignoreProperties);
            memberDao.updateUser(user);
        }
    }

}
