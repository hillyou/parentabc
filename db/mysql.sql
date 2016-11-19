--show variables like 'character%'; 
--##my sql shutdown
--mysqladmin -u root -p shutdown 
--## mess code fix
-- character-set-server=utf8 in my.ini

DROP TABLE IF EXISTS VIEWS;
DROP TABLE IF EXISTS ANSWERS;
DROP TABLE IF EXISTS QUESTIONS;
DROP TABLE IF EXISTS USERROLE ;
DROP TABLE IF EXISTS MEMBERUSER;


CREATE TABLE MEMBERUSER(
ID INT AUTO_INCREMENT PRIMARY KEY,
USERNAME VARCHAR(100) , 
PASSWD VARCHAR(100),  
CREATE_DATE TIMESTAMP, 
UPDATE_DATE TIMESTAMP, 
POINTS INT, 
MOBILE VARCHAR(100),  
ADDRESS VARCHAR(100),  
STATUS INT, 
EMAIL VARCHAR(100),  
VERSION INT, 
UNIONID VARCHAR(100), 
OPENID VARCHAR(100), 
SEX VARCHAR(10),
LANG VARCHAR(100),  
CITY VARCHAR(100),  
PROVINCE VARCHAR(100),  
COUNTRY VARCHAR(100),  
NICKNAME VARCHAR(100), 
HEADIMGURL VARCHAR(1000),
SUBSCRIBE INT
);

ALTER TABLE MEMBERUSER ADD CONSTRAINT U_USERNAME UNIQUE (USERNAME,EMAIL,UNIONID,OPENID,MOBILE);

ALTER TABLE MEMBERUSER AUTO_INCREMENT=10001;


CREATE TABLE USERROLE(
ID INT AUTO_INCREMENT PRIMARY KEY,
USERNAME VARCHAR(100), 
ROLE_NAME VARCHAR(100),
CONSTRAINT FK_USER_ROLE FOREIGN KEY (USERNAME)
REFERENCES MEMBERUSER(USERNAME)
);

ALTER TABLE USERROLE AUTO_INCREMENT=10001;

--INSERT USERROLE (USERNAME,ROLE_NAME) VALUES ('USERNAME','ADMIN');


CREATE TABLE QUESTIONS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CREATE_DATE TIMESTAMP, 
UPDATE_DATE TIMESTAMP, 
POINTS INT, 
STATUS INT, 
TYPE INT, 
VIEWS INT,
VERSION INT, 
QCONTENT VARCHAR(2000),
QTITLE VARCHAR(2000),
CREATORID INT,
NICKNAME VARCHAR(100),
AGE INT,
SEX VARCHAR(10)
);

ALTER TABLE QUESTIONS AUTO_INCREMENT=10001;

CREATE TABLE VIEWS(
ID INT AUTO_INCREMENT PRIMARY KEY,
QUES_ID INT,
VIEWER_ID INT, 
TIMES INT,
VIEWER_IP VARCHAR(100),
CREATE_DATE TIMESTAMP, 
UPDATE_DATE TIMESTAMP
);

CREATE TABLE ANSWERS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CREATE_DATE TIMESTAMP, 
UPDATE_DATE TIMESTAMP, 
POINTS INT, 
STATUS INT, 
TYPE INT, 
VERSION INT,
Q_ID INT,  
REF_ID INT,
BEST BOOLEAN,
ACONTENT VARCHAR(2000),
CREATORID INT
);

ALTER TABLE ANSWERS AUTO_INCREMENT=10001;



CREATE OR REPLACE  VIEW VIEWS_COUNT_VIEW AS
SELECT QUES_ID,COUNT(ID) AS COUNTS FROM VIEWS GROUP BY QUES_ID; 


CREATE OR REPLACE  VIEW ANSWERS_COUNT_VIEW AS
SELECT Q_ID AS QUES_ID,COUNT(ID) AS COUNTS FROM ANSWERS GROUP BY Q_ID; 