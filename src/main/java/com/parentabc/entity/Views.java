/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.entity;

import java.io.Serializable;

/**
 *
 * @author youguilin
 */
public class Views implements Serializable {

    private static final long serialVersionUID = 7898451906609192590L;

    private int id;
    private int quesId;
    private int viewerId;
    private int times;
    private String viewerIp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuesId() {
        return quesId;
    }

    public void setQuesId(int quesId) {
        this.quesId = quesId;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getViewerId() {
        return viewerId;
    }

    public void setViewerId(int viewerId) {
        this.viewerId = viewerId;
    }

    public String getViewerIp() {
        return viewerIp;
    }

    public void setViewerIp(String viewerIp) {
        this.viewerIp = viewerIp;
    }

}
