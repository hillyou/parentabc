/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dto;

import java.io.Serializable;

/**
 *
 * @author youguilin
 */
public interface PaginationOrder extends Serializable {

    public void setSortProperty(String property, boolean isAsc);

    public String getOrderByStr();

}
