/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.menu.impl;

import com.wechatkit.base.IAccessTokenHolder;
import com.wechatkit.entity.BaseResponse;
import com.wechatkit.menu.IMenuManager;
import com.wechatkit.menu.dto.Menus;
import com.wechatkit.menu.service.MenuService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class MenuManagerImpl implements IMenuManager {

    private static final Logger LOG = LoggerFactory.getLogger(MenuManagerImpl.class);
    @Resource(name = "weChatMenuService")
    private MenuService menuService;
    @Autowired
    private IAccessTokenHolder accessTokenHolder;

    @Override
    public boolean createMenu(Menus menus) {
        String token = accessTokenHolder.getAccessToken();
        BaseResponse response = menuService.createMenu(token, menus);
        LOG.info("Create menu result: {}", response);
        return !response.hasError();
    }

}
