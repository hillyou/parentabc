/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.dao;

import com.parentabc.entity.Answer;

/**
 *
 * @author youguilin
 */
public interface AnswerDao {

    Answer getBestAnser(Answer answer);

    void saveAnswer(Answer answer);

    void updateAnswer(Answer answer);
}
