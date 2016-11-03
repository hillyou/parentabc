/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parentabc.service.impl;

import com.parentabc.dto.BasePageQueryReq;
import com.parentabc.dto.BasePaginationResult;
import com.parentabc.entity.Question;
import com.parentabc.service.IQuestionService;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author youguilin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
public class QuestionServiceImplTest {

    @Autowired
    private IQuestionService instance;

    public QuestionServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAskQuestion() {
        System.out.println("askQuestion");
        Question question = new Question();
        question.setType(1);
        question.setStatus(1);
        question.setCreateDate(new Date());
        question.setCreatorId(0);
        question.setQtitle("aaaa");
        question.setQcontent("bbbbbb");
        instance.askQuestion(question);
    }

    @Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        BasePageQueryReq pageQueryReq = null;
        QuestionServiceImpl instance = new QuestionServiceImpl();
        BasePaginationResult<Question> expResult = null;
        BasePaginationResult<Question> result = instance.getQuestions(pageQueryReq);
    }

    @Test
    public void testGetQuesDetail() {
        System.out.println("getQuesDetail");
        int qId = 0;
        QuestionServiceImpl instance = new QuestionServiceImpl();
        Question expResult = null;
        Question result = instance.getQuesDetail(qId);
    }

    @Test
    public void testGetQuesSimple() {
        System.out.println("getQuesSimple");
        int qId = 0;
        QuestionServiceImpl instance = new QuestionServiceImpl();
        Question expResult = null;
        Question result = instance.getQuesSimple(qId);
    }

    @Test
    public void testUpdateQuestion() {
        System.out.println("updateQuestion");
        Question question = null;
        QuestionServiceImpl instance = new QuestionServiceImpl();
        instance.updateQuestion(question);
    }

}
