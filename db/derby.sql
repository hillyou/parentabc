CREATE TABLE MemberUser(
ID int generated always as identity PRIMARY KEY,
USERNAME varchar(100), 
PASSWD varchar(100),  
CREATE_DATE timestamp, 
UPDATE_DATE timestamp, 
POINTS int, 
MOBILE varchar(100),  
ADDRESS varchar(100),  
STATUS INT, 
EMAIL varchar(100),  
VERSION INT, 
UNIONID varchar(100), 
OPENID varchar(100), 
SEX varchar(10),
LANG varchar(100),  
CITY varchar(100),  
PROVINCE varchar(100),  
COUNTRY varchar(100),  
NICKNAME varchar(100), 
HEADIMGURL varchar(1000),
SUBSCRIBE INT
);


CREATE TABLE QUESTIONS(
CREATE_DATE timestamp, 
UPDATE_DATE timestamp, 
POINTS int, 
STATUS INT, 
TYPE INT, 
views INT,
VERSION INT, 
qcontent varchar(2000),
qtitle varchar(2000),
creatorId INT, 
ID int generated always as identity PRIMARY KEY
);


CREATE TABLE ANSWERS(
CREATE_DATE timestamp, 
UPDATE_DATE timestamp, 
POINTS int, 
STATUS INT, 
TYPE INT, 
VERSION INT,
q_id INT,  
best boolean,
acontent varchar(2000),
creatorId INT, 
ID int generated always as identity PRIMARY KEY
);