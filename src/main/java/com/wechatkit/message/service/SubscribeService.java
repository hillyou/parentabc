/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.message.service;

import com.wechatkit.message.dto.SubscribeReqMsg;
import javax.jws.WebService;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author youguilin
 */
@WebService
@Path("/message")
public interface SubscribeService {

    @POST
    @Path("/subscribe")
    @Consumes({MediaType.TEXT_PLAIN, MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    String subscribe(String reqMsg);

    @POST
    @Path("/unsubscribe")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    String unsubscribe(@BeanParam SubscribeReqMsg reqMsg);
}
