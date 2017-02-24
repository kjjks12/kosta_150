/*
  �ڷ��� - DATATYPE
  1) ������
      CHAR(BYTE��),VARCHAR2(BYTE��)
      NVARCHAR2, NCHAR, TEXT, LONG
      
  2) ������
      NUMBER(�ڸ���)
      NUMBER(�ڸ���,�Ҽ����ڸ���)-�Ǽ���
      INT, SMALLINT
      
  3) ��¥��
      DATE
*/

--���̺� ����
CREATE TABLE ���̺� �̸� (
  �÷��� DATATYPE _[NULL | NOT NULL] [��������],
  
);

EX) �ڷ��� test
CREATE TABLE TYPE_TEST(
  name1 char(5),          --�������� 
  name2 varchar(5),       --��������
  name3 varchar(5 byte),  --5byte(�ѱ��� 2���ڸ� ����)
  name4 varchar(5 char),  --5����.5����
  name5 char,             --default 1byte����
  name6 varchar2(3)       --�ݵ�� �ڸ��� ���� �ʼ�
);

--���ڵ� ����
insert into type_test(name1, name2, name3, name4, name5, name6)
values('Ȳ','��','��','��','A','b');

insert into type_test(name3) values('Ȳ����');--����!�ִ�5byte�̹Ƿ� �ȵ�
insert into type_test(name4) values('Ȳ����');--9byte������ �������̹Ƿ� ��

--���ڵ� �˻�
select * from type_test;

delete type_test from [where ���ǽ�]  



--���ڵ� ����
desc TYPE_TEST;


--������ test
create table number_test(
  num1 number,              --default�� ??
  num2 number(2),           --���ڸ�!(-99~99)
  num3 number(5,2),         --�� �ټ��ڸ��� ���ڸ��� �Ҽ����ڸ�
  num4 int,
  num5 smallint,
  num6 integer
);

desc NUMBER_Test;

insert into number_table(num2) values(99);
insert into number_table(num2) values(-99);
insert into number_table(num2) values(100);

insert into number_table(num3) values(230.54587);
insert into number_table(num1) values(25000);

select * from number_test;


--��¥��
create table date_test(
  birth date
);

drop table date_test;


insert into date_test(birth) values('1992-08-18');
insert into date_test(birth) values(sysdate);

select * from date_test;


---------------------------------------------------------------------------------------

/*
  �������� ����
  1) primary key ��
  2) Foreign key ��
  3) unique
  4) check
  5) default
*/

1) primary key (�⺻Ű, ��ǥŰ, ��Ű)
- �ߺ��ȵ�, Not null
- �����̺� �ݵ�� �Ѱ��� ����  (�������� �÷��� ��� �ϳ��� pk����)
- �ڵ����� unique index ����  (�˻��ӵ� ������ ó��)

ex)
create table member(
  id varchar2(20) constraint member_id_pk PRIMARY KEY,
  name varchar2(10) not null,
  age number(3)

);
  
select * from member;

--���ڵ����
insert into member(id,name,age) values('hyj','Ȳ����',26);
insert into member(id,name,age) values(null,'Ȳ����',26);  --����! id�� �⺻Ű�̹Ƿ� not null
insert into member(id,name,age) values('hyj','Ȳ����',26); --����!      �⺻Ű�� �ߺ��ȵ�
insert into member(id,name,age) values('hwang','Ȳ����',26);
insert into member(id,name,age) values('zzZZ','�쵿��',null);
insert into member(id,name,age) values('abcd',null,26);
insert into member  values('apple','�쵿��',26);
  
--���̺� ����
drop table member;


*2���� �÷��� �ϳ��� ��� �⺻Ű�� ����
create table member(
  id varchar2(20),
  name varchar2(10),
  age number(3),
  
  constraint member_id_name_pk PRIMARY KEY(id,name)
);

select * from member;

insert into member values('udong','�쵿��',20);
insert into member values('udong2','�쵿��',20);
insert into member values('udong','�쵿��2',20); --2���� pk�� �ϳ��� �޶� ���尡��.�ٸ�Ű�� �ν�
insert into member values('udong','�쵿��',20);  --����! �⺻Ű �ߺ�
insert into member values('udong3',null,20);     --����! �⺻Ű not null

------------------------------------------------------------------------------------
2) Foreign key(�ܷ�Ű, ����Ű, fk)
- �ٸ����̺��� �⺻Ű�� �����ϴ� ��.
- ���ڵ带 �����Ҷ� �����Ǵ� Į���� �� �̿ܿ��� ���� �ȵ�.
- �����̺� �������� fk ���������ϴ�.
- �ߺ��� ����ϰ� null�� ���
- insert �Ҷ� : �θ����̺� insert -> �ڽ����̺� insert ���� 
- delete �Ҷ� : �ڽ����̺� delete -> �θ����̺� delete (�θ� ���� ����� ���Ἲ�� ����)
- ����, fk�� �����Ҷ� on delete cascade Ű���带 �Բ� ����ϸ�
  �θ� �����ɶ� �����ǰ� �ִ� �ڽķ��ڵ嵵 �Բ� �����ȴ�.
  
  
ex)�μ����� ���̺�
create table dept(
  dept_no number(3) constraint dept_no_pk PRIMARY KEY,
  dname varchar2(20) 
);

ex)������� ���̺�
create table emp(
  emp_no number(3) constraint emp_empno_pk PRIMARY KEY,
  ename varchar2(20),
  dept_no number(3) constraint emp_deptno_fk references dept(dept_no) 
);


insert into emp values(1,'Ȳ����',100);    --����!
insert into emp values(1,'Ȳ����',null);

insert into dept values(100,'���ߺ�');
insert into dept values(200,'��ȹ��');
insert into dept values(300,'������');

select * from dept;
select * from emp;

ex) emp���̺� ���ڵ� ����
insert into emp values(2,'�ּ���',200);
insert into emp values(3,'��û��',200);
insert into emp values(4,'������',100);
insert into emp values(5,'�˱�',400);     --����! �ܷ�Ű�� ������ dep_no�� 400�� �θ����̺� �����Ƿ�

--���ڵ� ����
1) �θ���� 
delete from dept where dept_no=300;       --�����Ǵ� �ڽ�Ű�� �����Ƿ� ������ �����ϴ�.
delete from dept where dept_no=200;       --�����Ǵ� �ڽ�Ű�� �����Ƿ� ������ �Ұ����ϴ�.
2) �ڽĻ���                               --on delete cascadeŰ���� ����ϸ� ���� ����
delete from emp where dept_no=200;    

--���̺� ���� 
drop table dept;
drop table emp;

-------------------------------------------------------
* fk �����Ҷ� on delete cascade ���� 

ex)�μ����� ���̺�
create table dept(
  dept_no number(3) constraint dept_no_pk PRIMARY KEY,
  dname varchar2(20) 
);

ex)������� ���̺�
create table emp(
  emp_no number(3) constraint emp_empno_pk PRIMARY KEY,
  ename varchar2(20),
  dept_no number(3) constraint emp_deptno_fk references dept(dept_no) on delete cascade
);

select * from dept;
select * from emp;


--�θ��� ���ڵ尡 �����Ǹ鼭 �����ϴ� �ڽ��� ���ڵ嵵 ���� �����ȴ�.
delete from dept where dept_no=200;


-----------------------------------------------------
*�ܷ�Ű�� ������ �����ϴ� ���

ex)������� ���̺�
create table emp(
  emp_no number(3),
  ename varchar2(20),
  dept_no number(3),
  
  constraint emp_pk PRIMARY KEY(emp_no),
  constraint emp_fk FOREIGN KEY(dept_no) references dept(dept_no) on delete cascade
);

--------------------------------------------------------------------------------------
3)unique
- null���, �ߺ��ȵ� , not null �� �����ϸ� pk����
- �����̺� �������� �÷��� unique ����

4)check
- ������ �����Ͽ� insert �Ҷ� ���� �̿��� ���� �������� ���ϵ��� �ϴ°�.

5)default
- �⺻���� �����ؼ� �ڵ����� ������ �⺻���� ���Եǵ��� �ϴ°�.


ex) ���̺����
create table test(
  id varchar2(10) UNIQUE,                     --�ߺ��ȵ�, null���
  jumin char(13) not null UNIQUE,             --�ߺ��ȵ�, null�Ұ� =>�⺻Ű�� ���� ȿ��
  age number(2) CHECK (age between 10 and 20),
  gender char(2 char) DEFAULT '����' not null --DEFAULT�� ������ �� not null�� �Բ� ����Ϸ��� ? DEFAULTŰ���带 ���� �ۼ��Ѵ�.
);

insert into test values('hwang', '1111',12,default);
insert into test(jumin,age) values('222',15);
insert into test(jumin,age) values('222',16); --����! �ֹι�ȣ �ߺ��ȵ�
insert into test(jumin,age) values('333',50); --����! ���� ����

select * from test;


-----------------------------------------------------------------------------------------
--���̺��� ���� ����
1) �÷� �߰�
  -alter table ���̺�� add �÷��� �ڷ��� ��������, �÷��� �ڷ��� ��������, ....;
  
2) �÷� ����
  -alter table ���̺�� drop column �÷���;
  
3) ������Ÿ�� ����
  -alter table ���̺�� modify �÷��� �����ڷ���;
  -�ַ� ����� �ø��� ���
  
4) �������� �߰�
  -alter table ���̺�� add constraint ��Ī ��������(�÷���);
  
5) �������� ����
  -alter table ���̺�� drop constraint ��Ī;
  
6) �÷� �̸� ����
  -alter table ���̺�� rename column �����÷��� to �����÷���;


ex)������� ���̺�� ����!!!
create table emp(
  emp_no number(3),
  ename varchar2(20),
  dept_no number(3),
  
  constraint emp_pk PRIMARY KEY(emp_no),
  constraint emp_fk FOREIGN KEY(dept_no) references dept(dept_no) on delete cascade
);

select * from emp;
desc emp;

alter table emp modify ename varchar2(21);
alter table emp rename column gender to genderr;

alter table emp drop constraint emp_pk;
alter table emp drop constraint emp_fk;
alter table emp drop constraint SYS_C007025;

alter table emp add constraint emp_pk PRIMARY KEY(emp_no);
alter table emp add etc2 varchar2(20) not null;                  --����
alter table emp add etc2 varchar2(20) default '��Ÿ2'not null;   --����

alter table emp add etc3 varchar2(10) constraint pk PRIMARY KEY default '���'; --����
--Į���� �߰��ϸ鼭 ���ÿ� �⺻Ű ���� �Ҽ�����!!


alter table emp drop column etc3;

select * from emp

------------------------------------------------------------------------------------
*���̺� ����
1)���̺����� ���ڵ� ��� ����

2)���ϴ� �÷��� ���ڵ常 ����

3)���̺� ������ ����