-- 1.1번) 특정 과목을 인수로 받아 그 과목을 강의하는 강사 정보 검색를 검색하는 프로시져 작성.

CREATE OR REPLACE PROCEDURE P_SELTEACHER(iSUBJECT IN SUBJECT.과목%TYPE)
IS
	iNAME TEACHER.강사이름%TYPE;
BEGIN
	SELECT 강사이름 INTO iNAME
	FROM SUBJECT TS INNER JOIN TEACHER TT
	ON TS.수강코드 = TT.수강코드
    WHERE TS.과목 = iSUBJECT;

    DBMS_OUTPUT.PUT_LINE(iSUBJECT || ' 을 강의하는 강사 : ' || iNAME);
END;


EXEC P_SELTEACHER('java');

==================================================================================
-- 2.2번) 특정 과목을 수강하고 있는 학생의 정보를 검색하는 프로시져 작성.

CREATE OR REPLACE PROCEDURE P_SELSTUDENT(iSUBJECT IN SUBJECT.과목%TYPE)
IS
	iNAME STUDENT.수_이름%TYPE;
BEGIN
  SELECT 수_이름 INTO iNAME
  FROM STUDENT TA INNER JOIN SUGANG TB
  ON TA.수강생번호 = TB.수강생번호
  INNER JOIN SUBJECT TC
  ON TB.수강코드 = TC.수강코드
  WHERE TC.과목 = iSUBJECT;

  DBMS_OUTPUT.PUT_LINE(iSUBJECT || ' 을 수강하는 학생 : ' || iNAME);
END;


exec P_SELSTUDENT('java')
===================================================================================
-- 3.3번) 1~100 사이를 반복하되 10의 배수만 출력하는 프로시져 작성.

CREATE OR REPLACE PROCEDURE P_PRINTTEN
IS
	--iRESULT NUMBER;
BEGIN
	DBMS_OUTPUT.PUT_LINE('==============================');
    FOR iRESULT IN 1 .. 100 LOOP
    	IF (MOD(iRESULT, 10) = 0) THEN DBMS_OUTPUT.PUT_LINE(iRESULT);
      END IF;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('==============================');
END;

EXEC P_PRINTTEN;

===================================================================================


==============================================================================================================
select * from member;

--컬럼추가
alter table member add addr varchar2(20) default '서울';


-- 4.
CREATE OR REPLACE PROCEDURE P_INMEMBER(iID MEMBER.ID%TYPE,
					                             iNAME MEMBER.NAME%TYPE,
                                        iAGE MEMBER.AGE%TYPE,
                                        iADDR MEMBER.ADDR%TYPE)
IS
	CURSOR cDATA IS SELECT * FROM MEMBER;
    iDATA MEMBER%ROWTYPE;

BEGIN
	INSERT INTO MEMBER VALUES (iID, iNAME, iAGE, iADDR);

  	OPEN cDATA;
    LOOP
    	FETCH cDATA INTO iDATA;
        EXIT WHEN cDATA%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(iDATA.ID || ', ' || iDATA.NAME || ', ' || iDATA.AGE || ', ' || iDATA.ADDR);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('총 레코드 수 : ' || cDATA%ROWCOUNT);
    CLOSE cDATA;
END;

EXEC P_INMEMBER('33', '홍하하', 30, '부산');


========================================================================================
-- 5.
CREATE OR REPLACE PROCEDURE P_UPMEMBER(iID MEMBER.ID%TYPE,
				                             	iNAME MEMBER.NAME%TYPE,
                                        iAGE MEMBER.AGE%TYPE)
IS
	CURSOR cDATA IS	SELECT * FROM MEMBER;
    iDATA MEMBER%ROWTYPE;
BEGIN
	UPDATE MEMBER SET NAME = iNAME, AGE = iAGE WHERE ID = iID;
	  COMMIT;

  	OPEN cDATA;
    LOOP
    	FETCH cDATA INTO iDATA;
        EXIT WHEN cDATA%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(iDATA.ID || ', ' || iDATA.NAME || ', ' || iDATA.AGE || ', ' || iDATA.ADDR);
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('총 레코드 수 : ' || cDATA%ROWCOUNT);
    CLOSE cDATA;
END;

EXEC P_UPMEMBER('1111', '추하하', 22);

-----------------------------------------------------------
-- 6.
CREATE OR REPLACE PROCEDURE P_SELTOTAL
IS
	CURSOR cDATA IS
    	SELECT TA.강사번호, TA.강사이름, TA.수강코드, TB.과목, TC.강의실번호, TD.수용인원
  		FROM TEACHER TA INNER JOIN SUBJECT TB
        ON TA.수강코드 = TB.수강코드
        INNER JOIN SUGANGTB TC
        ON TB.수강코드 = TC.수강코드
        INNER JOIN ROOM TD
        ON TC.강의실번호 = TD.강의실번호;

    iNUM TEACHER.강사번호%TYPE;
    iNAME TEACHER.강사이름%TYPE;
    iCODE TEACHER.수강코드%TYPE;
    iSUB SUBJECT.과목%TYPE;
    iROOMNUM SUGANGTB.강의실번호%TYPE;
    iCNT ROOM.수용인원%TYPE;
BEGIN
  	OPEN cDATA;
    LOOP
    	FETCH cDATA INTO iNUM, iNAME, iCODE, iSUB, iROOMNUM, iCNT;
        EXIT WHEN cDATA%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(iNUM || ', ' || iNAME || ', ' || iCODE || ', ' || iSUB || ', ' || iROOMNUM || ', ' || iCNT);
    END LOOP;
    CLOSE cDATA;
END;

EXEC P_SELTOTAL;


create or replace procedure pcreate(tableName varchar2)
is
begin
  create table tableName(
    id varchar2(10) primary key,
    age number(3)
  );
  DBMS_OUTPUT.PUT_LINE('성공');
end;


select * from bbb;


COMMIT;







