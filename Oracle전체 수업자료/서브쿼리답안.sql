DROP TABLE subemp;
--emp ���̺� ����
Create Table subemp(
	emp_id 	   int, --�����ȣ
	emp_name	   Varchar(10) Not Null,  --����̸�
	job      	               Varchar(10) Not Null,  --����
	dept_id  	  int, --�μ���ȣ
	sal 	              int Not Null,--�޿�
	bonus	              int,--���ʽ�
	mgr_id	              int,--�����ڹ�ȣ
	hiredate             date  Not Null, --�Ի���
	constraint emp_id_pk Primary Key(emp_id) --��������
)

--�����ͻ���

INSERT INTO subEMP VALUES (6200,'��ö��','��ǥ',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO subEMP VALUES (6311,'�����','����',100, 3500,Null,6200, '1998-12-17');

INSERT INTO subEMP VALUES (7489,'�ε���','������',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO subEMP VALUES (7522,'����ö','������',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO subEMP VALUES (6321,'������','����',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO subEMP VALUES (6351,'������','����',300,   2850,NULL,6200,'2000-05-31');

INSERT INTO subEMP VALUES (7910,'�̿���','�渮',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO subEMP VALUES (6361,'��ö��','����',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO subEMP VALUES (7878,'����','������',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO subEMP VALUES (7854,'������','������',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO subEMP VALUES (7872,'�̹���','�繫��',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO subEMP VALUES (7920,'������','�繫��',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO subEMP VALUES (7901,'������','������',NULL, 3000,NULL,NULL,'2001-12-03');

INSERT INTO subEMP VALUES (7933,'��ö��','�繫��',200,  1050,NULL,6361,'2002-01-02');
--emp���̺� ���� / ���ڵ� �߰�

DROP TABLE subdept;

SELECT * FROM subdept;
CREATE TABLE subdept(dept_id int, dname VARCHAR(20) );
INSERT INTO subdept VALUES(100,'������');
INSERT INTO subdept VALUES(200,'�渮��');
INSERT INTO subdept VALUES(300,'�����');
INSERT INTO subdept VALUES(400,'������');

SELECT *FROM subemp;
SELECT *FROM subdept;


ex1) ������ ����� �μ���(dname)�� �˻��Ͻÿ�.

SELECT dname FROM subdept
WHERE dept_id=(SELECT dept_id FROM subEMP WHERE emp_name='������');

--join
select dname 
from  subemp join subdept
using(dept_id) 
where emp_name='������';




ex2) dept_id�� 100�� ����޿��� �ִ밪���� ���� �޴� ����� �˻��Ͻÿ�.

SELECT * FROM subEMP
WHERE sal > ( SELECT MAX(sal) FROM subemp WHERE dept_id=100 )



ex3)�޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ��� 
   ������ �μ����� �ٹ��ϴ� ������� ����

   1.�޿��� 3000�̻� �޴� ����� �Ҽӵ� �μ�
   SELECT DISTINCT dept_id FROM  subEMP WHERE sal >=3000

   2. 1 ���� ���� �μ���ȣ�� ���� �μ����� �ٹ��ϴ� ������� ��������.
   SELECT * FROM subEMP WHERE dept_id in (100, 400,200)

   * ���� �ι����� �ѹ���  ���������� ��ȯ.

   SELECT * FROM subEMP
   WHERE dept_id in 
   (SELECT DISTINCT dept_id FROM subEMP WHERE sal >=3000)
   ORDER BY dept_id



  ex4) �μ���ȣ�� 300�� ������߿��� �޿��� ���� ���� �޴� �������
      �� ���� �޿��� �޴� ����� ������ �˻�.

    SELECT * FROM subEMP
       WHERE sal > (SELECT max(sal) FROM subEMP WHERE dept_id=300)
       ORDER BY sal;
       
     SELECT * FROM subEMP
       WHERE sal > all (SELECT sal FROM subEMP WHERE dept_id=300)
       ORDER BY sal;



 ex5) �μ���ȣ�� 300�� ������߿��� �޿��� ���� ���� �޴� �������
     �� ���� �޿��� �޴� ����� ������ �˻�
     SELECT * FROM subEMP
       WHERE sal >  (SELECT MIN(sal) FROM subEMP WHERE dept_id=300)
       ORDER BY sal;
       
        SELECT * FROM subEMP
       WHERE sal >  any (SELECT sal FROM subEMP WHERE dept_id=300)
       ORDER BY sal;


ex6)�������� �޿��� ���� �ϰų� �� ���� �޴� ����� �����˻�
 SELECT * FROM subemp
 WHERE sal >= (SELECT sal FROM subEMP WHERE emp_name='������')


ex7)������ �繫���� ����� �μ���ȣ�� �μ��� ���
SELECT dept_id, dname FROM subDEPT
WHERE dept_id in (SELECT dept_id FROM subEMP WHERE job='�繫��')



ex8) �μ��� �渮���� ��� ����� �������
SELECT * FROM subEMP
WHERE dept_id =(SELECT dept_id FROM subDEPT WHERE dname='�渮��')


ex9)��ǥ�̻翡�� ���� �ϴ� ��� ����� �������
SELECT * FROM subEMP
WHERE mgr_id =(SELECT emp_id FROM subEMP WHERE job='��ǥ')




ex10) �̸��� '��'�� ���鼭 ��ձ޿����� ���� �޿��� �޴�
     ����� ������ �μ����� �ٹ��ϴ� ����� ���� �˻�.
      (��, �μ���ȣ null�� ������)
      
      SELECT dept_id FROM subEMP
      WHERE emp_name LIKE '%��%' AND
                sal > (SELECT AVG(sal) FROM subemp)
                       
                         
   SELECT * FROM subemp
   WHERE dept_id in ( SELECT dept_id FROM subEMP
                       WHERE emp_name LIKE '%��%' AND
                       sal > (SELECT AVG(sal) FROM subemp)
                       AND dept_id IS NOT null)


ex11) �� �μ��� � ��� �޿����� �޿��� ���� 
      �޴� ����� ������ �˻�
      
       1) �μ��� ��� �޿��� ���Ѵ�.
       SELECT dept_id,  AVG(sal) ��ձ޿� FROM subEMP
       where dept_id is not null
       group BY dept_id;
              
              
       2) ���� ��ձ޿������� �ִ밪���� Ŀ���Ѵ�.
    
 SELECT * FROM subEMP
 WHERE  sal > all (SELECT AVG(sal) ��ձ޿� FROM subEMP
               where dept_id is not null
              group BY dept_id);
              

 SELECT * FROM subEMP
 WHERE  sal > (SELECT  max(AVG(sal))  FROM subEMP 
                where dept_id is not null
                group BY dept_id);
              
 
 select distinct dept_id from subemp;
 SELECT AVG(sal)  FROM subEMP group BY dept_id
              
ex12)  ��� �繫�� ������� �޿��� �����鼭 �繫����
 �ƴ� ��� ����� �����˻�
SELECT * FROM subEMP
WHERE sal < ALL (SELECT sal FROM subEMP WHERE job='�繫��')
  AND not job = '�繫��';--�ּҰ����� �۴�.
  

  
  




