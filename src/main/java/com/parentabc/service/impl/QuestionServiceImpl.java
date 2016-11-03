/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dao.QuestionDao;
import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.Question;
import com.parentabc.service.IQuestionService;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class QuestionServiceImpl extends AbstractPageService implements IQuestionService {

    private static final Logger LOG = LoggerFactory.getLogger(QuestionServiceImpl.class);
    @Autowired
    private QuestionDao questionDao;

    @Override
    public void askQuestion(Question question) {
        Date now = new Date();
        question.setCreateDate(now);
        question.setUpdateDate(now);
        questionDao.saveQuestion(question);
    }

    public BasePaginationResult<Question> getQuestions(BasePageQueryReq pageQueryReq) {
        super.beforeQuery(pageQueryReq);
        List<Question> refundList = questionDao.getQuestions(pageQueryReq);
        return super.postQuery(refundList);
    }

    public Question getQuesDetail(int qId) {
        return questionDao.getQuesDetail(qId);
    }

    public Question getQuesSimple(int qId) {
        return questionDao.getQuesSimple(qId);
    }

    public void updateQuestion(Question question) {
        questionDao.updateQueston(question);
    }

}
