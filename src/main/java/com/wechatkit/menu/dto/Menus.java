/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.menu.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youguilin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Menus implements Serializable {

    private static final long serialVersionUID = -1618394268203979850L;

    @JsonProperty("button")
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        if (menus == null) {
            menus = new ArrayList<>();
        }
        menus.add(menu);
    }
}
