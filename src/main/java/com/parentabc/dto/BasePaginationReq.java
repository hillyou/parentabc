/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author youguilin
 */
public class BasePaginationReq implements Pagination {

    private static final long serialVersionUID = -2744286468848511102L;

    private int pageSize = Pagination.DEFAULT_PAGE_SIZE;

    private int currPage;

    private List<PaginationOrder> orderBy;

    public BasePaginationReq() {
        this(1);
    }

    public BasePaginationReq(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<PaginationOrder> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<PaginationOrder> orderBy) {
        this.orderBy = orderBy;
    }

    public void addOrderBy(PaginationOrder order) {
        if (this.orderBy == null) {
            this.orderBy = new ArrayList<>();
        }
        this.orderBy.add(order);
    }

    public void addOrderBy(String property) {
        this.addOrderBy(new BasePaginationOrder(property, true));
    }

    public void addOrderBy(String property, boolean isAsc) {
        this.addOrderBy(new BasePaginationOrder(property, isAsc));
    }

    public String getOrderByStr() {
        if (this.orderBy == null || this.orderBy.isEmpty()) {
            return "";
        }
        StringBuilder orderByStr = new StringBuilder();
        int size = this.orderBy.size();
        for (int i = 0; i < size; i++) {
            PaginationOrder orderEntity = this.orderBy.get(i);
            orderByStr.append(orderEntity.getOrderByStr());
            if (i < size - 1) {
                orderByStr.append(", ");
            }
        }
        return orderByStr.toString();
    }

    @Override
    public String toString() {
        return " pageSize=" + pageSize + ", currPage=" + currPage + ", orderBy=" + orderBy;
    }

    public Pagination createNextPage() {
        BasePaginationReq nextPage = new BasePaginationReq();
        nextPage.setCurrPage(getCurrPage() + 1);
        nextPage.setOrderBy(getOrderBy());
        nextPage.setPageSize(getPageSize());
        return nextPage;
    }
}
