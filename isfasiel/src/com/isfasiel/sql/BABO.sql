--
-- Create Schema Script 
--   Database Version   : 10.2.0.1.0 
--   TOAD Version       : 9.7.2.5 
--   DB Connect String  : 127.0.0.1:1521/xe 
--   Schema             : BABO 
--   Script Created by  : BABO 
--   Script Created at  : 21/02/2011 AM 10:18:07 
--   Physical Location  :  
--   Notes              :  
--

-- Object Counts: 
--   Indexes: 16        Columns: 24         
--   Sequences: 3 
--   Tables: 14         Columns: 100        Constraints: 29     


CREATE SEQUENCE SEQ_TN_CONTENT
  START WITH 1
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 1000
  NOORDER;


CREATE SEQUENCE SEQ_TN_DIR
  START WITH 2001
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 1000
  NOORDER;


CREATE SEQUENCE SEQ_TN_FILE
  START WITH 1001
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 1000
  NOORDER;


CREATE TABLE TN_CNT_CMT
(
  CONTENT_ID         NUMBER(13)                 NOT NULL,
  COMMENT_ID         NUMBER(13)                 NOT NULL,
  PARENT_COMMENT_ID  NUMBER(13)                 NOT NULL,
  COMMENT_ORDER      NUMBER(4)                  DEFAULT 0                     NOT NULL,
  DEL_YN             CHAR(1 BYTE)               DEFAULT 'N'                   NOT NULL,
  STATE              NUMBER(1)                  NOT NULL,
  CRT_TIME           DATE                       DEFAULT sysdate               NOT NULL,
  UPD_TIME           DATE                       DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_CNT_FILE
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  FILE_ID     NUMBER(13)                        NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_CNT_PATH
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  PATH_ID     NUMBER(13)                        NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_CNT_TAG
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  TAG_ID      NUMBER(13)                        NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_COMMENT
(
  COMMENT_ID  NUMBER(13)                        DEFAULT 0                     NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  IP_ADDR     VARCHAR2(22 BYTE)                 NOT NULL,
  BODY        VARCHAR2(512 BYTE)                NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  STATE       NUMBER(1)                         NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  USER_NAME   VARCHAR2(64 BYTE)                 NOT NULL,
  USER_ID     VARCHAR2(64 BYTE)                 NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_CONTENT
(
  CONTENT_ID  NUMBER(13)                        DEFAULT 0                     NOT NULL,
  TITLE       VARCHAR2(256 BYTE)                DEFAULT 'NO TITLE'            NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  IP_ADDR     VARCHAR2(22 BYTE)                 NOT NULL,
  VIEW_COUNT  NUMBER(10)                        DEFAULT 0                     NOT NULL,
  REC_COUNT   NUMBER(10)                        DEFAULT 0                     NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  USER_NAME   VARCHAR2(64 BYTE)                 NOT NULL,
  USER_ID     VARCHAR2(64 BYTE)                 NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_DIR
(
  DIR_ID    NUMBER(13)                          NOT NULL,
  PHY_PATH  VARCHAR2(256 BYTE)                  NOT NULL,
  DIR_TYPE  CHAR(1 BYTE)                        DEFAULT 'A'                   NOT NULL,
  DEL_YN    CHAR(1 BYTE)                        DEFAULT 'N'                   NOT NULL,
  CRT_TIME  DATE                                DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_DOCUMENT
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  BODY        CLOB                              NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate,
  UPD_TIME    DATE                              DEFAULT sysdate
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_FILE
(
  FILE_ID     NUMBER(13)                        NOT NULL,
  FILE_NAME   VARCHAR2(256 BYTE)                NOT NULL,
  DIR_ID      NUMBER(13)                        NOT NULL,
  FILE_SIZE   NUMBER(13)                        DEFAULT 0                     NOT NULL,
  FILE_TYPE   CHAR(1 BYTE)                      DEFAULT 'A'                   NOT NULL,
  VIEW_COUNT  NUMBER(10)                        DEFAULT 0                     NOT NULL,
  EXTENTION   VARCHAR2(4 BYTE)                  NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  PHY_NAME    VARCHAR2(64 BYTE)                 NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_PATH
(
  PATH_ID     NUMBER(13)                        NOT NULL,
  PATH_NAME   VARCHAR2(128 BYTE)                NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  PATH_ORDER  NUMBER(4)                         NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  STATE       NUMBER(1)                         NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_PATH_RELATION
(
  PATH_ID         NUMBER(13)                    NOT NULL,
  USER_IDX        NUMBER(13)                    NOT NULL,
  PARENT_PATH_ID  NUMBER(13)                    NOT NULL,
  PATH_ORDER      NUMBER(13)                    DEFAULT 0                     NOT NULL,
  RE_NAME         VARCHAR2(128 BYTE)            DEFAULT ''                    NOT NULL,
  STATE           NUMBER(1)                     DEFAULT 0                     NOT NULL,
  CRT_TIME        DATE                          DEFAULT sysdate               NOT NULL,
  UPD_TIME        DATE                          DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_SAMPLE
(
  ID    NUMBER(10)                              NOT NULL,
  NAME  VARCHAR2(32 BYTE)                       NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_TAG
(
  TAG_ID     NUMBER(13)                         DEFAULT 0                     NOT NULL,
  TAG_NAME   VARCHAR2(128 BYTE)                 DEFAULT ''                    NOT NULL,
  TAG_COUNT  NUMBER(10)                         DEFAULT 1                     NOT NULL,
  STATE      NUMBER(1)                          DEFAULT 0                     NOT NULL,
  DEL_YN     CHAR(1 BYTE)                       DEFAULT 'Y'                   NOT NULL,
  CRT_TIME   DATE                               DEFAULT sysdate               NOT NULL,
  UPD_TIME   DATE                               DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE TABLE TN_USER_INFO
(
  USER_IDX    NUMBER(13)                        NOT NULL,
  USER_ID     VARCHAR2(64 BYTE)                 NOT NULL,
  PASSWORD    BLOB                              NOT NULL,
  USER_NAME   VARCHAR2(64 BYTE)                 NOT NULL,
  USER_EMAIL  VARCHAR2(128 BYTE)                NOT NULL,
  USER_ADDR   VARCHAR2(128 BYTE)                NOT NULL,
  PHONE       VARCHAR2(32 BYTE),
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX TN_CNT_CMT_PK ON TN_CNT_CMT
(CONTENT_ID, COMMENT_ID, PARENT_COMMENT_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_CNT_FILE_PK ON TN_CNT_FILE
(CONTENT_ID, FILE_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_CNT_PATH_PK ON TN_CNT_PATH
(CONTENT_ID, PATH_ID, USER_IDX)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_CNT_TAG_PK ON TN_CNT_TAG
(CONTENT_ID, TAG_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_COMMENT_PK ON TN_COMMENT
(COMMENT_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_CONTENT_PK ON TN_CONTENT
(CONTENT_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_DIR_PK ON TN_DIR
(DIR_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_DIR_U01 ON TN_DIR
(PHY_PATH)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_DOCUMENT_PK ON TN_DOCUMENT
(CONTENT_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_FILE_PK ON TN_FILE
(FILE_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_PATH_PK ON TN_PATH
(PATH_ID, USER_IDX)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_PATH_RELATION_PK ON TN_PATH_RELATION
(PATH_ID, USER_IDX)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_TAG_PK ON TN_TAG
(TAG_ID)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_USER_INFO_PK ON TN_USER_INFO
(USER_IDX)
LOGGING
NOPARALLEL;


CREATE UNIQUE INDEX TN_USER_INFO_U01 ON TN_USER_INFO
(USER_ID)
LOGGING
NOPARALLEL;


ALTER TABLE TN_CNT_CMT ADD (
  CONSTRAINT TN_CNT_CMT_PK
 PRIMARY KEY
 (CONTENT_ID, COMMENT_ID, PARENT_COMMENT_ID));

ALTER TABLE TN_CNT_FILE ADD (
  CONSTRAINT TN_CNT_FILE_PK
 PRIMARY KEY
 (CONTENT_ID, FILE_ID));

ALTER TABLE TN_CNT_PATH ADD (
  CONSTRAINT TN_CNT_PATH_PK
 PRIMARY KEY
 (CONTENT_ID, PATH_ID, USER_IDX));

ALTER TABLE TN_CNT_TAG ADD (
  CONSTRAINT TN_CNT_TAG_PK
 PRIMARY KEY
 (CONTENT_ID, TAG_ID));

ALTER TABLE TN_COMMENT ADD (
  CONSTRAINT TN_COMMENT_PK
 PRIMARY KEY
 (COMMENT_ID));

ALTER TABLE TN_CONTENT ADD (
  CONSTRAINT TN_CONTENT_PK
 PRIMARY KEY
 (CONTENT_ID));

ALTER TABLE TN_DIR ADD (
  CONSTRAINT TN_DIR_PK
 PRIMARY KEY
 (DIR_ID),
  CONSTRAINT TN_DIR_U01
 UNIQUE (PHY_PATH));

ALTER TABLE TN_DOCUMENT ADD (
  CONSTRAINT TN_DOCUMENT_PK
 PRIMARY KEY
 (CONTENT_ID));

ALTER TABLE TN_FILE ADD (
  CONSTRAINT TN_FILE_PK
 PRIMARY KEY
 (FILE_ID));

ALTER TABLE TN_PATH ADD (
  CONSTRAINT TN_PATH_PK
 PRIMARY KEY
 (PATH_ID, USER_IDX));

ALTER TABLE TN_PATH_RELATION ADD (
  CONSTRAINT TN_PATH_RELATION_PK
 PRIMARY KEY
 (PATH_ID, USER_IDX));

ALTER TABLE TN_TAG ADD (
  CONSTRAINT TN_TAG_PK
 PRIMARY KEY
 (TAG_ID),
  UNIQUE (TAG_NAME));

ALTER TABLE TN_USER_INFO ADD (
  CONSTRAINT TN_USER_INFO_PK
 PRIMARY KEY
 (USER_IDX),
  CONSTRAINT TN_USER_INFO_U01
 UNIQUE (USER_ID));

ALTER TABLE TN_CNT_CMT ADD (
  CONSTRAINT TN_CNT_CMT_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES TN_CONTENT (CONTENT_ID),
  CONSTRAINT TN_CNT_CMT_R02 
 FOREIGN KEY (COMMENT_ID) 
 REFERENCES TN_COMMENT (COMMENT_ID));

ALTER TABLE TN_CNT_FILE ADD (
  CONSTRAINT TN_CNT_FILE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES TN_CONTENT (CONTENT_ID),
  CONSTRAINT TN_CNT_FILE_R02 
 FOREIGN KEY (FILE_ID) 
 REFERENCES TN_FILE (FILE_ID));

ALTER TABLE TN_CNT_PATH ADD (
  CONSTRAINT TN_CNT_PATH_R01 
 FOREIGN KEY (PATH_ID, USER_IDX) 
 REFERENCES TN_PATH (PATH_ID,USER_IDX));

ALTER TABLE TN_CNT_TAG ADD (
  CONSTRAINT TN_CNT_TAG_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES TN_CONTENT (CONTENT_ID),
  CONSTRAINT TN_CNT_TAG_R02 
 FOREIGN KEY (TAG_ID) 
 REFERENCES TN_TAG (TAG_ID));

ALTER TABLE TN_COMMENT ADD (
  CONSTRAINT TN_COMMENT_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES TN_USER_INFO (USER_IDX));

ALTER TABLE TN_CONTENT ADD (
  CONSTRAINT TN_CONTENT_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES TN_USER_INFO (USER_IDX));

ALTER TABLE TN_DOCUMENT ADD (
  CONSTRAINT TN_DOCUMENT_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES TN_CONTENT (CONTENT_ID));

ALTER TABLE TN_FILE ADD (
  CONSTRAINT TN_FILE_R01 
 FOREIGN KEY (DIR_ID) 
 REFERENCES TN_DIR (DIR_ID));

ALTER TABLE TN_PATH_RELATION ADD (
  CONSTRAINT TN_PATH_RELATION_R01 
 FOREIGN KEY (PARENT_PATH_ID, USER_IDX) 
 REFERENCES TN_PATH (PATH_ID,USER_IDX),
  CONSTRAINT TN_PATH_RELATION_R02 
 FOREIGN KEY (USER_IDX) 
 REFERENCES TN_USER_INFO (USER_IDX));

