-- 1.1��) Ư�� ������ �μ��� �޾� �� ������ �����ϴ� ���� ���� �˻��� �˻��ϴ� ���ν��� �ۼ�.

CREATE OR REPLACE PROCEDURE P_SELTEACHER(iSUBJECT IN SUBJECT.����%TYPE)
IS
	iNAME TEACHER.�����̸�%TYPE;
BEGIN
	SELECT �����̸� INTO iNAME
	FROM SUBJECT TS INNER JOIN TEACHER TT
	ON TS.�����ڵ� = TT.�����ڵ�
    WHERE TS.���� = iSUBJECT;

    DBMS_OUTPUT.PUT_LINE(iSUBJECT || ' �� �����ϴ� ���� : ' || iNAME);
END;


EXEC P_SELTEACHER('java');

==================================================================================
-- 2.2��) Ư�� ������ �����ϰ� �ִ� �л��� ������ �˻��ϴ� ���ν��� �ۼ�.

CREATE OR REPLACE PROCEDURE P_SELSTUDENT(iSUBJECT IN SUBJECT.����%TYPE)
IS
	iNAME STUDENT.��_�̸�%TYPE;
BEGIN
  SELECT ��_�̸� INTO iNAME
  FROM STUDENT TA INNER JOIN SUGANG TB
  ON TA.��������ȣ = TB.��������ȣ
  INNER JOIN SUBJECT TC
  ON TB.�����ڵ� = TC.�����ڵ�
  WHERE TC.���� = iSUBJECT;

  DBMS_OUTPUT.PUT_LINE(iSUBJECT || ' �� �����ϴ� �л� : ' || iNAME);
END;


exec P_SELSTUDENT('java')
===================================================================================
-- 3.3��) 1~100 ���̸� �ݺ��ϵ� 10�� ����� ����ϴ� ���ν��� �ۼ�.

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

--�÷��߰�
alter table member add addr varchar2(20) default '����';


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
    DBMS_OUTPUT.PUT_LINE('�� ���ڵ� �� : ' || cDATA%ROWCOUNT);
    CLOSE cDATA;
END;

EXEC P_INMEMBER('33', 'ȫ����', 30, '�λ�');


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
    DBMS_OUTPUT.PUT_LINE('�� ���ڵ� �� : ' || cDATA%ROWCOUNT);
    CLOSE cDATA;
END;

EXEC P_UPMEMBER('1111', '������', 22);

-----------------------------------------------------------
-- 6.
CREATE OR REPLACE PROCEDURE P_SELTOTAL
IS
	CURSOR cDATA IS
    	SELECT TA.�����ȣ, TA.�����̸�, TA.�����ڵ�, TB.����, TC.���ǽǹ�ȣ, TD.�����ο�
  		FROM TEACHER TA INNER JOIN SUBJECT TB
        ON TA.�����ڵ� = TB.�����ڵ�
        INNER JOIN SUGANGTB TC
        ON TB.�����ڵ� = TC.�����ڵ�
        INNER JOIN ROOM TD
        ON TC.���ǽǹ�ȣ = TD.���ǽǹ�ȣ;

    iNUM TEACHER.�����ȣ%TYPE;
    iNAME TEACHER.�����̸�%TYPE;
    iCODE TEACHER.�����ڵ�%TYPE;
    iSUB SUBJECT.����%TYPE;
    iROOMNUM SUGANGTB.���ǽǹ�ȣ%TYPE;
    iCNT ROOM.�����ο�%TYPE;
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
  DBMS_OUTPUT.PUT_LINE('����');
end;


select * from bbb;


COMMIT;







