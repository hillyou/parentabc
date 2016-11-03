/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wechatkit.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author youguilin
 */
public class ConverterUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ConverterUtil.class);

    public static <T> T convertToEntity(String xmlContent, Class<T> clazz) {
        try {
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            InputStream xmlStream = new ByteArrayInputStream(xmlContent.getBytes());
            T entity = (T) unmarshaller.unmarshal(xmlStream);
            LOG.info("Got object message: {}", entity);
            return entity;
        } catch (JAXBException ex) {
            LOG.error("Get message error", ex);
        }
        return null;
    }
}
