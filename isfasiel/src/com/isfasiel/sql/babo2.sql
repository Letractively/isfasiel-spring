DROP TABLE BABO.TN_SAMPLE CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_SAMPLE
(
  ID    NUMBER(10)                              NOT NULL,
  NAME  VARCHAR2(32 BYTE)                       NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_GROUP
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_GROUP CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_GROUP
(
  GROUP_ID    NUMBER(10),
  GROUP_NAME  VARCHAR2(128 BYTE)                NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_TAG
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_TAG CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_TAG
(
  TAG_ID     NUMBER(13)                         DEFAULT 0                     NOT NULL,
  TAG_NAME   VARCHAR2(128 BYTE)                 DEFAULT ''                    NOT NULL,
  TAG_COUNT  NUMBER(10)                         DEFAULT 1                     NOT NULL,
  STATE      NUMBER(1)                          DEFAULT 0                     NOT NULL,
  DEL_YN     CHAR(1 BYTE)                       DEFAULT 'N'                   NOT NULL,
  CRT_TIME   DATE                               DEFAULT sysdate               NOT NULL,
  UPD_TIME   DATE                               DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_USER_INFO
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_USER_INFO CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_USER_INFO
(
  USER_IDX    NUMBER(13)                        NOT NULL,
  USER_ID     VARCHAR2(64 BYTE),
  USER_NAME   VARCHAR2(64 BYTE),
  USER_EMAIL  VARCHAR2(128 BYTE)                NOT NULL,
  USER_ADDR   VARCHAR2(128 BYTE),
  PHONE       VARCHAR2(32 BYTE),
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  USER_ROLE   CHAR(1 BYTE)                      DEFAULT 'U'                   NOT NULL,
  PASSWORD    VARCHAR2(256 BYTE)                NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_PATH
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_PATH CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_PATH
(
  PATH_ID     NUMBER(13)                        NOT NULL,
  PATH_NAME   VARCHAR2(128 BYTE)                NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  PATH_ORDER  NUMBER(4)                         NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_PATH_RELATION
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_PATH_RELATION CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_PATH_RELATION
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
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_CNT_PATH
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_CNT_PATH CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_CNT_PATH
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  PATH_ID     NUMBER(13)                        NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_DIR
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_DIR CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_DIR
(
  DIR_ID    NUMBER(13)                          NOT NULL,
  PHY_PATH  VARCHAR2(256 BYTE)                  NOT NULL,
  DIR_TYPE  CHAR(1 BYTE)                        DEFAULT 'A'                   NOT NULL,
  DEL_YN    CHAR(1 BYTE)                        DEFAULT 'N'                   NOT NULL,
  CRT_TIME  DATE                                DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_FILE
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_FILE CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_FILE
(
  FILE_ID     NUMBER(13)                        NOT NULL,
  FILE_NAME   VARCHAR2(256 BYTE)                NOT NULL,
  DIR_ID      NUMBER(13)                        NOT NULL,
  FILE_SIZE   NUMBER(13)                        DEFAULT 0                     NOT NULL,
  FILE_TYPE   CHAR(1 BYTE)                      DEFAULT 'A'                   NOT NULL,
  VIEW_COUNT  NUMBER(10)                        DEFAULT 0                     NOT NULL,
  EXTENTION   VARCHAR2(5 BYTE)                  NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  PHY_NAME    VARCHAR2(64 BYTE)                 NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_GPATH
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_GPATH CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_GPATH
(
  G_PATH_ID     NUMBER(13)                      NOT NULL,
  G_PATH_NAME   VARCHAR2(128 BYTE)              NOT NULL,
  GROUP_ID      NUMBER(13)                      NOT NULL,
  G_PATH_ORDER  NUMBER(4)                       NOT NULL,
  DEL_YN        CHAR(1 BYTE)                    NOT NULL,
  STATE         NUMBER(1)                       NOT NULL,
  CRT_TIME      DATE                            NOT NULL,
  UPD_TIME      DATE                            NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_GPATH_RELATION
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_GPATH_RELATION CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_GPATH_RELATION
(
  G_PATH_ID         NUMBER(13)                  NOT NULL,
  GROUP_ID          NUMBER(13)                  NOT NULL,
  PARENT_G_PATH_ID  NUMBER(13)                  NOT NULL,
  G_PATH_ORDER      NUMBER(13)                  NOT NULL,
  RE_NAME           VARCHAR2(128 BYTE)          NOT NULL,
  STATE             NUMBER(1)                   NOT NULL,
  CRT_TIME          DATE                        NOT NULL,
  UPD_TIME          DATE                        NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_USER_GROUP
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_USER_GROUP CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_USER_GROUP
(
  USER_IDX  NUMBER(13),
  GROUP_ID  NUMBER(10),
  STATE     NUMBER(1)                           DEFAULT 0                     NOT NULL,
  DEL_YN    CHAR(1 BYTE)                        DEFAULT 'N'                   NOT NULL,
  CRT_TIME  DATE                                DEFAULT sysdate               NOT NULL,
  UPD_TIME  DATE                                DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_TEST
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_TEST CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_TEST
(
  TEST_ID  NUMBER(10)                           NOT NULL,
  NAME     VARCHAR2(32 BYTE)                    NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_GROUP_PATH
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_GROUP_PATH CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_GROUP_PATH
(
  GROUP_ID  NUMBER(13),
  PATH_ID   NUMBER(10),
  STATE     NUMBER(1)                           DEFAULT 0                     NOT NULL,
  DEL_YN    CHAR(1 BYTE)                        DEFAULT 'N'                   NOT NULL,
  CRT_TIME  DATE                                DEFAULT sysdate               NOT NULL,
  UPD_TIME  DATE                                DEFAULT sysdate               NOT NULL,
  USER_IDX  NUMBER(13)                          NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_JOB
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_JOB CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_JOB
(
  CONTENT_ID  NUMBER(13),
  BODY        CLOB,
  PAY         NUMBER(7,2)                       DEFAULT 0.0,
  DUE_DATE    VARCHAR2(10 BYTE)                 DEFAULT '00/00/0000',
  JOB_TYPE    CHAR(2 BYTE)                      DEFAULT 'FT',
  AD_TYPE     CHAR(1 BYTE)                      DEFAULT 'A',
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_DATE    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_DATE    DATE                              DEFAULT sysdate               NOT NULL,
  POS_X       NUMBER(16,10)                     DEFAULT 0                     NOT NULL,
  POS_Y       NUMBER(16,10)                     DEFAULT 0                     NOT NULL,
  SUBURB      VARCHAR2(32 BYTE),
  ADDR        VARCHAR2(256 BYTE)
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
LOB (BODY) STORE AS 
      ( TABLESPACE  USERS 
        ENABLE      STORAGE IN ROW
        CHUNK       8192
        RETENTION
        NOCACHE
        INDEX       (
          TABLESPACE USERS
          STORAGE    (
                      INITIAL          64K
                      NEXT             1
                      MINEXTENTS       1
                      MAXEXTENTS       UNLIMITED
                      PCTINCREASE      0
                      BUFFER_POOL      DEFAULT
                     ))
        STORAGE    (
                    INITIAL          64K
                    MINEXTENTS       1
                    MAXEXTENTS       UNLIMITED
                    PCTINCREASE      0
                    BUFFER_POOL      DEFAULT
                   )
      )
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX BABO.TN_CNT_PATH_PK ON BABO.TN_CNT_PATH
(CONTENT_ID, PATH_ID, USER_IDX)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_DIR_PK ON BABO.TN_DIR
(DIR_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_DIR_U01 ON BABO.TN_DIR
(PHY_PATH)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_FILE_PK ON BABO.TN_FILE
(FILE_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_GPATH_PK ON BABO.TN_GPATH
(G_PATH_ID, GROUP_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_GPATH_RELATION_PK ON BABO.TN_GPATH_RELATION
(GROUP_ID, G_PATH_ID, PARENT_G_PATH_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_GROUP_PATH_PK ON BABO.TN_GROUP_PATH
(GROUP_ID, PATH_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_GROUP_PK ON BABO.TN_GROUP
(GROUP_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_JOB_PK ON BABO.TN_JOB
(CONTENT_ID, JOB_TYPE)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_PATH_PK ON BABO.TN_PATH
(PATH_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_PATH_RELATION_PK ON BABO.TN_PATH_RELATION
(PATH_ID, USER_IDX)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_TAG_PK ON BABO.TN_TAG
(TAG_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_TEST_PK ON BABO.TN_TEST
(TEST_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_USER_GROUP_PK ON BABO.TN_USER_GROUP
(USER_IDX, GROUP_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_USER_INFO_PK ON BABO.TN_USER_INFO
(USER_IDX)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_USER_INFO_U01 ON BABO.TN_USER_INFO
(USER_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_USER_INFO_U02 ON BABO.TN_USER_INFO
(USER_EMAIL)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE BABO.TN_CONTENT
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_CONTENT CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_CONTENT
(
  CONTENT_ID    NUMBER(13)                      DEFAULT 0                     NOT NULL,
  TITLE         VARCHAR2(256 BYTE)              DEFAULT 'NO TITLE'            NOT NULL,
  USER_IDX      NUMBER(13)                      NOT NULL,
  IP_ADDR       VARCHAR2(22 BYTE)               NOT NULL,
  VIEW_COUNT    NUMBER(10)                      DEFAULT 0                     NOT NULL,
  REC_COUNT     NUMBER(10)                      DEFAULT 0                     NOT NULL,
  STATE         NUMBER(1)                       DEFAULT 0                     NOT NULL,
  DEL_YN        CHAR(1 BYTE)                    DEFAULT 'N'                   NOT NULL,
  CONTENT_TYPE  CHAR(1 BYTE)                    DEFAULT 'D'                   NOT NULL,
  CRT_TIME      DATE                            DEFAULT sysdate               NOT NULL,
  UPD_TIME      DATE                            DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_CNT_TAG
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_CNT_TAG CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_CNT_TAG
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  TAG_ID      NUMBER(13)                        NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_DOCUMENT
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_DOCUMENT CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_DOCUMENT
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  BODY        CLOB                              NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate,
  UPD_TIME    DATE                              DEFAULT sysdate
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
LOB (BODY) STORE AS 
      ( TABLESPACE  USERS 
        ENABLE      STORAGE IN ROW
        CHUNK       8192
        RETENTION
        NOCACHE
        INDEX       (
          TABLESPACE USERS
          STORAGE    (
                      INITIAL          64K
                      NEXT             1
                      MINEXTENTS       1
                      MAXEXTENTS       UNLIMITED
                      PCTINCREASE      0
                      BUFFER_POOL      DEFAULT
                     ))
        STORAGE    (
                    INITIAL          64K
                    MINEXTENTS       1
                    MAXEXTENTS       UNLIMITED
                    PCTINCREASE      0
                    BUFFER_POOL      DEFAULT
                   )
      )
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_COMMENT
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_COMMENT CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_COMMENT
(
  COMMENT_ID  NUMBER(13)                        DEFAULT 0                     NOT NULL,
  USER_IDX    NUMBER(13)                        NOT NULL,
  IP_ADDR     VARCHAR2(22 BYTE)                 NOT NULL,
  BODY        VARCHAR2(512 BYTE)                NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_CNT_CMT
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_CNT_CMT CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_CNT_CMT
(
  CONTENT_ID         NUMBER(13)                 NOT NULL,
  COMMENT_ID         NUMBER(13)                 NOT NULL,
  PARENT_COMMENT_ID  NUMBER(13)                 NOT NULL,
  COMMENT_ORDER      NUMBER(4)                  DEFAULT 0                     NOT NULL,
  DEL_YN             CHAR(1 BYTE)               DEFAULT 'N'                   NOT NULL,
  STATE              NUMBER(1)                  DEFAULT 0                     NOT NULL,
  CRT_TIME           DATE                       DEFAULT sysdate               NOT NULL,
  UPD_TIME           DATE                       DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_CNT_FILE
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_CNT_FILE CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_CNT_FILE
(
  CONTENT_ID  NUMBER(13)                        NOT NULL,
  FILE_ID     NUMBER(13)                        NOT NULL,
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N'                   NOT NULL,
  STATE       NUMBER(1)                         DEFAULT 0                     NOT NULL,
  CRT_TIME    DATE                              DEFAULT sysdate               NOT NULL,
  UPD_TIME    DATE                              DEFAULT sysdate               NOT NULL
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_WATCH
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_WATCH CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_WATCH
(
  USER_IDX    NUMBER(13),
  CONTENT_ID  NUMBER(13),
  DEL_YN      CHAR(1 BYTE)                      DEFAULT 'N',
  STATUS      NUMBER(1)                         DEFAULT 0,
  CRT_TIME    DATE                              DEFAULT sysdate
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE BABO.TN_MOVIE
 DROP PRIMARY KEY CASCADE;

DROP TABLE BABO.TN_MOVIE CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_MOVIE
(
  CONTENT_ID    NUMBER(13),
  BODY          VARCHAR2(1024 BYTE),
  STATE         NUMBER(1)                       DEFAULT 0                     NOT NULL,
  DEL_YN        CHAR(1 BYTE)                    DEFAULT 'N'                   NOT NULL,
  CRT_TIME      DATE                            DEFAULT sysdate               NOT NULL,
  UPD_TIME      DATE                            DEFAULT sysdate               NOT NULL,
  OPENING_DATE  VARCHAR2(10 BYTE)               DEFAULT '00/00/0000',
  CLOSING_DATE  VARCHAR2(10 BYTE)               DEFAULT '00/00/0000'
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX BABO.TN_CNT_CMT_PK ON BABO.TN_CNT_CMT
(CONTENT_ID, COMMENT_ID, PARENT_COMMENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_CNT_FILE_PK ON BABO.TN_CNT_FILE
(CONTENT_ID, FILE_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_CNT_TAG_PK ON BABO.TN_CNT_TAG
(CONTENT_ID, TAG_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_COMMENT_PK ON BABO.TN_COMMENT
(COMMENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_CONTENT_PK ON BABO.TN_CONTENT
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_DOCUMENT_PK ON BABO.TN_DOCUMENT
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_MOVIE_PK ON BABO.TN_MOVIE
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


CREATE UNIQUE INDEX BABO.TN_WATCH_PK ON BABO.TN_WATCH
(USER_IDX, CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP TABLE BABO.TN_REAL_ESTATE CASCADE CONSTRAINTS;

CREATE TABLE BABO.TN_REAL_ESTATE
(
  CONTENT_ID      NUMBER(13)                    NOT NULL,
  BODY            CLOB                          NOT NULL,
  STATE           NUMBER(1)                     DEFAULT 0                     NOT NULL,
  DEL_YN          CHAR(1 BYTE)                  DEFAULT 'N'                   NOT NULL,
  CRT_TIME        DATE                          DEFAULT sysdate,
  UPD_TIME        DATE                          DEFAULT sysdate,
  POS_X           NUMBER(16,10)                 DEFAULT 0,
  POS_Y           NUMBER(16,10)                 DEFAULT 0,
  SUBURB          VARCHAR2(32 BYTE)             DEFAULT 'Brisbane',
  PRICE           NUMBER(13,2)                  DEFAULT 0,
  ADDR            VARCHAR2(256 BYTE)            DEFAULT '',
  ROOM_TYPE       VARCHAR2(32 BYTE)             DEFAULT 'Second Room',
  SMOKING         CHAR(1 BYTE)                  DEFAULT 'N',
  PETS            CHAR(1 BYTE)                  DEFAULT 'N',
  GENDER          CHAR(1 BYTE)                  DEFAULT 'M',
  AVAILABLE_DATE  VARCHAR2(10 BYTE)             DEFAULT '00/00/0000'
)
TABLESPACE USERS
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
LOB (BODY) STORE AS 
      ( TABLESPACE  USERS 
        ENABLE      STORAGE IN ROW
        CHUNK       8192
        PCTVERSION  10
        NOCACHE
        INDEX       (
          TABLESPACE USERS
          STORAGE    (
                      INITIAL          64K
                      NEXT             1
                      MINEXTENTS       1
                      MAXEXTENTS       UNLIMITED
                      PCTINCREASE      0
                      BUFFER_POOL      DEFAULT
                     ))
        STORAGE    (
                    INITIAL          64K
                    MINEXTENTS       1
                    MAXEXTENTS       UNLIMITED
                    PCTINCREASE      0
                    BUFFER_POOL      DEFAULT
                   )
      )
NOCACHE
NOPARALLEL
MONITORING;


CREATE UNIQUE INDEX BABO.TN_REAL_ESTATE_U01 ON BABO.TN_REAL_ESTATE
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE BABO.TN_GROUP ADD (
  CONSTRAINT TN_GROUP_PK
 PRIMARY KEY
 (GROUP_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_TAG ADD (
  CONSTRAINT TN_TAG_PK
 PRIMARY KEY
 (TAG_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ),
  UNIQUE (TAG_NAME)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_USER_INFO ADD (
  CONSTRAINT TN_USER_INFO_PK
 PRIMARY KEY
 (USER_IDX)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ),
  CONSTRAINT TN_USER_INFO_U02
 UNIQUE (USER_EMAIL)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ),
  CONSTRAINT TN_USER_INFO_U01
 UNIQUE (USER_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_PATH ADD (
  CONSTRAINT TN_PATH_PK
 PRIMARY KEY
 (PATH_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_PATH_RELATION ADD (
  CONSTRAINT TN_PATH_RELATION_PK
 PRIMARY KEY
 (PATH_ID, USER_IDX)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_CNT_PATH ADD (
  CONSTRAINT TN_CNT_PATH_PK
 PRIMARY KEY
 (CONTENT_ID, PATH_ID, USER_IDX)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_DIR ADD (
  CONSTRAINT TN_DIR_PK
 PRIMARY KEY
 (DIR_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ),
  CONSTRAINT TN_DIR_U01
 UNIQUE (PHY_PATH)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_FILE ADD (
  CONSTRAINT TN_FILE_PK
 PRIMARY KEY
 (FILE_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_GPATH ADD (
  CONSTRAINT TN_GPATH_PK
 PRIMARY KEY
 (G_PATH_ID, GROUP_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_GPATH_RELATION ADD (
  CONSTRAINT TN_GPATH_RELATION_PK
 PRIMARY KEY
 (GROUP_ID, G_PATH_ID, PARENT_G_PATH_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_USER_GROUP ADD (
  CONSTRAINT TN_USER_GROUP_PK
 PRIMARY KEY
 (USER_IDX, GROUP_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_TEST ADD (
  CONSTRAINT TN_TEST_PK
 PRIMARY KEY
 (TEST_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_GROUP_PATH ADD (
  CONSTRAINT TN_GROUP_PATH_PK
 PRIMARY KEY
 (GROUP_ID, PATH_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_JOB ADD (
  CONSTRAINT TN_JOB_PK
 PRIMARY KEY
 (CONTENT_ID, JOB_TYPE)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_CONTENT ADD (
  CONSTRAINT TN_CONTENT_PK
 PRIMARY KEY
 (CONTENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_CNT_TAG ADD (
  CONSTRAINT TN_CNT_TAG_PK
 PRIMARY KEY
 (CONTENT_ID, TAG_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_DOCUMENT ADD (
  CONSTRAINT TN_DOCUMENT_PK
 PRIMARY KEY
 (CONTENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_COMMENT ADD (
  CONSTRAINT TN_COMMENT_PK
 PRIMARY KEY
 (COMMENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_CNT_CMT ADD (
  CONSTRAINT TN_CNT_CMT_PK
 PRIMARY KEY
 (CONTENT_ID, COMMENT_ID, PARENT_COMMENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_CNT_FILE ADD (
  CONSTRAINT TN_CNT_FILE_PK
 PRIMARY KEY
 (CONTENT_ID, FILE_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_WATCH ADD (
  CONSTRAINT TN_WATCH_PK
 PRIMARY KEY
 (USER_IDX, CONTENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_MOVIE ADD (
  CONSTRAINT TN_MOVIE_PK
 PRIMARY KEY
 (CONTENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_REAL_ESTATE ADD (
  CONSTRAINT TN_REAL_ESTATE_U01
 UNIQUE (CONTENT_ID)
    USING INDEX 
    TABLESPACE USERS
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
               ));

ALTER TABLE BABO.TN_PATH_RELATION ADD (
  CONSTRAINT TN_PATH_RELATION_R02 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CNT_PATH ADD (
  CONSTRAINT TN_CNT_PATH_R01 
 FOREIGN KEY (PATH_ID) 
 REFERENCES BABO.TN_PATH (PATH_ID));

ALTER TABLE BABO.TN_FILE ADD (
  CONSTRAINT TN_FILE_R01 
 FOREIGN KEY (DIR_ID) 
 REFERENCES BABO.TN_DIR (DIR_ID));

ALTER TABLE BABO.TN_GPATH ADD (
  CONSTRAINT TN_GPATH_R01 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID));

ALTER TABLE BABO.TN_GPATH_RELATION ADD (
  CONSTRAINT TN_GPATH_RELATION_R01 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID),
  CONSTRAINT TN_GPATH_RELATION_R02 
 FOREIGN KEY (GROUP_ID, PARENT_G_PATH_ID) 
 REFERENCES BABO.TN_GPATH (G_PATH_ID,GROUP_ID));

ALTER TABLE BABO.TN_USER_GROUP ADD (
  CONSTRAINT TN_USER_GROUP_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX),
  CONSTRAINT TN_USER_GROUP_R02 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID));

ALTER TABLE BABO.TN_GROUP_PATH ADD (
  CONSTRAINT TN_GROUP_PATH_R01 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID),
  CONSTRAINT TN_GROUP_PATH_R02 
 FOREIGN KEY (PATH_ID) 
 REFERENCES BABO.TN_PATH (PATH_ID),
  CONSTRAINT TN_GROUP_PATH_R03 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CONTENT ADD (
  CONSTRAINT TN_CONTENT_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CNT_TAG ADD (
  CONSTRAINT TN_CNT_TAG_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID),
  CONSTRAINT TN_CNT_TAG_R02 
 FOREIGN KEY (TAG_ID) 
 REFERENCES BABO.TN_TAG (TAG_ID));

ALTER TABLE BABO.TN_DOCUMENT ADD (
  CONSTRAINT TN_DOCUMENT_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_COMMENT ADD (
  CONSTRAINT TN_COMMENT_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CNT_CMT ADD (
  CONSTRAINT TN_CNT_CMT_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID),
  CONSTRAINT TN_CNT_CMT_R02 
 FOREIGN KEY (COMMENT_ID) 
 REFERENCES BABO.TN_COMMENT (COMMENT_ID));

ALTER TABLE BABO.TN_CNT_FILE ADD (
  CONSTRAINT TN_CNT_FILE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID),
  CONSTRAINT TN_CNT_FILE_R02 
 FOREIGN KEY (FILE_ID) 
 REFERENCES BABO.TN_FILE (FILE_ID));

ALTER TABLE BABO.TN_WATCH ADD (
  CONSTRAINT TN_WATCH_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX),
  CONSTRAINT TN_WATCH_R02 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_MOVIE ADD (
  CONSTRAINT TN_MOVIE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_REAL_ESTATE ADD (
  CONSTRAINT TN_REAL_ESTATE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));


DROP INDEX BABO.TN_CNT_CMT_PK;

CREATE UNIQUE INDEX BABO.TN_CNT_CMT_PK ON BABO.TN_CNT_CMT
(CONTENT_ID, COMMENT_ID, PARENT_COMMENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_CNT_FILE_PK;

CREATE UNIQUE INDEX BABO.TN_CNT_FILE_PK ON BABO.TN_CNT_FILE
(CONTENT_ID, FILE_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_CNT_PATH_PK;

CREATE UNIQUE INDEX BABO.TN_CNT_PATH_PK ON BABO.TN_CNT_PATH
(CONTENT_ID, PATH_ID, USER_IDX)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_CNT_TAG_PK;

CREATE UNIQUE INDEX BABO.TN_CNT_TAG_PK ON BABO.TN_CNT_TAG
(CONTENT_ID, TAG_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_COMMENT_PK;

CREATE UNIQUE INDEX BABO.TN_COMMENT_PK ON BABO.TN_COMMENT
(COMMENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_CONTENT_PK;

CREATE UNIQUE INDEX BABO.TN_CONTENT_PK ON BABO.TN_CONTENT
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_DIR_PK;

CREATE UNIQUE INDEX BABO.TN_DIR_PK ON BABO.TN_DIR
(DIR_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_DIR_U01;

CREATE UNIQUE INDEX BABO.TN_DIR_U01 ON BABO.TN_DIR
(PHY_PATH)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_DOCUMENT_PK;

CREATE UNIQUE INDEX BABO.TN_DOCUMENT_PK ON BABO.TN_DOCUMENT
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_FILE_PK;

CREATE UNIQUE INDEX BABO.TN_FILE_PK ON BABO.TN_FILE
(FILE_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_GPATH_PK;

CREATE UNIQUE INDEX BABO.TN_GPATH_PK ON BABO.TN_GPATH
(G_PATH_ID, GROUP_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_GPATH_RELATION_PK;

CREATE UNIQUE INDEX BABO.TN_GPATH_RELATION_PK ON BABO.TN_GPATH_RELATION
(GROUP_ID, G_PATH_ID, PARENT_G_PATH_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_GROUP_PATH_PK;

CREATE UNIQUE INDEX BABO.TN_GROUP_PATH_PK ON BABO.TN_GROUP_PATH
(GROUP_ID, PATH_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_GROUP_PK;

CREATE UNIQUE INDEX BABO.TN_GROUP_PK ON BABO.TN_GROUP
(GROUP_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_JOB_PK;

CREATE UNIQUE INDEX BABO.TN_JOB_PK ON BABO.TN_JOB
(CONTENT_ID, JOB_TYPE)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_MOVIE_PK;

CREATE UNIQUE INDEX BABO.TN_MOVIE_PK ON BABO.TN_MOVIE
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_PATH_PK;

CREATE UNIQUE INDEX BABO.TN_PATH_PK ON BABO.TN_PATH
(PATH_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_PATH_RELATION_PK;

CREATE UNIQUE INDEX BABO.TN_PATH_RELATION_PK ON BABO.TN_PATH_RELATION
(PATH_ID, USER_IDX)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_REAL_ESTATE_U01;

CREATE UNIQUE INDEX BABO.TN_REAL_ESTATE_U01 ON BABO.TN_REAL_ESTATE
(CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_TAG_PK;

CREATE UNIQUE INDEX BABO.TN_TAG_PK ON BABO.TN_TAG
(TAG_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_TEST_PK;

CREATE UNIQUE INDEX BABO.TN_TEST_PK ON BABO.TN_TEST
(TEST_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_USER_GROUP_PK;

CREATE UNIQUE INDEX BABO.TN_USER_GROUP_PK ON BABO.TN_USER_GROUP
(USER_IDX, GROUP_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_USER_INFO_PK;

CREATE UNIQUE INDEX BABO.TN_USER_INFO_PK ON BABO.TN_USER_INFO
(USER_IDX)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_USER_INFO_U01;

CREATE UNIQUE INDEX BABO.TN_USER_INFO_U01 ON BABO.TN_USER_INFO
(USER_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_USER_INFO_U02;

CREATE UNIQUE INDEX BABO.TN_USER_INFO_U02 ON BABO.TN_USER_INFO
(USER_EMAIL)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


DROP INDEX BABO.TN_WATCH_PK;

CREATE UNIQUE INDEX BABO.TN_WATCH_PK ON BABO.TN_WATCH
(USER_IDX, CONTENT_ID)
LOGGING
TABLESPACE USERS
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;



DROP SEQUENCE BABO.SEQ_TN_COMMENT;

CREATE SEQUENCE BABO.SEQ_TN_COMMENT
  START WITH 47
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  NOORDER;


DROP SEQUENCE BABO.SEQ_TN_CONTENT;

CREATE SEQUENCE BABO.SEQ_TN_CONTENT
  START WITH 10137
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 2
  NOORDER;


DROP SEQUENCE BABO.SEQ_TN_DIR;

CREATE SEQUENCE BABO.SEQ_TN_DIR
  START WITH 4008
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 2
  NOORDER;


DROP SEQUENCE BABO.SEQ_TN_FILE;

CREATE SEQUENCE BABO.SEQ_TN_FILE
  START WITH 4336
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 2
  NOORDER;


DROP SEQUENCE BABO.SEQ_TN_GROUP;

CREATE SEQUENCE BABO.SEQ_TN_GROUP
  START WITH 71
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  NOORDER;


DROP SEQUENCE BABO.SEQ_TN_PATH;

CREATE SEQUENCE BABO.SEQ_TN_PATH
  START WITH 35
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  NOORDER;


DROP SEQUENCE BABO.SEQ_TN_TAG;

CREATE SEQUENCE BABO.SEQ_TN_TAG
  START WITH 1001
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  CACHE 2
  NOORDER;


DROP SEQUENCE BABO.SQL_TN_USER_INFO;

CREATE SEQUENCE BABO.SQL_TN_USER_INFO
  START WITH 18
  MAXVALUE 999999999999999999999999999
  MINVALUE 1
  NOCYCLE
  NOCACHE
  NOORDER;



ALTER TABLE BABO.TN_SAMPLE MODIFY 
  NAME NULL;

ALTER TABLE BABO.TN_SAMPLE MODIFY 
  ID NULL;

ALTER TABLE BABO.TN_SAMPLE ADD (
  NAME NOT NULL,
  ID NOT NULL);

ALTER TABLE BABO.TN_FILE
  DROP CONSTRAINT TN_FILE_R01;

ALTER TABLE BABO.TN_FILE MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  EXTENTION NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  VIEW_COUNT NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  FILE_TYPE NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  FILE_SIZE NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  DIR_ID NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  FILE_NAME NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  FILE_ID NULL;

ALTER TABLE BABO.TN_FILE MODIFY 
  PHY_NAME NULL;

ALTER TABLE BABO.TN_FILE
  DROP CONSTRAINT TN_FILE_PK;

ALTER TABLE BABO.TN_FILE ADD (
  DEL_YN NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  EXTENTION NOT NULL,
  VIEW_COUNT NOT NULL,
  FILE_TYPE NOT NULL,
  FILE_SIZE NOT NULL,
  DIR_ID NOT NULL,
  FILE_NAME NOT NULL,
  FILE_ID NOT NULL,
  PHY_NAME NOT NULL,
  CONSTRAINT TN_FILE_PK
 PRIMARY KEY
 (FILE_ID));

ALTER TABLE BABO.TN_TAG MODIFY 
  TAG_NAME NULL;

ALTER TABLE BABO.TN_TAG MODIFY 
  TAG_COUNT NULL;

ALTER TABLE BABO.TN_TAG MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_TAG MODIFY 
  TAG_ID NULL;

ALTER TABLE BABO.TN_TAG MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_TAG MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_TAG MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_TAG
  DROP CONSTRAINT TN_TAG_PK;

ALTER TABLE BABO.TN_TAG
  DROP CONSTRAINT SYS_C004091;

ALTER TABLE BABO.TN_TAG ADD (
  TAG_NAME NOT NULL,
  TAG_COUNT NOT NULL,
  STATE NOT NULL,
  TAG_ID NOT NULL,
  DEL_YN NOT NULL,
  CRT_TIME NOT NULL,
  UPD_TIME NOT NULL,
  CONSTRAINT TN_TAG_PK
 PRIMARY KEY
 (TAG_ID),
  UNIQUE (TAG_NAME));

ALTER TABLE BABO.TN_CONTENT
  DROP CONSTRAINT TN_CONTENT_R01;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  REC_COUNT NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  VIEW_COUNT NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  IP_ADDR NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  TITLE NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  CONTENT_TYPE NULL;

ALTER TABLE BABO.TN_CONTENT MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_CONTENT
  DROP CONSTRAINT TN_CONTENT_PK;

ALTER TABLE BABO.TN_CONTENT ADD (
  DEL_YN NOT NULL,
  STATE NOT NULL,
  REC_COUNT NOT NULL,
  VIEW_COUNT NOT NULL,
  IP_ADDR NOT NULL,
  USER_IDX NOT NULL,
  TITLE NOT NULL,
  CONTENT_ID NOT NULL,
  UPD_TIME NOT NULL,
  CONTENT_TYPE NOT NULL,
  CRT_TIME NOT NULL,
  CONSTRAINT TN_CONTENT_PK
 PRIMARY KEY
 (CONTENT_ID));

ALTER TABLE BABO.TN_CNT_TAG
  DROP CONSTRAINT TN_CNT_TAG_R02;

ALTER TABLE BABO.TN_CNT_TAG
  DROP CONSTRAINT TN_CNT_TAG_R01;

ALTER TABLE BABO.TN_CNT_TAG MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_CNT_TAG MODIFY 
  TAG_ID NULL;

ALTER TABLE BABO.TN_CNT_TAG MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_CNT_TAG
  DROP CONSTRAINT TN_CNT_TAG_PK;

ALTER TABLE BABO.TN_CNT_TAG ADD (
  DEL_YN NOT NULL,
  TAG_ID NOT NULL,
  CONTENT_ID NOT NULL,
  CONSTRAINT TN_CNT_TAG_PK
 PRIMARY KEY
 (CONTENT_ID, TAG_ID));

ALTER TABLE BABO.TN_DOCUMENT
  DROP CONSTRAINT TN_DOCUMENT_R01;

ALTER TABLE BABO.TN_DOCUMENT MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_DOCUMENT MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_DOCUMENT MODIFY 
  BODY NULL;

ALTER TABLE BABO.TN_DOCUMENT MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_DOCUMENT
  DROP CONSTRAINT TN_DOCUMENT_PK;

ALTER TABLE BABO.TN_DOCUMENT ADD (
  DEL_YN NOT NULL,
  STATE NOT NULL,
  BODY NOT NULL,
  CONTENT_ID NOT NULL,
  CONSTRAINT TN_DOCUMENT_PK
 PRIMARY KEY
 (CONTENT_ID));

ALTER TABLE BABO.TN_COMMENT
  DROP CONSTRAINT TN_COMMENT_R01;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  BODY NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  IP_ADDR NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_COMMENT MODIFY 
  COMMENT_ID NULL;

ALTER TABLE BABO.TN_COMMENT
  DROP CONSTRAINT TN_COMMENT_PK;

ALTER TABLE BABO.TN_COMMENT ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  DEL_YN NOT NULL,
  BODY NOT NULL,
  IP_ADDR NOT NULL,
  USER_IDX NOT NULL,
  COMMENT_ID NOT NULL,
  CONSTRAINT TN_COMMENT_PK
 PRIMARY KEY
 (COMMENT_ID));

ALTER TABLE BABO.TN_CNT_CMT
  DROP CONSTRAINT TN_CNT_CMT_R02;

ALTER TABLE BABO.TN_CNT_CMT
  DROP CONSTRAINT TN_CNT_CMT_R01;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  COMMENT_ORDER NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  PARENT_COMMENT_ID NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  COMMENT_ID NULL;

ALTER TABLE BABO.TN_CNT_CMT MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_CNT_CMT
  DROP CONSTRAINT TN_CNT_CMT_PK;

ALTER TABLE BABO.TN_CNT_CMT ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  DEL_YN NOT NULL,
  COMMENT_ORDER NOT NULL,
  PARENT_COMMENT_ID NOT NULL,
  COMMENT_ID NOT NULL,
  CONTENT_ID NOT NULL,
  CONSTRAINT TN_CNT_CMT_PK
 PRIMARY KEY
 (CONTENT_ID, COMMENT_ID, PARENT_COMMENT_ID));

ALTER TABLE BABO.TN_USER_INFO MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_USER_INFO MODIFY 
  USER_EMAIL NULL;

ALTER TABLE BABO.TN_USER_INFO MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_USER_INFO MODIFY 
  PASSWORD NULL;

ALTER TABLE BABO.TN_USER_INFO MODIFY 
  USER_ROLE NULL;

ALTER TABLE BABO.TN_USER_INFO
  DROP CONSTRAINT TN_USER_INFO_PK;

ALTER TABLE BABO.TN_USER_INFO
  DROP CONSTRAINT TN_USER_INFO_U02;

ALTER TABLE BABO.TN_USER_INFO
  DROP CONSTRAINT TN_USER_INFO_U01;

ALTER TABLE BABO.TN_USER_INFO ADD (
  CRT_TIME NOT NULL,
  USER_EMAIL NOT NULL,
  USER_IDX NOT NULL,
  PASSWORD NOT NULL,
  USER_ROLE NOT NULL,
  CONSTRAINT TN_USER_INFO_PK
 PRIMARY KEY
 (USER_IDX),
  CONSTRAINT TN_USER_INFO_U02
 UNIQUE (USER_EMAIL),
  CONSTRAINT TN_USER_INFO_U01
 UNIQUE (USER_ID));

ALTER TABLE BABO.TN_REAL_ESTATE
  DROP CONSTRAINT TN_REAL_ESTATE_R01;

ALTER TABLE BABO.TN_REAL_ESTATE MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_REAL_ESTATE MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_REAL_ESTATE MODIFY 
  BODY NULL;

ALTER TABLE BABO.TN_REAL_ESTATE MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_REAL_ESTATE
  DROP CONSTRAINT TN_REAL_ESTATE_U01;

ALTER TABLE BABO.TN_REAL_ESTATE ADD (
  DEL_YN NOT NULL,
  STATE NOT NULL,
  BODY NOT NULL,
  CONTENT_ID NOT NULL,
  CONSTRAINT TN_REAL_ESTATE_U01
 UNIQUE (CONTENT_ID));

ALTER TABLE BABO.TN_PATH MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  PATH_ORDER NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  PATH_NAME NULL;

ALTER TABLE BABO.TN_PATH MODIFY 
  PATH_ID NULL;

ALTER TABLE BABO.TN_PATH
  DROP CONSTRAINT TN_PATH_PK;

ALTER TABLE BABO.TN_PATH ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  DEL_YN NOT NULL,
  PATH_ORDER NOT NULL,
  USER_IDX NOT NULL,
  PATH_NAME NOT NULL,
  PATH_ID NOT NULL,
  CONSTRAINT TN_PATH_PK
 PRIMARY KEY
 (PATH_ID));

ALTER TABLE BABO.TN_USER_GROUP
  DROP CONSTRAINT TN_USER_GROUP_R01;

ALTER TABLE BABO.TN_USER_GROUP
  DROP CONSTRAINT TN_USER_GROUP_R02;

ALTER TABLE BABO.TN_USER_GROUP MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_USER_GROUP MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_USER_GROUP MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_USER_GROUP MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_USER_GROUP
  DROP CONSTRAINT TN_USER_GROUP_PK;

ALTER TABLE BABO.TN_USER_GROUP ADD (
  CRT_TIME NOT NULL,
  DEL_YN NOT NULL,
  STATE NOT NULL,
  UPD_TIME NOT NULL,
  CONSTRAINT TN_USER_GROUP_PK
 PRIMARY KEY
 (USER_IDX, GROUP_ID));

ALTER TABLE BABO.TN_CNT_PATH
  DROP CONSTRAINT TN_CNT_PATH_R01;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  PATH_ID NULL;

ALTER TABLE BABO.TN_CNT_PATH MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_CNT_PATH
  DROP CONSTRAINT TN_CNT_PATH_PK;

ALTER TABLE BABO.TN_CNT_PATH ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  DEL_YN NOT NULL,
  STATE NOT NULL,
  USER_IDX NOT NULL,
  PATH_ID NOT NULL,
  CONTENT_ID NOT NULL,
  CONSTRAINT TN_CNT_PATH_PK
 PRIMARY KEY
 (CONTENT_ID, PATH_ID, USER_IDX));

ALTER TABLE BABO.TN_PATH_RELATION
  DROP CONSTRAINT TN_PATH_RELATION_R02;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  RE_NAME NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  PATH_ORDER NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  PARENT_PATH_ID NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_PATH_RELATION MODIFY 
  PATH_ID NULL;

ALTER TABLE BABO.TN_PATH_RELATION
  DROP CONSTRAINT TN_PATH_RELATION_PK;

ALTER TABLE BABO.TN_PATH_RELATION ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  RE_NAME NOT NULL,
  PATH_ORDER NOT NULL,
  PARENT_PATH_ID NOT NULL,
  USER_IDX NOT NULL,
  PATH_ID NOT NULL,
  CONSTRAINT TN_PATH_RELATION_PK
 PRIMARY KEY
 (PATH_ID, USER_IDX));

ALTER TABLE BABO.TN_DIR MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_DIR MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_DIR MODIFY 
  DIR_TYPE NULL;

ALTER TABLE BABO.TN_DIR MODIFY 
  PHY_PATH NULL;

ALTER TABLE BABO.TN_DIR MODIFY 
  DIR_ID NULL;

ALTER TABLE BABO.TN_DIR
  DROP CONSTRAINT TN_DIR_PK;

ALTER TABLE BABO.TN_DIR
  DROP CONSTRAINT TN_DIR_U01;

ALTER TABLE BABO.TN_DIR ADD (
  CRT_TIME NOT NULL,
  DEL_YN NOT NULL,
  DIR_TYPE NOT NULL,
  PHY_PATH NOT NULL,
  DIR_ID NOT NULL,
  CONSTRAINT TN_DIR_PK
 PRIMARY KEY
 (DIR_ID),
  CONSTRAINT TN_DIR_U01
 UNIQUE (PHY_PATH));

ALTER TABLE BABO.TN_CNT_FILE
  DROP CONSTRAINT TN_CNT_FILE_R02;

ALTER TABLE BABO.TN_CNT_FILE
  DROP CONSTRAINT TN_CNT_FILE_R01;

ALTER TABLE BABO.TN_CNT_FILE MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_CNT_FILE MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_CNT_FILE MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_CNT_FILE MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_CNT_FILE MODIFY 
  FILE_ID NULL;

ALTER TABLE BABO.TN_CNT_FILE MODIFY 
  CONTENT_ID NULL;

ALTER TABLE BABO.TN_CNT_FILE
  DROP CONSTRAINT TN_CNT_FILE_PK;

ALTER TABLE BABO.TN_CNT_FILE ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  DEL_YN NOT NULL,
  FILE_ID NOT NULL,
  CONTENT_ID NOT NULL,
  CONSTRAINT TN_CNT_FILE_PK
 PRIMARY KEY
 (CONTENT_ID, FILE_ID));

ALTER TABLE BABO.TN_GROUP MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_GROUP MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_GROUP MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_GROUP MODIFY 
  GROUP_NAME NULL;

ALTER TABLE BABO.TN_GROUP
  DROP CONSTRAINT TN_GROUP_PK;

ALTER TABLE BABO.TN_GROUP ADD (
  DEL_YN NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  GROUP_NAME NOT NULL,
  CONSTRAINT TN_GROUP_PK
 PRIMARY KEY
 (GROUP_ID));

ALTER TABLE BABO.TN_TEST MODIFY 
  TEST_ID NULL;

ALTER TABLE BABO.TN_TEST MODIFY 
  NAME NULL;

ALTER TABLE BABO.TN_TEST
  DROP CONSTRAINT TN_TEST_PK;

ALTER TABLE BABO.TN_TEST ADD (
  TEST_ID NOT NULL,
  NAME NOT NULL,
  CONSTRAINT TN_TEST_PK
 PRIMARY KEY
 (TEST_ID));

ALTER TABLE BABO.TN_GPATH
  DROP CONSTRAINT TN_GPATH_R01;

ALTER TABLE BABO.TN_GPATH MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  G_PATH_ORDER NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  GROUP_ID NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  G_PATH_NAME NULL;

ALTER TABLE BABO.TN_GPATH MODIFY 
  G_PATH_ID NULL;

ALTER TABLE BABO.TN_GPATH
  DROP CONSTRAINT TN_GPATH_PK;

ALTER TABLE BABO.TN_GPATH ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  DEL_YN NOT NULL,
  G_PATH_ORDER NOT NULL,
  GROUP_ID NOT NULL,
  G_PATH_NAME NOT NULL,
  G_PATH_ID NOT NULL,
  CONSTRAINT TN_GPATH_PK
 PRIMARY KEY
 (G_PATH_ID, GROUP_ID));

ALTER TABLE BABO.TN_GPATH_RELATION
  DROP CONSTRAINT TN_GPATH_RELATION_R01;

ALTER TABLE BABO.TN_GPATH_RELATION
  DROP CONSTRAINT TN_GPATH_RELATION_R02;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  RE_NAME NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  G_PATH_ORDER NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  PARENT_G_PATH_ID NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  GROUP_ID NULL;

ALTER TABLE BABO.TN_GPATH_RELATION MODIFY 
  G_PATH_ID NULL;

ALTER TABLE BABO.TN_GPATH_RELATION
  DROP CONSTRAINT TN_GPATH_RELATION_PK;

ALTER TABLE BABO.TN_GPATH_RELATION ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  STATE NOT NULL,
  RE_NAME NOT NULL,
  G_PATH_ORDER NOT NULL,
  PARENT_G_PATH_ID NOT NULL,
  GROUP_ID NOT NULL,
  G_PATH_ID NOT NULL,
  CONSTRAINT TN_GPATH_RELATION_PK
 PRIMARY KEY
 (GROUP_ID, G_PATH_ID, PARENT_G_PATH_ID));

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0" MODIFY 
  GROUP_ID NULL;

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0" MODIFY 
  PATH_ID NULL;

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0" MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0" MODIFY 
  STATE NULL;

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0" MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0"
  DROP CONSTRAINT "BIN$m8FKPiXxRl+8VFRn2p5Xew==$0";

ALTER TABLE BABO."BIN$ZWCz2nvaRTGeACOxFvUWnA==$0" ADD (
  GROUP_ID CONSTRAINT "BIN$+hZdgBEUStm8rcMdWZ85xw==$0" NOT NULL,
  PATH_ID CONSTRAINT "BIN$WAGe2cePRYGpRvkGnn1LAw==$0" NOT NULL,
  DEL_YN CONSTRAINT "BIN$iQZX7fZ2S4mBhEvkzSAxPQ==$0" NOT NULL,
  STATE CONSTRAINT "BIN$R+Bwilq3TbODfvgxFnujVg==$0" NOT NULL,
  CRT_TIME CONSTRAINT "BIN$9fNnQMzLRiOQoAsWn9HTIQ==$0" NOT NULL,
  CONSTRAINT "BIN$m8FKPiXxRl+8VFRn2p5Xew==$0"
 PRIMARY KEY
 (GROUP_ID, PATH_ID));

ALTER TABLE BABO.TN_GROUP_PATH
  DROP CONSTRAINT TN_GROUP_PATH_R01;

ALTER TABLE BABO.TN_GROUP_PATH
  DROP CONSTRAINT TN_GROUP_PATH_R02;

ALTER TABLE BABO.TN_GROUP_PATH
  DROP CONSTRAINT TN_GROUP_PATH_R03;

ALTER TABLE BABO.TN_GROUP_PATH MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_GROUP_PATH MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_GROUP_PATH MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_GROUP_PATH MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_GROUP_PATH MODIFY 
  USER_IDX NULL;

ALTER TABLE BABO.TN_GROUP_PATH
  DROP CONSTRAINT TN_GROUP_PATH_PK;

ALTER TABLE BABO.TN_GROUP_PATH ADD (
  CRT_TIME NOT NULL,
  DEL_YN NOT NULL,
  STATE NOT NULL,
  UPD_TIME NOT NULL,
  USER_IDX NOT NULL,
  CONSTRAINT TN_GROUP_PATH_PK
 PRIMARY KEY
 (GROUP_ID, PATH_ID));

ALTER TABLE BABO.TN_MOVIE
  DROP CONSTRAINT TN_MOVIE_R01;

ALTER TABLE BABO.TN_MOVIE MODIFY 
  UPD_TIME NULL;

ALTER TABLE BABO.TN_MOVIE MODIFY 
  CRT_TIME NULL;

ALTER TABLE BABO.TN_MOVIE MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_MOVIE MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_MOVIE
  DROP CONSTRAINT TN_MOVIE_PK;

ALTER TABLE BABO.TN_MOVIE ADD (
  UPD_TIME NOT NULL,
  CRT_TIME NOT NULL,
  DEL_YN NOT NULL,
  STATE NOT NULL,
  CONSTRAINT TN_MOVIE_PK
 PRIMARY KEY
 (CONTENT_ID));

ALTER TABLE BABO.TN_JOB MODIFY 
  CRT_DATE NULL;

ALTER TABLE BABO.TN_JOB MODIFY 
  DEL_YN NULL;

ALTER TABLE BABO.TN_JOB MODIFY 
  STATE NULL;

ALTER TABLE BABO.TN_JOB MODIFY 
  UPD_DATE NULL;

ALTER TABLE BABO.TN_JOB MODIFY 
  POS_X NULL;

ALTER TABLE BABO.TN_JOB MODIFY 
  POS_Y NULL;

ALTER TABLE BABO.TN_JOB
  DROP CONSTRAINT TN_JOB_PK;

ALTER TABLE BABO.TN_JOB ADD (
  CRT_DATE NOT NULL,
  DEL_YN NOT NULL,
  STATE NOT NULL,
  UPD_DATE NOT NULL,
  POS_X NOT NULL,
  POS_Y NOT NULL,
  CONSTRAINT TN_JOB_PK
 PRIMARY KEY
 (CONTENT_ID, JOB_TYPE));

ALTER TABLE BABO.TN_WATCH
  DROP CONSTRAINT TN_WATCH_R01;

ALTER TABLE BABO.TN_WATCH
  DROP CONSTRAINT TN_WATCH_R02;

ALTER TABLE BABO.TN_WATCH
  DROP CONSTRAINT TN_WATCH_PK;

ALTER TABLE BABO.TN_WATCH ADD (
  CONSTRAINT TN_WATCH_PK
 PRIMARY KEY
 (USER_IDX, CONTENT_ID));

ALTER TABLE BABO.TN_FILE ADD (
  CONSTRAINT TN_FILE_R01 
 FOREIGN KEY (DIR_ID) 
 REFERENCES BABO.TN_DIR (DIR_ID));

ALTER TABLE BABO.TN_CONTENT ADD (
  CONSTRAINT TN_CONTENT_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CNT_TAG ADD (
  CONSTRAINT TN_CNT_TAG_R02 
 FOREIGN KEY (TAG_ID) 
 REFERENCES BABO.TN_TAG (TAG_ID),
  CONSTRAINT TN_CNT_TAG_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_DOCUMENT ADD (
  CONSTRAINT TN_DOCUMENT_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_COMMENT ADD (
  CONSTRAINT TN_COMMENT_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CNT_CMT ADD (
  CONSTRAINT TN_CNT_CMT_R02 
 FOREIGN KEY (COMMENT_ID) 
 REFERENCES BABO.TN_COMMENT (COMMENT_ID),
  CONSTRAINT TN_CNT_CMT_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_REAL_ESTATE ADD (
  CONSTRAINT TN_REAL_ESTATE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_USER_GROUP ADD (
  CONSTRAINT TN_USER_GROUP_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX),
  CONSTRAINT TN_USER_GROUP_R02 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID));

ALTER TABLE BABO.TN_CNT_PATH ADD (
  CONSTRAINT TN_CNT_PATH_R01 
 FOREIGN KEY (PATH_ID) 
 REFERENCES BABO.TN_PATH (PATH_ID));

ALTER TABLE BABO.TN_PATH_RELATION ADD (
  CONSTRAINT TN_PATH_RELATION_R02 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_CNT_FILE ADD (
  CONSTRAINT TN_CNT_FILE_R02 
 FOREIGN KEY (FILE_ID) 
 REFERENCES BABO.TN_FILE (FILE_ID),
  CONSTRAINT TN_CNT_FILE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_GPATH ADD (
  CONSTRAINT TN_GPATH_R01 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID));

ALTER TABLE BABO.TN_GPATH_RELATION ADD (
  CONSTRAINT TN_GPATH_RELATION_R01 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID),
  CONSTRAINT TN_GPATH_RELATION_R02 
 FOREIGN KEY (GROUP_ID, PARENT_G_PATH_ID) 
 REFERENCES BABO.TN_GPATH (G_PATH_ID,GROUP_ID));

ALTER TABLE BABO.TN_GROUP_PATH ADD (
  CONSTRAINT TN_GROUP_PATH_R01 
 FOREIGN KEY (GROUP_ID) 
 REFERENCES BABO.TN_GROUP (GROUP_ID),
  CONSTRAINT TN_GROUP_PATH_R02 
 FOREIGN KEY (PATH_ID) 
 REFERENCES BABO.TN_PATH (PATH_ID),
  CONSTRAINT TN_GROUP_PATH_R03 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX));

ALTER TABLE BABO.TN_MOVIE ADD (
  CONSTRAINT TN_MOVIE_R01 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

ALTER TABLE BABO.TN_WATCH ADD (
  CONSTRAINT TN_WATCH_R01 
 FOREIGN KEY (USER_IDX) 
 REFERENCES BABO.TN_USER_INFO (USER_IDX),
  CONSTRAINT TN_WATCH_R02 
 FOREIGN KEY (CONTENT_ID) 
 REFERENCES BABO.TN_CONTENT (CONTENT_ID));

