/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dto;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author youguilin
 */
public interface Pagination extends Serializable {

    public static final int DEFAULT_PAGE_SIZE = 10; // 每页显示的记录数

    public void setPageSize(int pageSize);

    public void setCurrPage(int pageNum);

    public void setOrderBy(List<PaginationOrder> orderBy);

    public Pagination createNextPage();
}
