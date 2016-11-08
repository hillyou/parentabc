/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dao;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.entity.Question;
import java.util.List;

/**
 *
 * @author youguilin
 */
public interface QuestionDao {

    Question getQuesSimple(int questionId);

    Question getQuesDetail(int questionId);

    List<Question> getQuestions(BasePageQueryReq pageQueryReq);

    List<Question> getUnansweredQues(BasePageQueryReq pageQueryReq);

    void saveQuestion(Question question);

    void updateQueston(Question question);
}
