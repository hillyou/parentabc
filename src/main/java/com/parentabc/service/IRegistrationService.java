/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service;

import com.parentabc.entity.MemberUser;
import com.wechatkit.entity.UserDetail;
import com.wechatkit.message.dto.SubscribeReqMsg;

/**
 *
 * @author youguilin
 */
public interface IRegistrationService {

    void subscribe(SubscribeReqMsg msg);

    void unsubscribe(SubscribeReqMsg msg);

    void regist(UserDetail userDetail);

    void regist(MemberUser user);
}
