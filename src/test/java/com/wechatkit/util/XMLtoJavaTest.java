/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.util;

import com.wechatkit.message.dto.SubscribeReqMsg;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author youguilin
 */
public class XMLtoJavaTest {

    public XMLtoJavaTest() {
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
    public void testConvert() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(SubscribeReqMsg.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/test/resources/test.xml");
        SubscribeReqMsg tests = (SubscribeReqMsg) unmarshaller.unmarshal(xml);
        System.out.println(tests);
    }
}
