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
@XmlRootElement
@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class SubscribeResMsg implements Serializable {

    private static final long serialVersionUID = 7140030895175631316L;
    @XmlElement(name = "code")
    private String code;

    public SubscribeResMsg() {
    }

    public SubscribeResMsg(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
