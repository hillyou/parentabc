/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.entity.MemberUser;
import com.parentabc.service.IRegistrationService;
import com.wechatkit.entity.UserDetail;
import com.wechatkit.message.dto.SubscribeReqMsg;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
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
public class RegistrationServiceImplTest {

    @Autowired
    private IRegistrationService instance;

    public RegistrationServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSubscribe() {
        System.out.println("subscribe");
        SubscribeReqMsg msg = null;
        RegistrationServiceImpl instance = new RegistrationServiceImpl();
        instance.subscribe(msg);
    }

    @Test
    public void testUnsubscribe() {
        System.out.println("unsubscribe");
        SubscribeReqMsg msg = null;
        RegistrationServiceImpl instance = new RegistrationServiceImpl();
        instance.unsubscribe(msg);
    }

    @Test
    public void testRegist_UserDetail() {
        System.out.println("regist");
        UserDetail userDetail = null;
        RegistrationServiceImpl instance = new RegistrationServiceImpl();
        instance.regist(userDetail);
    }

    @Test
    public void testRegist_MemberUser() {
        System.out.println("regist");
        MemberUser user = new MemberUser();
//        user.setId(100);
        user.setAddress("aaa");
        user.setCity("shanghai");
        user.setCountry("China");
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        user.setEmail("aaaa@test.com");
        user.setHeadimgurl("image header");
        user.setLang("en");
        user.setMobile("231231");
        user.setNickname("nick");
        user.setOpenid("bbbbbbbb");
        user.setProvince("shanghai");
        user.setSex("1");
        user.setUnionid("uid");
        user.setStatus(1);
        user.setSubscribe(1);
        user.setUsername("username");
        user.setPasswd("aaaa");
        user.setVersion(0);
        user.setPoints(0);
        instance.regist(user);
        System.out.println("saved user id is: " + user.getId());
    }

}
