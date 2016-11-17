/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dao.AnswerDao;
import com.parentabc.entity.Answer;
import com.parentabc.entity.MemberUser;
import com.parentabc.entity.Question;
import com.parentabc.service.IAnswerService;
import com.parentabc.service.IQuestionService;
import com.parentabc.service.IUserService;
import com.parentabc.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author youguilin
 */
@Service
public class AnswerServiceImpl implements IAnswerService {

    private int ansQuesPoints = Constants.DEFAULT_ANS_QUES_POINT;

    //默认的回答问题,问题的回答者加的积分
    private int ansPoints = Constants.DEFAULT_ANS_POINT;
    //最佳解答分值
    private int bestPoints = Constants.DEFAULT_BEST_ANS_POINT;

    @Autowired
    private IUserService userService;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private AnswerDao answerDao;

    @Override
    public void answerQues(Answer answer) {
        answerDao.saveAnswer(answer);
    }

    public void updateAnswer(Answer answer) {
        answerDao.updateAnswer(answer);
    }

    /**
     * 为回答问题的问题的创建者加积分
     *
     * @param answer
     */
    public void addPoints4Ques(Answer answer) {
        int qId = answer.getQId();
        Question question = questionService.getQuesSimple(qId);
        int userId = question.getCreatorId();
        MemberUser memberUser = userService.getById(userId);
        int oldPoints = memberUser.getPoints();
        memberUser.setPoints(oldPoints + ansQuesPoints);
        userService.updateUser(memberUser);
    }

    /**
     * 为回答问题的问题的回答者加积分
     */
    public void addPoints4Anser(Answer answer) {
        addPoints4Anser1(answer, ansPoints);
    }

    /**
     * 解答被选为最佳解答
     *
     * @param selectorId 选择人ID
     * @param answer
     */
    public void selectAsBestAns(int selectorId, Answer answer) {
        int quesId = answer.getQId();
        Question question = questionService.getQuesSimple(quesId);
        if (question == null) {
            return;
        }
        int questCreatorId = question.getCreatorId();
        if (selectorId > 0 && selectorId != questCreatorId) {
            return;
        }

        if (!hasBestAnswer(answer)) {
            addPoints4Anser1(answer, bestPoints);
        }
    }

    private void addPoints4Anser1(Answer answer, int points) {
        int userId = answer.getCreatorId();
        MemberUser memberUser = userService.getById(userId);
        int oldPoints = memberUser.getPoints();
        memberUser.setPoints(oldPoints + points);
    }

    @Override
    public boolean hasBestAnswer(Answer answer) {
        answer.setBest(true);
        Answer bestAnswer = answerDao.getBestAnser(answer);
        return bestAnswer != null;
    }
}
