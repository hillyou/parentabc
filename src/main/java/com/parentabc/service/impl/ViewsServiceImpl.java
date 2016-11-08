/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dao.ViewsDao;
import com.parentabc.entity.Views;
import com.parentabc.service.IViewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class ViewsServiceImpl implements IViewsService {

    @Autowired
    private ViewsDao viewsDao;

    @Override
    public void saveViews(Views view) {
        try {
            Views oldView = getViewsByViewerIdOrIp(view);
            if (oldView == null) {
                viewsDao.saveViews(view);
            } else {
                int oldTimes = oldView.getTimes();
                oldView.setTimes(oldTimes + 1);
                viewsDao.updateViews(oldView);
            }
        } catch (Exception ex) {
            //ignore invalid view entity
        }
    }

    private Views getViewsByViewerIdOrIp(Views view) {
        int quesId = view.getQuesId();
        String viewerIp = view.getViewerIp();
        int viewerId = view.getViewerId();
        if (quesId < 1) {
            throw new IllegalStateException("INVALID QUESTION ID");
        }
        if ((viewerIp == null || viewerIp.isEmpty()) && viewerId < 1) {
            throw new IllegalStateException("INVALID VIEWER ID AND VIEWER IP");
        }
        return viewsDao.getViewsByViewerIdOrIp(view);
    }

}
