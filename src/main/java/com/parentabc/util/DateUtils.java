/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author youguilin
 */
public class DateUtils {

    public static final Date getDateWithoutTime(Date date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String dateWithoutTime = format.format(date);
            return format.parse(dateWithoutTime);
        } catch (ParseException ex) {
        }
        return null;
    }
}
