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
 * @param <T>
 */
public class BasePaginationResult<T> implements PaginationResult {

    private static final long serialVersionUID = 5487247691823285293L;
    private List<T> data;

    /**
     * 总条数
     */
    private int totalCount;

    /**
     * 总页数
     */
    private int pageCount;

    /**
     * 每页大小
     */
    private int pageSize;

    /**
     * 当前第几页
     */
    private int currPage;

    private int startIndex;

    private int endIndex;

    private List<PaginationOrder> orderBy;

    public int totalPages;

    public int firstPageNum;

    public int lastPageNum;

    public boolean firstPage;

    public boolean lastPage;

    public boolean hasPreviousPage;

    public boolean hasNextPage;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return pageCount;
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

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public List<PaginationOrder> getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(List<PaginationOrder> orderBy) {
        this.orderBy = orderBy;
    }

    public void setOrderBy(String orderByStr) {
        if (orderByStr == null || orderByStr.trim().isEmpty()) {
            return;
        }
        String[] orderBys = orderByStr.split(",");
        List<PaginationOrder> orderByList = new ArrayList<>(orderBys.length);
        for (String localOrderBy : orderBys) {
            String[] proAndOrder = localOrderBy.trim().split("\\s");
            String pro = proAndOrder[0];
            boolean isAsc = true;
            if (proAndOrder.length > 1 && proAndOrder[1].toUpperCase().equals("DESC")) {
                isAsc = false;
            }
            PaginationOrder paginationOrder = new BasePaginationOrder(pro, isAsc);
            orderByList.add(paginationOrder);
        }
        this.orderBy = orderByList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getFirstPageNum() {
        return firstPageNum;
    }

    public void setFirstPageNum(int firstPageNum) {
        this.firstPageNum = firstPageNum;
    }

    public int getLastPageNum() {
        return lastPageNum;
    }

    public void setLastPageNum(int lastPageNum) {
        this.lastPageNum = lastPageNum;
    }

    public boolean isFirstPage() {
        return firstPage;
    }

    public void setFirstPage(boolean firstPage) {
        this.firstPage = firstPage;
    }

    public boolean isLastPage() {
        return lastPage;
    }

    public void setLastPage(boolean lastPage) {
        this.lastPage = lastPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    @Override
    public String toString() {
        return "BasePaginationResult{" + "data=" + data + ", totalCount=" + totalCount + ", pageCount=" + pageCount + ", pageSize=" + pageSize + ", currPage=" + currPage + ", startIndex=" + startIndex + ", endIndex=" + endIndex + ", orderBy=" + orderBy + ", totalPages=" + totalPages + ", firstPageNum=" + firstPageNum + ", lastPageNum=" + lastPageNum + ", firstPage=" + firstPage + ", lastPage=" + lastPage + ", hasPreviousPage=" + hasPreviousPage + ", hasNextPage=" + hasNextPage + '}';
    }

}
