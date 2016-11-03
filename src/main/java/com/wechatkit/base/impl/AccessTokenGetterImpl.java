/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base.impl;

import com.wechatkit.base.IAccessTokenGetter;
import com.wechatkit.base.service.AccessTokenService;
import com.wechatkit.entity.AccessToken;
import com.wechatkit.util.DesUtil;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class AccessTokenGetterImpl implements IAccessTokenGetter {

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenGetterImpl.class);
    @Resource(name = "accessTokenService")
    private AccessTokenService accessTokenService;
    @Value("${grant_type}")
    private String grantType;
    @Value("${appid}")
    private String appid;
    @Value("${appsecret}")
    private String secret;
    @Value("${salt_length}")
    private int saltLength;

    @Override
    public AccessToken getAccessToken() {
        String appIdValue = DesUtil.decrypt(appid, saltLength);
        String secretValue = DesUtil.decrypt(secret, saltLength);
        LOG.info("Requesting new access token");
        AccessToken accessToken = accessTokenService.getToken(grantType, appIdValue, secretValue);
        if (accessToken.getAccessToken() == null || accessToken.getAccessToken().isEmpty()) {
            LOG.error("Request access token failed {}:{}", accessToken.getErrCode(), accessToken.getErrMsg());
            throw new IllegalStateException("Request access token failed");
        }
        return accessToken;
    }

}
