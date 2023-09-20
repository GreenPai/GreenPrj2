PS C:\Users\Administrator> sqlplus /nolog
SQL> conn /as sysdba
연결되었습니다.

SQL> alter session set "_ORACLE_SCRIPT"=true;
세션이 변경되었습니다.

SQL> create user spring identified by 1234;
사용자가 생성되었습니다.

SQL> grant CONNECT,RESOURCE TO spring;
권한이 부여되었습니다.

SQL> ALTER USER spring DEFAULT TABLESPACE
  2  USERS QUOTA UNLIMITED ON USERS;
사용자가 변경되었습니다.

CREATE TABLE TUSER (
      USERID    VARCHAR2(12)  PRIMARY KEY
    , PASSWD    VARCHAR2(12)  NOT NULL
    , USERNAME  VARCHAR2(30)  NOT NULL
    , EMAIL     VARCHAR2(320)
    , INDATE    DATE          DEFAULT SYSDATE
);

----------------------------
멀티게시판

menus
  MENU_ID     MENU_NAME    MENU_SEQ
  MENU01      JAVA         1
  MENU02      JSP          2
  MENU03      HTML         3
  MENU04      SPRING       4
  
 BOARD
   IDX      TITLE       MENU_ID
    3       SRPING      MENU04 
    2       JAVA 11     MENU01    
    1       JAVA        MENU01
    
 ----------------------------------
 CREATE  TABLE    MENUS
 (
       MENU_ID     VARCHAR2(6)   PRIMARY KEY
    ,  MENU_NAME   VARCHAR2(30)  NOT NULL 
    ,  MENU_SEQ    NUMBER(6)     DEFAULT 0
 )
 
 INSERT INTO  MENUS ( MENU_ID,  MENU_NAME, MENU_SEQ  )
  VALUES            ( 'MENU01', 'JAVA',   1 );
 COMMIT;
 
 -----------------------------------
 --  게시판
CREATE   TABLE   BOARD
(
      IDX            NUMBER(5, 0)        PRIMARY KEY
    , MENU_ID        VARCHAR2( 6 )       NOT NULL
        REFERENCES   MENUS ( MENU_ID  )
    , TITLE          VARCHAR2( 300  )    NOT NULL
    , CONT           VARCHAR2( 4000 )                       
    , WRITER         VARCHAR2( 30 )
    , REGDATE        DATE                DEFAULT  SYSDATE 
    , READCOUNT      NUMBER( 6, 0 )      DEFAULT  0
    
    , BNUM           NUMBER( 5, 0 )      DEFAULT  0
    , LVL            NUMBER( 5, 0 )      DEFAULT  0
    , STEP           NUMBER( 5, 0 )      DEFAULT  0
    , NREF           NUMBER( 5, 0 )      DEFAULT  0
)
 
 INSERT  INTO  BOARD (
      IDX, 
      MENU_ID, 
      TITLE, 
      CONT, 
      WRITER
)  VALUES  (  
      ( SELECT NVL(MAX(IDX), 0)+1  FROM  BOARD ),
      'MENU01',
      'JAVA 환영합니다',
      'JAVA 게시판에 오신것을 환영합니다.....',
      'ADMIN'
);
COMMIT;
 
 ------------------------------------
 -- 자료실을 위한 FILES 테이블 생성
 ------------------------------------
 CREATE   TABLE   FILES
 (
      FILE_NUM    NUMBER(6, 0)    NOT NULL   -- 파일 번호
    , IDX         NUMBER(6, 0)    NOT NULL   -- 게시물 번호
    , FILENAME    VARCHAR2(260)   NOT NULL   -- 파일이름
    , FILEEXT     VARCHAR2(260)   NOT NULL   -- 파일확장자 
    , SFILENAME   VARCHAR2(260)   NOT NULL   -- 저장된 실제 파일명
    
    , CONSTRAINT     FILES_PK     PRIMARY KEY  -- 기본키 (복합키)
    (
        FILE_NUM,
        IDX
    )
    , CONSTRAINT     FK_BOARD_FILES_IDX
      FOREIGN  KEY   (IDX)
      REFERENCES     BOARD(IDX)
     --  ON DELETE  CASCADE
 )
 
 
 
 
 
 
 
 
 
 
    
    
    
    
    
    
    







