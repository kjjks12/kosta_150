select * from emp;

 -- 1
  select emp_name, (sal+100)*12 ��� from emp;
  -- 2
  select emp_name,job,dept_id from emp where job='������';
  
  -- 3
  select * from emp where to_char(hiredate,'yyyy-mm-dd')='2001-12-03';
  
  select * from emp where hiredate='2001-12-03';
  
  select  hiredate , to_char(hiredate,'yyyy-mm-dd HH:MI:SS') from emp ;
  
  select sysdate,to_char(sysdate,'yyyy-mm-dd HH:MI:SS')
  from dual where sysdate='2017-02-27';
  
  
  -- 4
  select emp_name,job,hiredate,dept_id from emp where dept_id=200;
  -- 5
  select emp_name,sal from emp where sal between 3000 and 5000;
  -- 6
  select emp_id,mgr_id,emp_name,dept_id from emp where mgr_id in(6311,6361,6351);
  -- 7
  select * from emp where job='�繫��' or job='�渮';
  select * from emp where job in('�繫��','�渮');
  -- 8
  select * from emp where job='����' and sal>=3000;
  -- 9
  select * from emp where job not in('������','�繫��');
  -- 10
  select * from emp where sal not between 1500 and 2500;
  -- 11
  select * from emp where job in('�渮','����') and sal >=3000 order by hiredate;
  -- 12
  select * from emp order by dept_id , sal desc;


  -- 13

  select * from emp 
  where bonus is not null and to_char(hiredate,'yyyy')>='2000';
  
   select * from emp 
  where bonus is not null and hiredate >='2000-01-01';
  
  -- 14
  select * from emp where emp_name like '��_��';
  -- 15
  update emp set bonus=nvl(bonus,0);
  -- 16
  update emp set emp_name='�嵿��',sal=3500 where job like '%��' and sal between 2000 and 3000;
  -- 17
  delete emp where emp_name like '%ö%' and job='����';
  -- 18
  drop table emp;