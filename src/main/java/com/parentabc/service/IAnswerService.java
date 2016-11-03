/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service;

import com.parentabc.entity.Answer;

/**
 *
 * @author youguilin
 */
public interface IAnswerService {

    void answerQues(Answer answer);

    void updateAnswer(Answer answer);
}
