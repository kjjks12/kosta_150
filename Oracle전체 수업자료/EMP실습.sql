-- ������ �������� ����.
drop table emp;

--emp ���̺� ����
Create Table emp(
	emp_id 	   NUMBER(4)  Primary KEY, --�����ȣ
	emp_name	 Varchar2(20) Not Null,  --����̸�
	job      	               Varchar2(20) Not Null,  --����
	dept_id  	  NUMBER(3), --�μ���ȣ
	sal 	              NUMBER Not Null,--�޿�
	bonus	              NUMBER,--���ʽ�
	mgr_id	              NUMBER,--�����ڹ�ȣ
	hiredate             date  Not Null --�Ի���
)

--���̺����
DROP TABLE emp;


--�����ͻ���

INSERT INTO EMP VALUES (6200,'��ö��','��ǥ�̻�',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO EMP VALUES (6311,'�����','����',100, 3500,Null,6200, '1998-12-17');

INSERT INTO EMP VALUES (7489,'�ε���','������',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO EMP VALUES (7522,'����ö','������',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO EMP VALUES (6321,'������','����',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO EMP VALUES (6351,'������','����',300,   2850,NULL,6200,'2000-05-31');

INSERT INTO EMP VALUES (7910,'�̿���','�渮',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO EMP VALUES (6361,'��ö��','����',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO EMP VALUES (7878,'����','������',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO EMP VALUES (7854,'������','������',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO EMP VALUES (7872,'�̹���','�繫��',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO EMP VALUES (7920,'�踶����','�繫��',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO EMP VALUES (7901,'������','������',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO EMP VALUES (7933,'��ö��','�繫��',200,  1050,NULL,6361,'2002-01-02');


SELECT * FROM emp;


select * from emp where hiredate >'1999-01-01'

1)
2











