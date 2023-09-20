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




