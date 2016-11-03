/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.dto.Pagination;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author youguilin
 */
public abstract class AbstractPageService {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractPageService.class);

    protected void beforeQuery(BasePageQueryReq pageQueryReq) {
        LOG.info("Query condition: {}", pageQueryReq);
        int pageNum = pageQueryReq.getCurrPage();
        if (pageNum < 1) {
            pageNum = 1;
        }
        int pageSize = pageQueryReq.getPageSize();
        if (pageSize < 1) {
            pageSize = Pagination.DEFAULT_PAGE_SIZE;
        }
        String orderBy = pageQueryReq.getOrderByStr();
        PageHelper.startPage(pageNum, pageSize, orderBy);
    }

    protected BasePaginationResult postQuery(List date) {
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(date);
        return convertToResult(page);
    }

    private BasePaginationResult convertToResult(PageInfo page) {
        BasePaginationResult result = new BasePaginationResult();
        result.setData(page.getList());
        result.setPageSize(page.getPageSize());
        int pageNum = page.getPageNum();
        result.setCurrPage(pageNum);
        result.setStartIndex(page.getStartRow());
        result.setEndIndex(page.getEndRow());
        result.setTotalCount((int) page.getTotal());
        result.setFirstPage(page.isIsFirstPage());
        result.setFirstPageNum(page.getFirstPage());
        result.setHasNextPage(page.isHasNextPage());
        result.setHasPreviousPage(page.isHasPreviousPage());
        result.setLastPage(page.isIsLastPage());
        result.setLastPageNum(page.getLastPage());
        result.setTotalPages(page.getPages());
        result.setOrderBy(page.getOrderBy());
        LOG.info("Query Result: {}", result);
        return result;
    }

}
