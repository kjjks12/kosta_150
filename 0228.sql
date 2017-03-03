/*
  View
   => �������̺�
   =>���� or ������ ������ �ܼ�ȭ ��Ű�� ���ؼ� ���.
   => �並 ��� ������Ŀ� ����
      DML(insert, update, delete)���ɿ��ΰ� �޶�����.
      
   => ��������
    create view ���̸�
    as �䳻��;
    
    create or replace view ���̸�
    as �䳻��;
    
    create or replace view ���̸�
    as �䳻��
    [with read only] --�б�����
    [with check option]--���ǿ� �������� �ʴ� ���ڵ� ���� DML�ȵ�.
    
  => �� ����
    drop view ���̸�;
   
*/


--ex)�� ����
 create or replace view v_emp
 as select * from copy_emp;--�����߻�(���Ѿ���)
 
 *���� ���� �ο�(scott���� view�������� �ο� - system������ ����)

 --system�������� ����
  grant create view ,create sequence to scott;

--scott����
create or replace view v_emp
 as select * from copy_emp;
 
 --��˻�
 select *From v_emp;
 select *From copy_emp;
 
 --�� ���ڵ� ����
 delete from v_emp where deptno=30;
 --���ڵ� ����
 insert into copy_emp(empno, ename, sal)values(8001,'�����',1000);
 insert into v_emp(empno, ename, sal)values(8002,'�����',2000);


1) �������� ����(���ǿ� �ش��ϴ� ���ڵ� �� Ư�� �÷��� �����ؼ� ����)
   create or replace view v_emp
   as select empno, ename, job, deptno from copy_emp where deptno=20;
   
   --��˻�
   select * from v_emp;
   select * from copy_emp;
   
   --v_emp�� insert�Ѵ�(deptno=20 , deptno=30 �غ���)
   insert into v_emp values(8004,'����','MANAGER',20);
   insert into v_emp values(8005,'����ȣ','MANAGER',30);
  
    * deptno=30�� ���ڵ带 �信 ������ �ؼ� ����������
      �並 �˻��ϸ� �˻����� �ʴ´�.������ ������ copy_emp���̺� ���ڵ尡
      ���ԵǾ��� �並 �˻��Ҷ��� ���� ���ǿ� �ش��ϴ� deptno=20�� ���ڵ常
      �˻��Ǳ� ������ ������ �ʴ´�.(�信 ���ڵ带 ������ ������ ���忡�� Ȳ��!)
      �̷��� �������� �ذ��ϱ� ���ؼ��� �並 �����Ҷ� 
      with check option �� �����ϴ°��� ����.
    
     --�� ����!!!!
    create or replace view v_emp
   as select empno, ename, job, deptno from copy_emp where deptno=20
   with check option ;
    
  --v_emp�� insert�Ѵ�(deptno=20 , deptno=30 �غ���)
   insert into v_emp values(8006,'ī��','����',20);
   insert into v_emp values(8007,'�ҳ�','����',30);-- �����߻�

 2)������ �������� �ܼ�ȭ!!
   ex) ����!!
     select empno, ename , job ,hiredate ,dname, loc
     from  emp e join dept d
     on e.deptno = d.deptno
 
   --�� �ۼ�
   create or replace view v_emp
   as select empno, ename , job ,hiredate ,dname, loc
      from  emp e join dept d
      on e.deptno = d.deptno
    with read only; --�б�����(select����)

 --��˻�
 select * from v_emp where empno=7499;
---------------------------------------------------
/*
  sequence - �ڵ����� �� ����
  => �������
   create sequence �������̸�
   [start with ���۰�]
   [increment by ������]
   [maxvalue �ִ밪]
   [minvale �ּҰ�]
   [cycle | nocycle]
   [cache | nocache]
  
 => ������ ���
   �������̸�.nextval ; ������ ����
   �������̸�.currval; ���簪
   
  =>������ ����
   alter sequence �������̸�;
   
  => ������ ����
   drop sequence �������̸�;
*/


 * �������� �ۼ��ϱ� ���� ������ ���� ���� �ο��Ѵ�.
 
 --������ ����
create sequence seq_no
start with 10
maxvalue 100
minvalue 5
increment by 10
nocache;

select seq_no.nextval , seq_no.currval
from dual; --ó�� 10���� 10�� �����ϸ鼭 �ִ� 100�� �Ǹ� ���̻� �ȵȴ�.

drop sequence seq_no;

create sequence seq_no
start with 10
maxvalue 100
minvalue 5 --�ݵ�� start with ���ٴ� �۾ƾ� �Ѵ�.
increment by 10
cycle
nocache;

select seq_no.nextval ,seq_no.currval from dual;

drop sequence seq_no;

create sequence seq_no
start with 10
maxvalue 100
minvalue 5 --�ݵ�� start with ���ٴ� �۾ƾ� �Ѵ�.
increment by 10
cycle
nocache;

--���̺� ����
create table board(
  no number(3) primary key,
  subject varchar2(30),
  content varchar2(30),
  wirte_date date default sysdate,
  read_count number(3) default 0
)

select * from board;

--�۹�ȣ ������ ���� ������ ����.
create sequence board_no nocache;

--���ڵ� ����
insert into board(no, subject, content)
values(board_no.nextval,'�ڹ�','��Ѵ�.'); 

select * from board;
------------------------------------------------
/*
  transaction
   => insert , update , delete������ ���� �� �����
      commit(����Ϸ�) , rollback(�������) 
   => Ư�� ������ ����� ���� �Ǵ� ��Ҹ� ���������� �Ҽ� �ִ�.
      (savepoint �̸� ,  rollback to �̸�)
*/

commit;

select * from copy_emp;

--���ڵ� ����
delete from copy_emp where deptno=20;
--���ڵ� ����
update copy_emp set ename='������',sal=5000;

rollback;

savepoint a;
--���ڵ� ����
delete from copy_emp where deptno=20;
delete from copy_emp where deptno=30;

select * from copy_emp;

savepoint b;
update copy_emp set ename='������' , sal=3000 where deptno is null;
insert into copy_emp(empno, ename, sal)values(9000,'����ȣ',2500);

savepoint c;
insert into copy_emp(empno, ename, sal)values(9001,'ī��',3500);
insert into copy_emp(empno, ename, sal)values(9002,'apm',4500);

rollback to b;

rollback to a;


commit;
select *From copy_emp;

-----------------------------------------------------
 /*���� scott ������ ��쿡 ���� �������� jang������ ���̺� ����!!!!
   => �����Ҽ� �ִ� ������ �ο��Ѵ�.
    grant all on ������.���̺��̸� to ������;
    
   => ���� ���� ����.
    revoke all on ������.���̺��̸� from ������;
    
    *�� ������ �ο�, ������ system���� �Ǵ� ���� �Ϸ������̺���
    �����ڰ� ������ �ټ� �ִ�.
 */
 --���� �����ȿ� �ִ� ��� ���̺� ��������
 select * from tab;
 
 select * from jang.member;
 
 
 


















