/*
  select���忡�� ���ǿ� ���� ���๮���� �ٸ��� ��� �ϱ� ���� �Լ�!
  1) decode(�񱳴��,��,����,��,����....... , ����);
  
  2)case [�񱳴��]
       when  ���� then ����
       when  ���� then ����
       ...
       else ����
    end;
*/

ex) emp���̺��� deptno�� 10�̸� ������, 20�̸� ������, 30�̸�
    �渮�� ,�̿��� ���� ������ �� ����ϰ� �÷����� �μ��� �̶�� �Ѵ�.
    
    select empno, ename, job , deptno , 
    decode(deptno , 10,'������',20,'������',30 ,'�渮��','������') as �μ���
    from emp order by deptno;
    
    select empno, ename, job , deptno , 
    case deptno
      when 10 then '������'
      when 20 then '������'
      when 30 then '�椩����'
      else '������'
    end as �μ���
    from emp order by deptno;
    
    
    select empno, ename, job , deptno , 
    case 
      when deptno=10 then '������'
      when deptno=20 then '������'
      when deptno=30 then '�椩����'
      else '������'
    end as �μ���
    from emp order by deptno;
    
    select * from emp;
    
  ex)job�� manager�� ��� sal*0.1, ANALYST �ΰ���   sal *0.2
     SALESMAN�� ���� sal * 0.3�� ���ؼ� ������ �ʵ带 �����.
      (case end, decode �� �غ���)
      
      select ename, job, sal , 
      decode(lower(job) , 'manager',sal*0.1 , 'analyst', sal*0.2,
       'salesman' , sal*0.3) as ������
      from emp order by job ;
      
     select ename, job, sal , 
     case lower(job)
       when 'manager' then sal*0.1
       when 'analyst' then sal*0.2
       when 'salesman' then sal*0.3
     end as ������
      from emp order by job ;
      
      
      
      
      
  ex) sal�� 2000�����̸� '���ҵ���'
      sal�� 2001 ~ 4000���̸� '�߻���'
      sal�� 4001 �̻��̸� '��ҵ���'  ���Ͽ� ��� ��Ī ���ش�.
      (case end)
            
    select ename, sal , 
    case 
     when sal <=2000 then '���ҵ���'
     --when sal between 2001 and 4000 then '�߻���'
     when sal<=4000 then '�߻���'
     else '��ҵ���'
    end as ���
    from emp order by sal;
    
--------------------------------------------------------------  
 /*
    join
    => �ѹ��� select�������� ���� ���̺��� �÷��� �˻��Ҷ� �̿�.
    => join�� ����
      1) inner join(eq���� = ��������)
      2) Outer join
          -left
          -right
          -full(sql���ι�Ŀ��� �����ȵ�, ANSI���ι�Ŀ����� ����)
      3) self����
      
    => �ڵ����
    1)sql���ι��
      select �÷���,....
      from ���̺��̸� , ���̺��̸�,....
      where  ���ǽ� and ......
    
    2) ANSI���ι��(�ֽŹ��� =  ����ǥ�ر��)
       select �÷���,....
       from ���̺��̸� inner join ���̺��̸�
       on ���ǽ�
 */   
 
 ex)���̺� ����
 create table test1(
    id number(3) primary key,
    name varchar2(30),
    addr varchar2(30)
 );
 
insert into test1 values(1,'������','�Ǳ�');
insert into test1 values(2,'�ҳ�ô�','����');
insert into test1 values(3,'ī��','�뱸'); 
insert into test1 values(4,'����ģ��','����');
 insert into test1 values(5,'�ý�Ÿ','���ֵ�');
 
 select * from test1;
 
 create table test2(
   code char(3) primary key,
   id number(3) references test1(id),
   job varchar2(20),
   sal number(5)
 );
 
 insert into test2 values('A01',1 ,'����',1000);
 insert into test2 values('A02',3 ,'����',3000);
 insert into test2 values('A03',5 ,'����',5000);
 insert into test2 values('A04',null ,'���׸�',7000);
 
 
 select * from test1;
 select * from test2;
 
  --ex) id, name, job, sal������ �˻�
   1) SQL���ι��
    select test1.id, name ,job ,sal
    from test1 , test2
    where test1.id = test2.id;
    
    --���̺��̸���Ī�̿�.
    select t1.id, name ,job ,sal
    from test1 t1 , test2 t2
    where t1.id = t2.id;
    
    select *
    from test1 t1 , test2 t2
    where t1.id = t2.id;
    
    
   
   2) ANSI���ι��
    select test1.id, name ,job ,sal
    from test1 join test2
    on test1.id = test2.id;
    
    --���̺��̸� ��Ī�����
    select t1.id, name ,job ,sal
    from test1  t1 join test2 t2
    on t1.id = t2. 
    
    --using(�÷���) => Ansi���ο����� ����.(fk�� ������ �÷��� �̸��� �������)
    select id, name ,job ,sal -- using�� ����� ��� �÷����� �ߺ��Ǵ��� �÷��� ����Ѵ�.
    from test1  t1 join test2 t2
    using(id);
    
  --Outer����  - SQL ���ι��
   1) left����
   select t1.id, name, job ,sal
   from test1 t1 , test2 t2
   where  t1.id = t2.id(+);
   
   2) right����
    select t1.id, name, job ,sal
   from test1 t1 , test2 t2
   where  t1.id(+) = t2.id;
   
   --Outer����  - ANSI ���ι��
   1)left
     select t1.id, name, job ,sal
     from test1 t1 left join test2 t2
     on  t1.id = t2.id;
     
   2)right
     select t1.id, name, job ,sal
     from test1 t1 right join test2 t2
     on  t1.id = t2.id;
   
   3)full
    select t1.id, name, job ,sal
     from test1 t1 full join test2 t2
     on  t1.id = t2.id;
     
  * 2���̻��� ���̺��� ����...
   1) SQL����
    select �÷���,....
    from ���̺��̸� , ���̺��̸� ,���̺��̸�,.......
    where ���ǽ� and ���ǽ� and ���ǽ�.....
   
   
   2) ANSI����
   select �÷���,....
   from ���̺��̸� join ���̺��̸�
   on ���ǽ� join ���̺��̸� on ���ǽ� 
             join ���̺��̸� on ���ǽ�.....
  
  
  *self���ι��
   (�ϳ��� ���̺��� �ΰ��� ����� �ڱ��ڽ� ���̺�� �����ϴ� ��)
   
   ex) emp���̺��� �� ������� ���ӻ���� �������� �˰�ʹ�????
      ( ~����� ���ӻ���� ~ �Դϴ�.)
      
    select e1.empno , e1.ename , e1.mgr , e2.empno ,e2.ename
    from emp e1 join emp e2 --e1�� �������, e2�� ����������
    on e1.mgr = e2.empno;
    
    
     select e1.empno , e1.ename , e1.mgr , e2.empno ,e2.ename
    from emp e1 left join emp e2 --e1�� �������, e2�� ����������
    on e1.mgr = e2.empno;
    
    select * from emp;
      
 -------------------------------------------------------
 /*
    Set����
    1)union - �ߺ����� �����ϰ� �������� ���ڵ带 ��ģ��.
      union All - �ߺ����� �����ؼ� �������� ���ڵ带 ��ģ��.
      
    2) intersect - ������(�� ���̺��� ����� ���ڵ常 �˻�)
    3) minus - ������ 
 */
 
 ex) ���̺� ����
 create table copy_emp5
 as select empno, ename, job, sal from emp where deptno=20;
 
insert into copy_emp5 values(8000,'������','tearcher',1000);
insert into copy_emp5 values(8001,'ī��','tearcher',2000);
insert into copy_emp5 values(8002,'�̳���','tearcher',3000);

select * from copy_emp5;

1) union
select empno, ename, job, sal from emp
union --�ߺ�������
select empno, ename, job, sal from copy_emp5;


select empno, ename, job, sal from emp
union all --�ߺ�������
select empno, ename, job, sal from copy_emp5;
     
     
select empno, ename, job, sal from emp
intersect --������
select empno, ename, job, sal from copy_emp5; 


select empno, ename, job, sal from emp
minus --������
select empno, ename, job, sal from copy_emp5; 
-------------------------------------------------------
/*
   SubQuery - ������
   => ���������ȿ��� �� �ٸ� �������� ����!
   => �ݵ�� ���������� ()-��ȣ�� ���´�.
   => ���������� ���� ������� �� ����� ���������� �������� ���.
   => ���������� ��� �Ѱ� �� ��쿡�� �񱳿����� ��밡��.
   => ���������� ����� 2�� �̻��� ���� in, any, all�� ���.
   => �ַ� ���������� select������ ���� ���������
       insert, update ,delete������ ��밡��!
*/
  ex) sal�� ��� �޿����� ���� �޴� ����� ���� �˻�
   1) ��ձ޿��� ���Ѵ�.
     select avg(sal) from emp
     
   2) ���� ����� �������� ����Ѵ�.
   select * from emp where sal > 2077;
    
    *�� �� �ι������� subquery�� ����!
    select * from emp where sal > (select avg(sal) from emp);
    
 ex) �������� ��� ���ڵ���� ������ �� ���...
   job�� 'a'���ڿ��� �� ����� �μ��� ���� ������ �ٹ��ϴ�
   ����� �μ��̸� �˻�
   1)  job�� 'a'���ڿ��� �� ����� �μ���ȣ�� ���Ѵ�.
    select distinct deptno from emp where lower(job) like '%a%'
   
   2) 1)���� ���� ����� �������� ���
     select dname from dept 
     where  deptno in
     (select distinct deptno from emp where lower(job) like '%a%')
    
   any : �ּ��� �ϳ��� ��ġ�ϸ� ��
      �÷��� > any(��,��,....)   ==> �ּҰ����� ũ�� ��.
      �÷��� < any(��,��,....)   ==> �ִ밪���� ������ ��.
 
  all : ��� ��ġ(����)�ؾ߸� ��.
       �÷��� > all(��,��,....)   ==> �ִ밪���� ũ�� ��.
       �÷��� < all(��,��,....)   ==> �ּҰ����� ������ ��.
 
   *any�� all�� �ַ� ������������ ���� �̿��!!  
    
   ex) �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޿�����
       �� ���� �޴� ����� ������ ���Ѵ�.
      1) �μ���ȣ�� 30�� ������� �޿��� �˾ƿ´�.
        select sal from emp where deptno=30 
        
      select * from emp 
      where sal > all (select sal from emp where deptno=30 );
      
      select * from emp 
      where sal >  (select max(sal) from emp where deptno=30 );
     
    
    ex) �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޿�����
       �� ���� �޴� ����� ������ ���Ѵ�. 
       
       select * from emp 
      where sal > any(select sal from emp where deptno=30 );
      
      select * from emp 
      where sal > (select min(sal) from emp where deptno=30 );
   
   
  --���̺���
  create table sub_emp
  as select * from emp where 1=0;
  
  select * from sub_emp;
       
 * insert�Ҷ�
 insert into sub_emp (select * from emp where deptno=20)
 
 insert into sub_emp(empno, ename, job)
 (select empno, ename ,job from emp where deptno=10)
 
 
 * update�Ҷ�
 update sub_emp
 set sal=(select avg(sal) from sub_emp)
 where empno=7369;
 
  -�����Ҷ� �ѹ��� ������ �÷��� �����ϴ� ���
  update sub_emp
  set (sal ,ename ,job) = 
       (select sal, ename, job from emp  where empno=7499)
  where empno=7369;
  
  select * from sub_emp;
  
 
 * delete�Ҷ�
 delete from sub_emp
 where job=(select job from emp where empno=7499);
 
 
 *�ζ��� ��(from�� �ڿ� ���������� ���� ��)
 
  select rownum ��ȣ , ename, job, sal 
  from emp 
  order by sal desc; 
  
  --���� �����Ѵ�.
  select *
  from emp 
  order by sal desc; 
  
   
    select rownum ��ȣ,ename, job, sal 
  from ( select * from emp order by sal desc)
  
  ;
 
 
 
 
 
 
 
 
 
 
 
    
    