/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user.impl;

import com.wechatkit.entity.UserDetail;
import com.wechatkit.entity.UsersDetail;
import com.wechatkit.entity.WeChatUser;
import com.wechatkit.user.IUserManager;
import com.wechatkit.user.dto.UserDetailReq;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author youguilin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class UserManagerImplTest {

    @Autowired
    private IUserManager instance;
    private final UserDetailReq req = new UserDetailReq();

    public UserManagerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        req.setOpenid("o5ZaIw8spFQm9-XDCtjNekeYUVrw");
        req.setLang("en");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetUserList() {
        System.out.println("getUserList");
        String nextId = "";
        WeChatUser result = instance.getUserList(nextId);
        assertNotNull(result);
        assertTrue(result.getTotal() > 0);
        assertTrue(result.getCount() > 0);
        assertNotNull(result.getUsersInfo());
    }

    @Test
    public void testGetUserDetail() {
        System.out.println("getUserDetail");
        UserDetail result = instance.getUserDetail(req);
        assertNotNull(result);
    }

    @Test
    public void testGetUsersDetail() {
        System.out.println("getUsersDetail");
        List<UserDetailReq> reqs = new ArrayList<>();
        reqs.add(req);
        UsersDetail result = instance.getUsersDetail(reqs);
        assertNotNull(result);
    }
}
