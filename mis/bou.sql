CREATE TABLE boards2 (
bno NUMBER PRIMARY KEY,
btitle VARCHAR2(100) NOT NULL,
bcontent CLOB NOT NULL,
bwriter VARCHAR2(50) NOT NULL,
bdate DATE DEFAULT SYSDATE,
bfilename VARCHAR2(50) NULL,
bfiledata BLOB NULL
);
SELECT * FROM boards2;

CREATE SEQUENCE SEQ_BNO NOCACHE;

CREATE TABLE user2(
userid VARCHAR2(50) PRIMARY KEY,
username VARCHAR2(50) NOT NULL,
userpassword VARCHAR(100) NOT NULL,
userage number(3) NOT NULL,
useremail VARCHAR2(100) NOT NULL
);

SELECT * FROM user2;


