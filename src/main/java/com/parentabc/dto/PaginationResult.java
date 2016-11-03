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
 * @param <T>
 */
public interface PaginationResult<T> extends Serializable {

    public List<T> getData();

    public int getTotalCount();

    public int getPageCount();

    public int getPageSize();

    public int getCurrPage();

    public int getStartIndex();

    public int getEndIndex();

    public List<PaginationOrder> getOrderBy();

    public int getTotalPages();

    public int getFirstPageNum();

    public int getLastPageNum();

    public boolean isFirstPage();

    public boolean isLastPage();

    public boolean isHasPreviousPage();

    public boolean isHasNextPage();
}
