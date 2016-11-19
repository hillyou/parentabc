/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author youguilin
 */
public class BasePageQueryReq extends BasePaginationReq {

    private static final long serialVersionUID = 6211309387183737611L;
    private List<Integer> statusList;
    private String nickname;
    private int type;
    private Date beginDate;
    private Date endDate;
    private Date updateBegin;
    private Date updateEnd;
    private String byContent;
    private String byName;

    public String getQueryName() {
        return byName != null && !byName.isEmpty() ? "byName" : "byContent";
    }

    public String getQueryValue() {
        return byName != null && !byName.isEmpty() ? byName : byContent;
    }

    public String getByContent() {
        return byContent;
    }

    public void setByContent(String byContent) {
        this.byContent = byContent;
    }

    public String getByName() {
        return byName;
    }

    public void setByName(String byName) {
        this.byName = byName;
    }

    public List<Integer> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Integer> statusList) {
        this.statusList = statusList;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getUpdateBegin() {
        return updateBegin;
    }

    public void setUpdateBegin(Date updateBegin) {
        this.updateBegin = updateBegin;
    }

    public Date getUpdateEnd() {
        return updateEnd;
    }

    public void setUpdateEnd(Date updateEnd) {
        this.updateEnd = updateEnd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
