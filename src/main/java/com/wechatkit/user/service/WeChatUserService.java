/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.user.service;

import com.wechatkit.entity.UserDetail;
import com.wechatkit.entity.UsersDetail;
import com.wechatkit.entity.WeChatUser;
import com.wechatkit.user.dto.UserDetailReq;
import com.wechatkit.user.dto.UserDetailReqs;
import javax.jws.WebService;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author youguilin
 */
@WebService
@Path("/user")
public interface WeChatUserService {

    @GET
    @Path("/get")
    @Produces({MediaType.APPLICATION_JSON})
    public WeChatUser getUserList(@QueryParam("access_token") String accessToken, @QueryParam("next_openid") String nextOpenId);

    @GET
    @Path("/info")
    @Produces({MediaType.APPLICATION_JSON})
    public UserDetail getUserDetail(@QueryParam("access_token") String accessToken, @BeanParam UserDetailReq req);

    @POST
    @Path("/info/batchget")
    @Produces({MediaType.APPLICATION_JSON})
    public UsersDetail getUsersDetail(@QueryParam("access_token") String accessToken, UserDetailReqs data);
}
