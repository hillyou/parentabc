/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.base.service;

import com.wechatkit.entity.AccessToken;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author youguilin
 */
@WebService
@Path("/token")
public interface AccessTokenService {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public AccessToken getToken(@QueryParam("grant_type") String grantType,
            @QueryParam("appid") String appid,
            @QueryParam("secret") String secret);
}
