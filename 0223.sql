/*
  �ڷ��� - DATATYPE
  1) ������
     VARCHAR2(BYTE��) , CHAR(BYTE��) 
     NVARCHAR2 , NCHAR, TEXT ,LONG
  
  2) ������
     NUMBER(�ڸ���)
     NUMBER(�ڸ���,�ڸ���) - �Ǽ���
     INT , SMALLINT ,INTEGER
     
  3) ��¥��
     DATE 

*/

--���̺����
 CREATE TABLE ���̺��̸�(
   �÷��� DATATYPE [NULL | NOT NULL] [��������],
   �÷��� DATATYPE [NULL | NOT NULL] [��������],
   ...
 );


--EX) �ڷ��� TEST
 CREATE TABLE TYPE_TEST(
   name1 char(5), --��������
   name2 varchar2(5), -- ��������
   name3 varchar2(5 byte), -- 5byte(�ѱ��� 2���ڸ� ����)
   name4 varchar2(5 char), -- 5����
   name5 char, --1byte����
   name6 varchar2(3) -- �ݵ�� �ڸ������� �ʼ�!!
 );
 
 --���ڵ� ����
 insert into type_test(name1, name2,name3,name4,name5,name6)
 values('��','��','��','��','A','B');
 
 insert into type_test(name3) values('������'); --����(�ִ� 5byte�̹Ƿξȵ�)
insert into type_test(name4) values('������');
 
 --���ڵ� �˻�
 select  * from type_test;
 
 --���̺� ����
 desc type_test;
 
 --������ test
create table number_test(
  num1 number,
  num2 number(2), -- -99 ~ 99
  num3 number(5,2),
  num4 int,
  num5 smallint,
  num6 integer
);

desc number_test;

insert into number_test(num2) values(99);
insert into number_test(num2) values(-99);
insert into number_test(num2) values(100);--����(2�ڸ�������)

insert into number_test(num3) values(230.54587);
insert into number_test(num1) values(25000);
select * from number_test;

--��¥��
create table date_test(
   birth date
);

insert into date_test(birth) values('2017-08-20');
insert into date_test(birth) values(sysdate);

select * from date_test;
----------------------------------------------------------
/*
  �������� ����
  1) primary key 
  2) Foreign key
  3) unique
  4) check
  5) default 
*/

   1) primary key 
   => �⺻Ű, ��ǥŰ, ��Ű
   => �ߺ��ȵ�, not null
   => �����̺� �ݵ�� �Ѱ��� ����
      (�������� �÷��� ��� �ϳ��� pk����)
   => �ڵ����� unique index ����(�˻��ӵ� ������ ó��)

 ex)
  create table member(
     id varchar2(20) constraint member_id_pk primary key,
     name varchar2(10) not null,
     age number(3)
  );
  
  select * from member;
  
  --���ڵ� ����
  insert into member(id,name,age) values('jang','������',18);

  insert into member(id,name,age) values(null,'������',18);--����
  insert into member(id,name,age) values('jang','������',18);--����
  
 insert into member(id,name,age) values('hee','������',18);--����
 
 insert into member(id,name,age) values('kim','������',null);--����
 
 insert into member(id,name,age) values('aa',null,20); --����
 
 
 --���̺� ����
 drop table member;
 
 
 *�ΰ��� �÷��� �ϳ��� ��� PK����
 create table member(
   id varchar2(20) ,
   name varchar2(10),
   age number(3),
   constraint member_id_name_pk primary key(id,name)
 )
 
 select * from member;
 
 insert into member(id, name, age) values('aa','������',10);
 
 insert into member(id, name, age) values('bb','������',10);
 
 insert into member(id, name, age) values('aa','�̳���',10);
 
  insert into member(id, name, age) values('aa','�̳���',30); --����
 
 insert into member(id, name, age) values('cc', null,30); --�����߻�
 
 -------------------------------------------------------------------
 2) Foreign key - �ܷ�Ű,����Ű,fk
  => �ٸ� ���̺��� �⺻Ű�� ���� �ϴ°�.
  => ���ڵ带 �����Ҷ� �����Ǵ� �÷��� �� �̿ܿ��� ���� �ȵ�.
  => �����̺� �������� fk ����. null��� ,�ߺ�����.
  => insert �Ҷ� : �θ� insert -> �ڽ� insert 
     delete �Ҷ� : �ڽ� delete -> �θ� delete
     ����, fk�� �����Ҷ� on delete cascade �� �Բ� ����ϸ�
           �θ�����ɶ� �����ǰ� �ִ� �ڽķ��ڵ嵵 �Բ� �����ȴ�.
 
 
 ex) �μ����� ���̺�
  create table dept(
    dept_no  number(3) constraint dept_no_pk primary key ,
    dname varchar2(20)
  );
 
 ex) ������� ���̺�
 create table emp(
   empno number(3) constraint emp_empno_pk primary key,
   ename varchar2(20),
   dept_no number(3) constraint emp_deptno_fk references dept(dept_no)
 );
 
 insert into emp(empno, ename, dept_no)values(1, '������',100);--����(�θ�Ű ��� �ȵ�)
 insert into emp(empno, ename, dept_no)values(1, '������',null);
 
 ex)  dept���̺� ���ڵ� ����
 insert into dept(dept_no , dname)values(100,'������');
 insert into dept(dept_no , dname)values(200,'�渮��');
 insert into dept(dept_no , dname)values(300,'������');
 
 select *from dept;
   
 select * from emp;
 
 ex) emp���̺� ���ڵ� ����
 insert into emp values(2,'��ȿ��',200);
 insert into emp values(3,'����ȣ',200);
insert into emp values(4,'�̰���',100);

--���ڵ� ����
 1) �θ����
  delete from dept where dept_no=300; --�����Ǵ� �ڽ�Ű �����Ƿ� �����Ϸ�
  delete from dept where dept_no=200;--����(�����Ǵ� �ڽ�Ű�� ���� ����..)
 
  --�ڽ�Ű ����
  delete from emp where dept_no=200;
  
  --�θ�Ű ����
 
 select * from dept;
 select * from emp;
 
 --���̺� ����
 drop table emp;
 drop table dept;
 -------------------------------------------------
  * fk �����Ҷ� on delete cascade ����
 
ex) �μ����� ���̺�
  create table dept(
    dept_no  number(3) constraint dept_no_pk primary key ,
    dname varchar2(20)
  );
 
 ex) ������� ���̺�
 create table emp(
   empno number(3) constraint emp_empno_pk primary key,
   ename varchar2(20),
   dept_no number(3) constraint emp_deptno_fk 
    references dept(dept_no) on delete cascade
 );
 
 select * from dept;
 select * from emp;
 
 --�ڽ��� �����ǰ� �ִ� �θ�Ű�� �����غ���.
 delete from dept where dept_no=200;
 
 
 
 
 *fk(�ܷ�Ű)�� ������ �����ϴ� ���
 drop table emp;
 
  create table emp(
   empno number(3) constraint emp_empno_pk primary key,
   ename varchar2(20),
   dept_no number(3) ,
   constraint emp_fk foreign key(dept_no) references dept(dept_no)
   on delete cascade
 );
 





