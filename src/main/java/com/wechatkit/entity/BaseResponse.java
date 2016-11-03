/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 *
 * @author youguilin
 */
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = -8132039654632576116L;
    private static final String SUCCESS_CODE = "0";
    private static final String SUCCESS_MSG = "ok";
    @JsonProperty("errcode")
    private String errCode;
    @JsonProperty("errmsg")
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public boolean hasError() {
        return !((errCode == null || SUCCESS_CODE.equals(errCode)) && (errMsg == null || SUCCESS_MSG.equals(errMsg)));
    }
}
