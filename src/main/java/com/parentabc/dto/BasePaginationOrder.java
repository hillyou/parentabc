/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dto;

/**
 *
 * @author youguilin
 */
public class BasePaginationOrder implements PaginationOrder {

    private static final long serialVersionUID = -3404412506810970969L;

    private String property;
    private boolean isAsc;

    public BasePaginationOrder(String property, boolean isAsc) {
        this.property = property;
        this.isAsc = isAsc;
    }

    @Override
    public void setSortProperty(String property, boolean isAsc) {
        this.property = property;
        this.isAsc = isAsc;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isIsAsc() {
        return isAsc;
    }

    public void setIsAsc(boolean isAsc) {
        this.isAsc = isAsc;
    }

    @Override
    public String getOrderByStr() {
        return property + " " + (this.isAsc ? "asc" : "desc");
    }

}
