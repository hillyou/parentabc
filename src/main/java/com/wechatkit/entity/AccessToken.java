/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author youguilin
 */
@JsonAutoDetect
public class AccessToken extends BaseResponse implements Serializable {

    private static final long serialVersionUID = 2956765325043600693L;

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    private TimeUnit expiresUnit = TimeUnit.SECONDS;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public TimeUnit getExpiresUnit() {
        return expiresUnit;
    }

    public void setExpiresUnit(TimeUnit expiresUnit) {
        this.expiresUnit = expiresUnit;
    }

    @Override
    public String toString() {
        return "AccessToken{" + "accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", expiresUnit=" + expiresUnit + '}';
    }

}
