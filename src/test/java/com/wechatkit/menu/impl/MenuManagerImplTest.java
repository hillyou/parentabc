/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.menu.impl;

import com.wechatkit.menu.IMenuManager;
import com.wechatkit.menu.dto.Menu;
import com.wechatkit.menu.dto.Menus;
import org.junit.After;
import org.junit.AfterClass;
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
public class MenuManagerImplTest {

    @Autowired
    private IMenuManager instance;
    private Menus menus = new Menus();

    public MenuManagerImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        Menu menu = new Menu("click", "今日歌曲");
        menu.setKey("V1001_TODAY_MUSIC");
        menus.addMenu(menu);
        Menu menu1 = new Menu("菜单");
        Menu submenu1 = new Menu("view", "搜索");
        submenu1.setUrl("http://www.sessionfactory.com/");
        menu1.addSubMenu(submenu1);

        Menu submenu2 = new Menu("view", "视频");
        submenu2.setUrl("http://www.sessionfactory.com/");
        menu1.addSubMenu(submenu2);

        Menu submenu3 = new Menu("click", "赞一下我们");
        submenu3.setKey("V1001_GOOD");
        menu1.addSubMenu(submenu3);

        menus.addMenu(menu1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreateMenu() {
        System.out.println("createMenu");
        boolean result = instance.createMenu(menus);
        assertTrue(result);
    }

}
