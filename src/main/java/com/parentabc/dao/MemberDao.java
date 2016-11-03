/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dao;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.entity.MemberUser;
import java.util.List;

/**
 *
 * @author youguilin
 */
public interface MemberDao {

    MemberUser getUser(int userId);

    MemberUser getUserByOpenId(String openid);

    List<MemberUser> getUsersByPage(BasePageQueryReq pageQueryReq);

    void saveUser(MemberUser user);

    void updateUser(MemberUser user);

    void update4Unsubscribe(MemberUser user);
}
