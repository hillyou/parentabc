/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.util;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author youguilin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class DesUtilTest {

    @Value("${appid}")
    private String idEncryptedValue;

    @Value("${original.appid}")
    private String sourceIdValue;

    @Value("${appsecret}")
    private String secretEncryptedValue;

    @Value("${original.appsecret}")
    private String sourceSecretValue;

    public DesUtilTest() {
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
    public void testDecrypt4Id() {
        System.out.println("decrypt");
        String result = DesUtil.decrypt(idEncryptedValue.trim(), 3);
        assertEquals(sourceIdValue.trim(), result);
    }

    @Test
    public void testDecrypt4Secret() {
        System.out.println("decrypt");
        String result = DesUtil.decrypt(secretEncryptedValue.trim(), 3);
        assertEquals(sourceSecretValue.trim(), result);
    }

    @Test
    public void testEncrypt() {
        System.out.println("encrypt");
        String value = "";
        String expResult = "";
        String result = DesUtil.encrypt(value);
        assertEquals(expResult, result);
    }

}
