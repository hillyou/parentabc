/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechatkit.user.dto.UserDetailReq;
import com.wechatkit.user.dto.UserDetailReqs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author youguilin
 */
public class JacksonSeriTest {

    private final UserDetailReq req = new UserDetailReq();
    private final UserDetailReq req1 = new UserDetailReq();

    public JacksonSeriTest() {
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
        req1.setOpenid("aaaaaaaaaaaaa");
        req1.setLang("zh");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testSeri() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserDetailReq> reqs = new ArrayList<>();
        reqs.add(req);
        reqs.add(req1);
        UserDetailReqs aa = new UserDetailReqs(reqs);
        mapper.writeValue(System.out, aa);
    }

}
