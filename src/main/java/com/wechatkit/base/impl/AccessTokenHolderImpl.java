/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base.impl;

import com.wechatkit.base.IAccessTokenGetter;
import com.wechatkit.base.IAccessTokenHolder;
import com.wechatkit.entity.AccessToken;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class AccessTokenHolderImpl implements IAccessTokenHolder {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenHolderImpl.class);
    @Autowired
    private IAccessTokenGetter accessTokenGetter;
    private static AccessToken accessToken = new AccessToken();
    private static Date createDate;

//    @PostConstruct
//    void inital() {
//        createDate = new Date();
//        accessToken.setExpiresIn(7200);
//        accessToken.setAccessToken("NXg1rQnVUFDtIpW6bzAVhd4R5xq2f4Vh3m7bPuNWpmH6tpw2y-HSysgZen3UP73nHp_ZGpuE8hyVDSLLrqOtf-wScNmUnYjPNkiXxV2ljpYh0zfH2t9lzxrAO96GC6_fBAMaAGAFEQ");
//    }
    @Override
    public synchronized String getAccessToken() {
        if (isNeedRefresh()) {
            try {
                createDate = new Date();
                accessToken = accessTokenGetter.getAccessToken();
            } catch (Exception ex) {
                LOG.error("Get access token failed, reason: {}", ex);
                return "";
            }
        }
        return accessToken.getAccessToken();
    }

    @Override
    public int getExpiresIn() {
        if (accessToken == null) {
            throw new IllegalStateException("access token not existed");
        }
        return accessToken.getExpiresIn();
    }

    private boolean isNeedRefresh() {
        if (accessToken == null || createDate == null
                || accessToken.getAccessToken().isEmpty()
                || accessToken.getExpiresIn() <= 0) {
            LOG.info("Access token not existed, need to refresh");
            return true;
        }
        int expiresIn = accessToken.getExpiresIn();
        TimeUnit timeUnit = accessToken.getExpiresUnit();
        long begin = timeUnit.convert(createDate.getTime(), TimeUnit.MILLISECONDS);
        long end = timeUnit.convert(new Date().getTime(), TimeUnit.MILLISECONDS);
        if (end - begin >= expiresIn) {
            LOG.info("Access token expired, token created at {}", createDate);
            return true;
        }
        LOG.info("Access token existed, no need refresh, token: {} created at: {}", accessToken, createDate);
        return false;
    }
}
