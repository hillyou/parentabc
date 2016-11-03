/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.menu.service;

import com.wechatkit.entity.BaseResponse;
import com.wechatkit.menu.dto.Menus;
import javax.jws.WebService;
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
@Path("/menu")
public interface MenuService {

    @POST
    @Path("/create")
    @Produces({MediaType.APPLICATION_JSON})
    public BaseResponse createMenu(@QueryParam("access_token") String accessToken, Menus menus);
}
