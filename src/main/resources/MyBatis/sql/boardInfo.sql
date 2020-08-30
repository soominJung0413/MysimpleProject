CREATE TABLE BOARDINFO(
    boardNo NUMBER(10,0) PRIMARY KEY,
    boardTitle NVARCHAR2(255) NOT NULL,
    boardCategory NVARCHAR2(255) DEFAULT 'NONE',
    boardContent LONG ,
    boardRegDate DATE DEFAULT SYSDATE,
    boardUpdateDate DATE DEFAULT SYSDATE,
    USERID NVARCHAR2(255) CONSTRAINT board_userid_fk REFERENCES USERINFO(USERID)
    );

    CREATE SEQUENCE seq_boardInfo;

    ALTER TABLE BOARDINFO ADD(READCOUNT NUMBER(10,0) DEFAULT 0);

    ALTER TABLE BOARDINFO ADD(LIKECOUNT NUMBER(10,0) DEFAULT 0);

    CREATE TABLE COMMENTINFO(
    COMMENTNO NUMBER(10,0) CONSTRAINT PK_COMMENT PRIMARY KEY,
    BOARDNO NUMBER(10,0) CONSTRAINT FK_COMMENT_BOARDINFO REFERENCES BOARDINFO(BOARDNO),
    USERID NVARCHAR2(255) CONSTRAINT FK_COMMENT_USERINFO REFERENCES USERINFO(USERID),
    REGDATE DATE DEFAULT SYSDATE,
    UPDATEDATE DATE DEFAULT SYSDATE,
    CONTENT NVARCHAR2(1000)
    );

    CREATE SEQUENCE SEQ_COMMENTINFO;