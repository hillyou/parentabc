/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dao;

import com.parentabc.entity.Views;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author youguilin
 */
public interface ViewsDao {

    void saveViews(Views views);

    void updateViews(Views views);

    Views getViewsByViewerIdOrIp(@Param("viewerId") int viewerId, @Param("ip") String ip);
}
