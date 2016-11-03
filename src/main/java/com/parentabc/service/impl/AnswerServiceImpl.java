/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dao.AnswerDao;
import com.parentabc.entity.Answer;
import com.parentabc.service.IAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class AnswerServiceImpl implements IAnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public void answerQues(Answer answer) {
        answerDao.saveAnswer(answer);
    }

    public void updateAnswer(Answer answer) {
        answerDao.updateAnswer(answer);
    }

}
