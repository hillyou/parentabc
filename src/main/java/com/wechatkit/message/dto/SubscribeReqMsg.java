/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.message.dto;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author youguilin
 */
@XmlType(name = "xml")
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscribeReqMsg implements Serializable {

    private static final long serialVersionUID = -3582756225654571357L;
    @XmlElement(name = "ToUserName")
    private String toUserName;	//开发者微信号
    @XmlElement(name = "FromUserName")
    private String FromUserName;	//发送方帐号（一个OpenID）
    @XmlElement(name = "CreateTime")
    private long createTime;	//消息创建时间 （整型）
    @XmlElement(name = "MsgType")
    private String msgType;	//消息类型，event
    @XmlElement(name = "Event")
    private String event;	//事件类型，subscribe
    @XmlElement(name = "EventKey")
    private String eventKey;	//事件KEY值，qrscene_为前缀，后面为二维码的参数值
    @XmlElement(name = "Ticket")
    private String ticket; //二维码的ticket，可用来换取二维码图片

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "SubscribeReqMsg{" + "toUserName=" + toUserName + ", fromUserName=" + FromUserName + ", createTime=" + createTime + ", msgType=" + msgType + ", event=" + event + ", eventKey=" + eventKey + ", ticket=" + ticket + '}';
    }

}
