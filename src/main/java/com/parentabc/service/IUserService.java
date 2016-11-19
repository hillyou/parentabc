/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.MemberUser;

/**
 *
 * @author youguilin
 */
public interface IUserService {

    MemberUser getById(int id);

    MemberUser getById(String openid);

    BasePaginationResult<MemberUser> getUsersByPage(BasePageQueryReq pageQueryReq);

    void updateUser(MemberUser user);

    BasePaginationResult<MemberUser> getIncreamUsers();
}
