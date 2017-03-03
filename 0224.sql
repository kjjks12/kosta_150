select * from emp;

* ���̺� ���� - ���������� ����ȵ�!!!
 1) ���̺����� ���ڵ� ��� ����
 create table ���̺��̸�
 as ���������̺���;
 
 create table copy_emp
 as select * from emp;
 
 select * from copy_emp;
 
 --�������� �߰�
 alter table copy_emp add constraint copy_emp_empno_pk primary key(empno);
 
 
 2) ���ϴ� �÷��� ���ڵ常 ����
 create table copy_emp2
 as select empno, ename, job, sal from emp where deptno=20;
 
 
 drop table copy_emp2;
 
 select * from copy_emp2;
 
 
 3) ���̺� ������ ����
   create table copy_emp3
   as select * from emp where 1=0;
   
   select * from copy_emp3;
   
   --------------------------------------------------
  
   --���ڵ� ����
   insert into ���̺��̸�(�÷���, �÷���,....) values(��,��,....);
   insert into ���̺��̸� values(��,��,....);
   
   --���ڵ� ����
   update ���̺��̸�
   set �÷���=���氪, �÷���=���氪,....
   [where ���ǽ�]
   
   --���ڵ� ����
   delete from ���̺��̸�
   [where ���ǽ�]
   
   truncate table ���̺��̸� ;--��緹�ڵ����(rollback�ȵ�)
 
 -------------------------------------------------------------------
   1. scott�������� �����Ѵ�.
   2. emp���̺� ��ü�� �����Ѵ�.
   
   3. ������ ���̺��� ������ �ǽ��Ѵ�.
     select * from copy_emp;
     
  ex) empno�� 7499�� ename�� '������', sal�� 2000���� ����
   update copy_emp 
   set ename='������' , sal=2000  
   where empno=7499;
  
  ex) sal 1000 ~ 2000������ ���ڵ��� job�� '�л�', hiredate��
      ���� ��¥�� �����Ѵ�.
      
      update copy_emp
      set job='�л�' , hiredate=sysdate
      where sal >=1000 and sal <=2000;
      
      update copy_emp
      set job='�л�' , hiredate=sysdate
      where sal between 1000 and 2000 ;
      
      
  ex) sal 3000�̻��� ���ڵ带 �����Ѵ�.
    delete from copy_emp
    where sal >=3000;
    
 -----------------------------------------------------------
 *select����
 /*
   select distinct | * | �÷��� as ��Ī, �÷��� ��Ī ,......
   from ���̺��̸�
   where ���ǽ�
   order by ���Ĵ���÷� asc | desc , ���Ĵ���÷� asc|desc,...
 
 */
 ex) ���ϴ� �÷��� ��Ī �ֱ�
 select * from emp;
 
 select empno as "��� ��ȣ" , ename �̸�, job, sal  from emp;
 
 ex) ~�� �޿��� ~ �Դϴ�. 
  select ename || '�� �޿��� ' || sal || '�Դϴ�.' as �޿�����
  from emp;
  
ex) ����(job) ���� �˻�
select job from emp order by job;
select distinct job from emp order by job; --�ߺ��� ����
 
 
ex) job�� �������� �������������ϰ� ������ sal�� �������� �������� ����
 select * from emp
 order by job desc , sal desc;
 -------------------------------------------------------------
 ex) sal + comm ���ؼ� �˻�
 select empno, ename, sal, comm ,  (sal + comm)*12 as ���
 from emp;
 
 * null�� ������ �ȵȴ�(null�� �ٸ������� ����)
    nvl(��,���氪)
      -> ������ null���� ã�� null�� ���氪�� ��ġ�Ѵ�.
 
  select empno, ename, sal, comm ,  
  (sal + nvl(comm,0))*12 || '����' as ���
 from emp;
 
 --����
  1) or
  2) and
  3) �÷��� in (��,....)
  4) �÷��� between �ּ� and �ִ�
  5) not �� �̿� ( 1,2,3,4 �� ����)
  
ex) empno�� 7499,7566, 7654 �� ����˻� (or  , in ��� �غ���)
 select * from emp
 where empno=7499 or empno=7566 or empno=7654;
 
 select * from emp
 where empno in (7499,7566,7654);
 
 
 select * from emp where not (empno=7499 or empno=7566 or empno=7654);
  select * from emp where empno not in (7499,7566,7654);


ex) sal 2000 ~ 3000 ������ ����� ���� �˻� (and, between ��� �غ���.)
 select * from emp where sal >=2000 and sal <=3000;
 select * from emp where sal between 2000 and 3000;
 
 select * from emp where not (sal >=2000 and sal <=3000);
 select * from emp where sal not between 2000 and 3000;


ex) deptno�� 10�̰ų� 20�� ����߿��� sal�� 1000 ~ 2000���̰�
    �ƴ� ��� �˻�
    select * from emp
    where deptno in (10,20) and  (sal not between 1000 and 2000)
    order by sal;
    

ex) job�� salesman�̸鼭 sal�� 1500�̻��� ��� �˻�
  select * from emp  where job ='salesman';
  
   *���� : oracle�� �����Ͱ��� ��ҹ��ڸ� �����Ѵ�.
           lower(��)  or  upper(��)
           
   select ename, lower(ename), upper(ename) from emp;
    
  select * from emp  where lower(job) = lower('salesman');
  
  
  select * from emp  
  where lower(job) = lower('salesman') and sal >=1500
----------------------------------------------------------------------
 --���ڿ��˻�
  1) _ : �ѱ��ڰ˻�
  2) % : 0�� �̻���ڰ˻�
  
    ���� :  _�� %�� like�����ڿ� �Բ� ����ؾ��Ѵ�.
 
 ex) job�� a���ڿ��� ������ ��� ���ڵ� �˻�
  select * from emp
  where lower(job) like '%a%';
 
 ex) ename�� ù���� C�� �����ϰ� �����ڰ� K�� ������ 5���� ���ڵ� �˻�
 select * from emp where upper(ename) like 'C___K';
 
 ex) job�� �� ���ڰ� R�� ������ ���ڵ� �˻�
 select * from emp where upper(job) like '%R';
------------------------------------------------------------------------
ex)comm �� null�� ���ڵ� �˻�???
 select * from emp where comm = null;
 select * from emp where comm = 'null';
 
 ��� : nullã�� ���
        is null
        is not null
        
 select * from emp where comm is null;
 select * from emp where comm is not null;
 ----------------------------------------------------------------
 any : �ּ��� �ϳ��� ��ġ�ϸ� ��
      �÷��� > any(��,��,....)   ==> �ּҰ����� ũ�� ��.
      �÷��� < any(��,��,....)   ==> �ִ밪���� ������ ��.
 
 all : ��� ��ġ(����)�ؾ߸� ��.
       �÷��� > all(��,��,....)   ==> �ִ밪���� ũ�� ��.
       �÷��� < all(��,��,....)   ==> �ּҰ����� ������ ��.
 
   *any�� all�� �ַ� ������������ ���� �̿��!!
   
   select * from emp 
   where sal > any (1000,2000 ,3000) order by sal; --�ּҰ� ����ũ�� ��
   
   select * from emp 
   where sal < any (1000,2000 ,3000) order by sal; --�ִ밪 ���� ������ ��.
   
   select * from emp 
   where sal > all (1000,2000 ,3000) order by sal; --�ִ밪���� ũ�� ��.
   
   select * from emp 
   where sal < all (1000,2000 ,3000) order by sal; --�ּҰ����� ������ ��
   
   ex) deptno�� 20�� ����� �� �޿��� �ִ밪���� ���� �޴� ��� �˻�
   
   select * from emp
   where sal > all (select sal from emp where deptno =20)
   
   --------------------------------------------------------------
   --�����Լ�
   sum() : �հ�
   max() :�ִ밪
   min() : �ּҰ�
   avg() : ���(null�� ������ ���)
   count(�÷���) : null�� ������ ���ڵ��
   count(*) : null�� ������ �� ���ڵ��
   rank : ����
   
   --����ǥ ���̺�
   create table sungjuk(
      ban number(1),
      name varchar2(20),
      kor number(3),
      eng number(3),
      math number(3)
   );
   
   -- ���ڵ� ����
  insert into sungjuk values(1, '����',90,80,70); 
  insert into sungjuk values(1, '�ֱ���',70,50,40);
  
  insert into sungjuk values(2, '���±�',50,70,20);
  insert into sungjuk values(2, '�̻�ȣ',30,70,20);
  insert into sungjuk values(2, '������',50,80,90);
  
  insert into sungjuk values(3, '������',90,80,95);
  insert into sungjuk values(3, '������',50,30,60);
  insert into sungjuk values(3, '������',null,50,60);
  
  select * from sungjuk;  
  
  ex) ���κ� ������ ����� ���Ѵ�.
   select ban, name, kor, eng, math , 
   (nvl(kor,0)+eng+math) as ���� , 
   round((nvl(kor,0)+eng+math) /3 , 0)as ���
   from sungjuk;
   
  
  ex) ���������� ����, ���, �ִ�, �ּҰ�
  select sum(kor) , avg(kor)  , avg(nvl(kor,0)), max(kor) , min(kor)
  from sungjuk; 
    * �����Լ��� ����� �ݵ�� ��ü���ڵ带 ������ ����, ���, �ִ�,�ּ�
      �� ���ϴ� ���̱⶧���� ��� ���ڵ�� �Ѱ��̴�.
  
  ex) �ѷ��ڵ� ��
  select count(kor), count(*) from sungjuk;
  
  ex) �� �ݺ� ���������� ������ ���
  select ban , sum(kor) , avg(kor)
  from  sungjuk
  group by ban;
  
  
  
  select name , sum(kor) , avg(kor)
  from  sungjuk;--����
   * �Ϲ��÷��� �����Լ��� �Բ� select������ ����Ҽ� ����.
      ��, group by���� ���� �÷��� select������ ��밡���ϴ�.
      
      
  ex) emp���̺��� �� �μ��� �޿�����հ����ڵ��(�ο���) �˻�!
   select deptno , avg(sal) , count(sal)
   from emp
   group by deptno
   
  ex) kor�� ������ 50 �̻��� ���ڵ���� �� �ݺ� �հ�, ��� ���Ѵ�.
  select ban , sum(kor), avg(kor)
  from sungjuk
  where kor >=50
  group by ban;  
  
  
  ex) �� �ݺ� kor�� ����� 50 �̻��� ���ڵ����  �հ�, ��� ���Ѵ�.
   select ban , sum(kor), avg(kor)
  from sungjuk
  where avg(kor) >=50
  group by ban;  --�����߻�(�����Լ��� where������ �������� ����Ҽ� ����)
   
  select ban , sum(kor), round(avg(kor))
  from sungjuk
  group by ban
  having avg(kor) >=50;
  
   * ��� : �����Լ��� ����� �������� ����Ҷ��� having���� ����Ѵ�.    
            �̶�, group by�� ���� having�� ����ϴ� ���� �ǹ� ����!!!
  

  --���� ���ϱ�
  ex) emp���̺��� sal�� 3000�� ����� �������� �˻�!!!
  select rank(3000) within group(order by sal )from emp;
  select rank(3000) within group(order by sal desc)from emp;
 ---------------------------------------------------------------------  
   --�����Լ�
   round(����, �ڸ���) : �ڸ��� = 0 �̸� ������ �ݿø�
                                  1 �̸� ù��° �ڸ����� �ݿø�
                                  
  ceil(����) : ������ �ø�
  floor(���� : ������ ����
  trunc(����, �ڸ���) : �ڸ������� ����.
  mod(����, ������)  : ������
    
 ex)
   select sysdate , '������' , 25000  from dual;
   
   select 245.34561 , round(245.34561 , 0 ) , round(245.34561, 2),
   ceil(245.34561) ,floor(245.34561) , trunc(245.34561 , 2)
   from dual;
  -------------------------------------------------------------
  *���ڿ� �Լ�
  upper(���ڿ�)
  lower(���ڿ�)
  initcap(���ڿ�) : �ܾ��� ù���ڸ� �빮�ڷ� ��ȯ.
  
  instr(���ڿ�, ã�����ڿ�) : ã�� ���ڿ��� �ִ� ��ġ(index)�� �˷��ش�.
  instr(���ڿ�, ã�����ڿ� ,������ġ) 
  instr(���ڿ�, ã�����ڿ�, ������ġ, �������ġ) :
    => ������ġ���� ���� ����� ��ġ�� �ִ� ������ ��ġ�� �˻��Ѵ�.
    => ������ġ�� -1�� �ָ� ������ ���� �˻��Ѵ�.
    => ã�� ���ڿ��� ���� ��� 0�� ����.
   
 substr(���ڿ�, ���۹���) : ���ڿ����� ���۹������� ������ ����
 substr(���ڿ�, ���۹��� , ����) :���ڿ����� ���۹������� �������� ����
 
 lpad(���ڿ�, ��ü�ڸ���, ����)
 rpad(���ڿ�, ��ü�ڸ���, ����)
 ltrim(���ڿ�) : ���� ��������
 rtrim(���ڿ�) : ������ ��������
 
 length(���ڿ�) : ���ڿ��� ����.

ex)
 select 'abcdabcdabcd' , 
 instr('abcdabcdabcd' , 'c') , 
 instr('abcdabcdabcd' , 'c' , 4) ,
 instr('abcdabcdabcd' , 'c' ,4 ,1) ,
 instr('abcdabcdabcd' , 'c',4, 2) ,
 instr('abcdabcdabcd' , 'c', -1) 
 from dual;
 
ex)
 select 'abcdabcdabcd' , substr('abcdabcdabcd' , 1),
  substr('abcdabcdabcd' , 5) , substr('abcdabcdabcd' , 3, 3)
  from dual;
  
ex) emp���̺��� job�� ����° ���ڰ� a�� ���ڵ� �˻�(
  1) like�̿�
   select * from emp where lower(job) like '__a%';
  
  2) substr�̿�
   select * from emp where  substr(lower(job) ,3,1)='a'
  
  3) instr�̿�
  select * from emp where instr(lower(job),'a',3,1) =3;
   
  
   
 ex) emp���̺��� hiredate�� 1980�� ���ڵ� �˻� (substr�̿�)  
   select * from emp where substr(hiredate,1,2) ='80';
   
   select hiredate , to_char(hiredate ,'YYYY' ) ,
    to_char(hiredate ,'YYYY-MM-DD' ) , 
     to_char(hiredate ,'YYYY-MM-DD HH:MI:SS' )
   from emp;
   
   
   select * from emp
   where substr( to_char(hiredate, 'YYYY-MI-DD') , 1, 4) = '1980';
   
   
  ex)���ڿ� ����
  select ename ,length(ename) , job , length(job) from emp; 
 
 -----------------------------------------------------------------
  * ����ȯ�Լ�
  to_char() : ���ڿ��� ��ȯ
  to_date() : ��¥�� ��ȯ
  to_number() : ���ڷκ�ȯ
  
  ex) to_char(��¥ ,'YYYY-MM-DD HH:MI:SS');
      to_char(256000 , '999,999');
 
  select 2568700000 , to_char(256870 , '999,999') , 
  to_char(2568700000 , '999,999,999,999')
  from dual;
---------------------------------------------------------
 select sysdate , 
 to_char(sysdate ,'YYYY-MM-DD HH:MI:SS')
 from dual;
 -------------------------------------------------------
  *��¥�Լ�
   sysdate  :���糯¥�� �ð�
   months_between(��¥,��¥) : �� ��¥ �� �������� ���� ����.
   add_months(��¥, ����) : ��¥���� ���ڸ�ŭ �������� ���Ѵ�.
   next_day(��¥, ����) : ��¥���� ���� ����� ������ ��¥�� ����.
     - ���� 1�̸� �Ͽ���, 2�̸� ������...... 7�̸�  �����
   last_day(��¥) : ��¥�� �ش��ϴ� �״��� ������ ��¥�� ����.
   
   select months_between(sysdate , '2016-2-3')  from dual;
   select add_months(sysdate, 5) from dual;
   
   select last_day(sysdate) from dual;
  
 ex) hiredate�� �������� �� �ٹ��������� ���Ѵ�(���糯¥�� ��������..)
     ���� : �Ҽ�������, �ѱٹ� ~ ����  ��� , ��Ī�� �� �ٹ� ���� ��
  select hiredate , 
  '�� ' || floor(months_between(sysdate , hiredate)) || '����' as "�� �ٹ� ���� ��"
  from emp;
  
 ex)���ó�¥�� �������� ���� ���� ȭ���� ���Ѵ�.
    select next_day(sysdate, 3) from dual;
 
 
 ex) ������� ������ �� ���Ѵ�.
   select last_day(sysdate) from dual;
 
 ex) �츮�� ������ 100�� �������� ���Ѵ�.
   select to_date('2017-01-23') +100 
   from dual;
 
  
  
  


 