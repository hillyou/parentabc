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
public class Menu implements Serializable {

    private static final long serialVersionUID = 5475805593112570273L;

    private String type;
    private String name;
    private String key;
    private String url;
    @JsonProperty("sub_button")
    private List<Menu> subMenus;

    public Menu() {
    }

    public Menu(String name) {
        this.name = name;
    }

    public Menu(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Menu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<Menu> subMenus) {
        this.subMenus = subMenus;
    }

    public void addSubMenu(Menu subMenu) {
        if (subMenus == null) {
            subMenus = new ArrayList<>();
        }
        subMenus.add(subMenu);
    }
}
