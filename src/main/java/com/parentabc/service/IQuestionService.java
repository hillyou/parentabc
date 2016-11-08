/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.Question;

/**
 *
 * @author youguilin
 */
public interface IQuestionService {

    void askQuestion(Question question);

    BasePaginationResult<Question> getQuestions(BasePageQueryReq pageQueryReq);

    BasePaginationResult<Question> getUnansweredQues(BasePageQueryReq pageQueryReq);

    public Question getQuesDetail(int qId);

    public Question getQuesSimple(int qId);

    public void updateQuestion(Question question);
}
