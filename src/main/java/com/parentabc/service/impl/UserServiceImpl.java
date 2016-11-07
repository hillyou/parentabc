/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dao.MemberDao;
import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.MemberUser;
import com.parentabc.service.IUserService;
import com.parentabc.util.DateUtils;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class UserServiceImpl extends AbstractPageService implements IUserService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public MemberUser getById(int id) {
        return memberDao.getUser(id);
    }

    @Override
    public BasePaginationResult<MemberUser> getUsersByPage(BasePageQueryReq pageQueryReq) {
        super.beforeQuery(pageQueryReq);
        List<MemberUser> refundList = memberDao.getUsersByPage(pageQueryReq);
        return super.postQuery(refundList);
    }

    @Override
    public void updateUser(MemberUser user) {
        memberDao.updateUser(user);
    }

    @Override
    public MemberUser getById(String openid) {
        return memberDao.getUserByOpenId(openid);
    }

    /**
     * *
     * 获取用户数量总量及今天新增数量
     *
     * @return
     */
    public BasePaginationResult<MemberUser> getIncreamUsers() {
        BasePageQueryReq req = new BasePageQueryReq();
        Date beginDate = DateUtils.getDateWithoutTime(new Date());
        req.setBeginDate(beginDate);
        req.setPageSize(Integer.MAX_VALUE);
        return getUsersByPage(req);
    }
}
