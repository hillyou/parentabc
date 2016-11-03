/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base;

import com.wechatkit.util.MsgValidationUtil;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author youguilin
 */
public class MsgValidationTest {

    public MsgValidationTest() {
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
    public void testGetSignature() {
        System.out.println("getSignature");
        String token = "abc";
        String timestamp = "123";
        String nonce = "dadfd";
        String result = MsgValidationUtil.getSignature(token, timestamp, nonce);
        assertNotNull(result);
    }

}
