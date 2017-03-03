/*
 PL_SQL
   => ���������(����,����,�����,���,�Լ�, ���ν���....)
   => �⺻����
      declare ��������;
      begin
          ���๮��;
          ....
      end;
*/

 begin
   DBMS_OUTPUT.PUT('��~~ ���� ��������....');
   Dbms_Output.put_line('��� ���ڱ���~~');
   Dbms_Output.put_line('����~~�׸�!');
 end;
 
 
 /*
   ��������!
    declare �����̸� ������Ÿ��;
    
    *������Ÿ�� ����
     varchar2, char, number, date,...
     ���̺��̸�.�ʵ��%type
     ���̺��̸�%rowtype
     
     ex)
      declare �����̸� Ÿ��;
      declare �����̸� Ÿ�� := �ʱⰪ;
      declare �����̸� Ÿ�� default �ʱⰪ;
 */
 
  declare
   name varchar2(20):='������';
   age number(3) default 20;
   addr varchar2(30);
  begin
    dbms_output.put_line('�̸� : ' || name);
    dbms_output.put_line('���� : ' || age);
    dbms_output.put_line('�ּ� : ' || addr);
  end;
 
 ex)  emp���̺��� emp_id�� 6200�� ����� ename�� sal�� �����ؼ�
      ~�� �޿��� ~ �Դϴ� .���
    
    declare
     v_name emp.emp_name%type;
     v_sal  emp.sal%type;
    begin
      select emp_name,sal into v_name,v_sal from emp where emp_id=6200;
      dbms_output.put_line(v_name||'�� �޿��� '|| v_sal || ' �Դϴ�.');
    end;
  ------------------------------------------------------------------------

 ex) emp_id�� 6200�� ����� ��� ������ ���!
   
   declare data emp%rowtype;
   begin
    select * into data from emp where emp_id=6200;
    dbms_output.put_line(data.emp_id);
    dbms_output.put_line(data.emp_name);
    dbms_output.put_line(data.job);
    dbms_output.put_line(data.dept_id);
    dbms_output.put_line(data.sal);
    dbms_output.put_line(data.hiredate);
   end;
 
 
 /*
   ����ó��
   exception
    when �������� then ���ܹ߻����������๮��; 
    when �������� then ���ܹ߻����������๮��;
    when �������� then ���ܹ߻����������๮��;
    ...
    when others then ���ܹ߻����������๮��;
   
 */
 declare
  counter number(3):=100;
  begin
     counter := counter/0;
     dbms_output.put_line('�� : ' || counter);
     exception
     --when others then  dbms_output.put_line('0���� ������ �ȵſ�!!!');
     when ZERO_DIVIDE then  dbms_output.put_line('0���� ������ �ȵſ�!!!');
      when others then  dbms_output.put_line('�����߻�');
     dbms_output.put_line('�Ϸ�!!!!');
  end;
----------------------------------------------------------------
/*
  ���(���ǹ�, �ݺ���)
  1) if��
    if ���ǽ� then ����;
    elsif ���ǽ� then ����;
    elsif ���ǽ� then ����;
    ...
    else ����;
    end if;
  
  2) case��
    case ���
      when �� then ����;
      when �� then ����;
      ...
      else ����;
    end case;
  
*/

ex) Ȧ¦�����ϱ�
declare no number(3) := 60;
begin
 if mod(no,2) = 0 then dbms_output.Put_line(no|| '�� ¦��');
 else dbms_output.Put_line(no|| '�� Ȧ��');
 end if;
end;


declare no number(3) := 60;
begin
  case mod(no,2)
    when 0 then dbms_output.Put_line(no|| '�� ¦��');
    else dbms_output.Put_line(no|| '�� Ȧ��');
  end case;
end;
-----------------------------------------------------------
* ppt ���� �ۼ�

ex) emp���̺��� empno�� 7566 �� empno, ename, comm�� �˻��Ͽ� comm�� ����
    0���� ũ�� ename�� Ŀ�̼��� comm�Դϴ�. ���
    �ƴϸ� ename�� Ŀ�̼��� ���� �ʽ��ϴ�. ���

DECLARE
 vno NUMBER(4); --�����ȣ
 vname VARCHAR2(20); -- ����̸�
 vcomm emp.comm%TYPE; --comm
BEGIN
 SELECT empno, ename, comm INTO vno, vname, vcomm
 FROM EMP WHERE empno=7369;
 
 IF vcomm > 0 THEN dbms_output.put_line(vname || '�� Ŀ�̼���'|| vcomm ||'�Դϴ�.');
 ELSE
  dbms_output.put_line(vname ||'�� Ŀ�̼� ���� �ʽ��ϴ�.');
END IF;
END;


--case��
DECLARE
 vno NUMBER(4); --�����ȣ
 vname VARCHAR2(20); -- ����̸�
 vcomm emp.comm%TYPE; --comm
BEGIN
 SELECT empno, ename, nvl(comm,0) INTO vno, vname, vcomm  FROM EMP WHERE empno=7369;
 /*case vcomm> 0  
  when true then  dbms_output.put_line(vname ||'�� Ŀ�̼� ���� �ʽ��ϴ�.');
  ELSE  dbms_output.put_line(vname || '�� Ŀ�̼���'|| vcomm ||'�Դϴ�.');
 end case;*/
 case
  when vcomm > 0 then  dbms_output.put_line(vname ||'�� Ŀ�̼� ���� �ʽ��ϴ�.');
  ELSE  dbms_output.put_line(vname || '�� Ŀ�̼���'|| vcomm ||'�Դϴ�.');
 end case;
END;

select * from emp;

------------------------------------------------------------------------------------------
ex) ex) emp���̺��� empno�� 7566�� ���ڵ��� deptno��
10�̸� 'Accounting'
20�̸� 'Research'
30�̸� 'sales',
40�̸� 'operation' �� ����(dname)�� ��Ƽ�
if�� ���� ������ ������ּ���.

DECLARE
  data emp%rowtype; -- emp.dpetno%type
  vdname VARCHAR2(20) :=NULL; -- dept.dname%type
BEGIN
  SELECT * INTO data FROM EMP  WHERE empno=7369;
  IF(data.deptno =10) THEN vdname :='Accoun';
  elsIF(data.deptno =20) THEN vdname :='Research';
  elsIF(data.deptno =30) THEN vdname :='Sales';
  elsif(data.deptno =40) THEN vdname :='OPerations';
  END IF;
 dbms_output.put_line('���      �̸�     �μ���');
 dbms_output.put_line(data.empno ||'    '||data.ename ||'   '||vdname);
END;
--------------------------------------------------------------

case�� ����

DECLARE
vno NUMBER(4);
vname VARCHAR2(20);
vdno emp.DEPTNO%TYPE;
vdname VARCHAR2(20) :=NULL;
BEGIN
  SELECT empno, ename,deptno INTO vno, vname,vdno FROM EMP WHERE empno=7788;
  CASE vdno
   WHEN 10 THEN vdname :='Accoun';
   WHEN 20 THEN vdname :='Research';
   WHEN 30 THEN vdname :='Sales';
   WHEN 40 THEN vdname :='OPerations';
  END CASE;
 dbms_output.put_line('���      �̸�     �μ���');
 dbms_output.put_line(vno ||'    '||vname ||'   '||vdname);
END;




--------------------------------------------------------
6. if��(empno 7788�� ���ڵ���
    sal�� ���� 4000 �̻��̸� ��׳��
     sal 3000 ~4000 �̸��̸�  �Ϲݳ��
     Sal 2000 ~ 3000 �̸��̸� ���ҵ� ���
     sal 2000 �̸��̸� �ҿܰ��� )

DECLARE
vno NUMBER(4);
vname VARCHAR2(20);
vdno emp.DEPTNO%TYPE;
vdname VARCHAR2(20) :=NULL;
sal emp.SAL%TYPE;
BEGIN
  SELECT empno, ename,deptno ,sal INTO vno, vname,vdno ,sal
  FROM EMP  WHERE empno=7369;
  IF sal < 2000 THEN vdname :='�ҿ�';
  ELSIF sal < 3000 THEN vdname :='���ҵ�';
  ELSIF sal < 4000 THEN vdname :='�Ϲ�';
  ELSE vdname :='���';
  END IF;
 dbms_output.put_line('���      �̸�     �μ���');
 dbms_output.put_line(vno ||'    '||vname ||'   '||vdname || '  ' || sal);
END;



DECLARE
vno NUMBER(4);
vname VARCHAR2(20);
vdno emp.DEPTNO%TYPE;
vdname VARCHAR2(20) :=NULL;
sal emp.SAL%TYPE;
BEGIN
  SELECT empno, ename,deptno ,sal INTO vno, vname,vdno ,sal
  FROM EMP  WHERE empno=7369;
  case  
  when sal < 2000 THEN vdname :='�ҿ�';
  when sal < 3000 THEN vdname :='���ҵ�';
  when sal < 4000 THEN vdname :='�Ϲ�';
  ELSE vdname :='���';
  END case;

 dbms_output.put_line('���      �̸�     �μ���');
 dbms_output.put_line(vno ||'    '||vname ||'   '||vdname || '  ' || sal);
END;
-------------------------------------------------------------------
 --�ݺ���
1) for
   for �����̸� in ���� .. �� loop
     ����;
   end loop;


2) loop

   loop
     ����;
     ������;
     exit [when ���ǽ�] ; --�ݺ����� ����������.
   end loop;


3) while

   while ���ǽ� loop
     ����;
     ������;
   end loop;

ex) 1 ~ 10���� ���
 
 begin
    for i in 1 .. 10 loop
      dbms_output.put(i || ' , ');
    end loop;
    dbms_output.put_line('');
 end;
 
 
 declare i number(3):=1;
 begin
   loop
       dbms_output.put(i || ',');
       i:=i+1;-- 1������.
      exit when i=11;
   end loop;
   dbms_output.put_line('');
 end;
 
 declare i number(3) := 1;
 begin
   while i <=10 loop
     dbms_output.put(i || ',');
     i:=i+1;
   end loop;
   dbms_output.put_line('');
 end;
 
 ���� ) 2, ,4, 6, 8, 10 ���
begin
for i in 1 ..10 loop
  if mod(i,2)=0 then 
     dbms_output.put_line(i);
  end if;
end loop;
end;
--------------------------------------------
declare i number(3) :=2;
begin
 loop
   dbms_output.put_line(i);
   exit when i=10;
   i:=i+2;
 end loop;
end;
------------------------
declare i number(3) :=2;
begin
  while i <=10 loop
    dbms_output.put_line(i);
     i:=i+2;
  end loop;
end;
-----------------------------------------------------------------
����) 2�� ������ ���
 begin
   for i in 1 .. 9 loop
      dbms_output.put_line(2 || '*' || i || '=' || (2*i));
   end loop;
 end;



����) ������ (9�� 8�� ���)
declare 
 hang number(3) := 1;
 dan number(3):= 2;
 begin
  while hang <= 9 loop
    dan := 2;
    while dan <=9 loop -- 2 ~ 9 (8��)
     dbms_output.put(dan || '*' || hang || '=' ||(dan*hang) || '  '); 
     dan := dan+1;
    end loop;
    dbms_output.put_line(''); 
   hang := hang+1;
  end loop;--9��
 end;



����) 1~ 10���� ���� ���ϱ�

declare  
 total number(4) default 0; 
 i number(2) default 1;
begin
  loop
    total := total+i;
    i:= i+1;
    exit when i=11; 
  end loop;
  dbms_output.put_line('���� : ' || total);
end;
--------------------------------------------------------
/*
  Cursor
   =>select�� ��� ������ ������ ���ڵ带 ��ȯ������ ���!
   => Ŀ�� �����
    1)����
      cursor  Ŀ���̸� is select����; --�����̱⶧���� declare��ġ�� ���
    
    2)����
     open Ŀ���̸�; --begin����ȿ� �־�� ��.
     
    3)�����Ͱ�������(��ġ)
      fetch Ŀ���̸� into �����̸�;--�ݺ����ȿ�...
      
    4)�ݱ�
    close Ŀ���̸�;
*/

ex) emp���̺��� ename�� �˻�
select  ename from emp where empno=7499;

declare vname emp.ename%type;
begin
  select  ename into vname from emp ;--where empno=7499; �����߻�!!
  dbms_output.put_line('�̸� : ' || vname);
end;

--�� �������� Ŀ��Ȱ������ ����!
declare
cursor c_name is select ename from emp; --����
v_name emp.ename%type;
begin
 open c_name; --����
  loop
    fetch c_name into v_name;
     exit when c_name%notfound;
     dbms_output.put_line(v_name);
     --exit when c_name%notfound;
  end loop;
   dbms_output.put_line('���ڵ� �� : '|| c_name%rowcount);
 close c_name;--�ݱ�
end;
 
 ex) emp���̺��� ename, job, sal�� ������ ��� ���(cursor)
 
  select ename, job, sal from emp;
  
  declare
   cursor c_data is select ename, job, sal from emp;
   v_name emp.ename%type;
   v_job emp.job%type;
   v_sal emp.sal%type;
  begin
   open c_data;
    loop
      fetch c_data into v_name,v_job,v_sal;
      exit when c_data%notfound;
       dbms_output.put_line(v_name || v_job || v_sal);
    end loop;
   close c_data;
  end;
 
 
 
 ex) emp���̺��� ��� ���ڵ� ��� �÷��� ������ ���(cursor, rowtype)
 
 declare
   cursor c_data is select * from emp;
   v_row emp%rowtype;
  begin
   open c_data;
    loop
      fetch c_data into v_row;
      exit when c_data%notfound;
       dbms_output.put_line(v_row.empno || v_row.ename || v_row.sal);
    end loop;
   close c_data;
  end;
 
 ----------------------------------------------------------------
  PL_SQL �������α׷�
  1)�Լ� : �ݵ�� �������Ѵ�.
    => �̸� ����� ����� ���� ȣ���ؼ� ����ϴµ� �ݵ�� �Ѱ��� ����
       ���� �Ҽ� �ִ�.
    => �ۼ����
     create or replace function �Լ��̸�(�����̸� Ÿ��, �����̸� Ÿ��,....)
     return Ÿ�� is �����̸� ������Ÿ��;
     begin
       ����;
       
       return �����̸�;
     end;
  
   => �Լ�ȣ����
     select���̳� where������ �Լ��̸�(�μ���,....) ȣ���ؼ� ����Ѵ�.
   
  
  2)���ν���
    => ���������� �������� �����۾��� �Ҷ� �����.
       �������� �۾��� �ѹ��� �ϰ�ó��(transaction)�� �ϱ� ���ؼ� ���̻��.
       
   => �ۼ����
    create or replace procedure ���ν����̸�(�����̸� Ÿ��, �����̸� Ÿ��,...)
    is
    ���ν��������� ����Һ��� ����;
    begin
       ����;
    end;
 
  => ���ν��� ������
    exec ���ν����̸�(��,....);
------------------------------------------------------------

ex) emp���̺��� �����ȣ�� �ش��ϴ� �޿��� �������� �Լ������.
 create or replace function emp_sal(e_empno emp.empno%type)
 return number is e_sal emp.sal%type;
 begin
  select sal into e_sal from emp where empno=e_empno ;
  return e_sal;
 end;
 
 --�Լ� ����ϱ�
 select emp_sal(9001) from dual;
 
 select empno, ename, sal, emp_sal(empno) from emp;
 
 ex) Ư�� ����� �޿����� ���� �޴� ����� ������ ����Ѵ�.
   select * from emp
   where sal > emp_sal(7566);
 
 
 ex)
 ��������� ����� �Ҽӵ� �μ��� �̸��� �˻�(����, �������� �Ǵ� ����)
      => �Ҽӵ� �μ��̸��� �������� �Լ��� ������ �� �Լ� �̿��غ���.

 select empno, ename, job, emp.deptno, dname 
 from emp join dept
 on emp.deptno= dept.deptno;
 
 --�Լ��ۼ�(�μ���ȣ�� �ش��ϴ� �μ����� �����ϴ� �Լ�)
 create or replace function get_dname(v_deptno dept.deptno%type)
 return varchar2 is d_name dept.dname%type;
 begin
   select dname into d_name from dept where deptno=v_deptno;
   return d_name;
 end;
 
 --ȣ��
 select empno, ename, job, deptno, get_dname(deptno) as �μ���
 from emp;
 
 ----------------------------------------------------------------------
 *���ν��� ����
ex) �޽����� ����ϴ� ���ν��� �ۼ�
 create or replace procedure P_message
 is
 begin
   dbms_output.put_line('������ ����� û���ϴ³�~~');
 end;
 
 --����
 exec P_message;
 
 ex) �̸��� �μ��� �޾� �޽����� ����ϴ� ���ν��� �ۼ�
 
  create or replace procedure P_message(name in varchar2)
 is
 begin
   dbms_output.put_line(name || '�� ������ û���ϴ³�~~');
 end;
 
 --����
 exec P_message('������');
 exec P_message; --�����߻�
 exec P_message('������','�ȳ�');--�����߻�
 
 
 --���ν��� �ۼ��Ҷ� �μ��� �⺻��������!!!
 create or replace procedure P_message(name in varchar2 := 'GUEST')
 is
 begin
   dbms_output.put_line(name || '�� ������ û���ϴ³�~~');
 end;
 
  --����
 exec P_message('������');
 exec P_message; --�⺻�� ����!
 exec P_message('������','�ȳ�');--�����߻�
 --------------------------------------------------
 ex) �̸��� ���̸� �μ��� �޾� �޽��� ���
 
 create or replace procedure P_message(name in varchar2 := 'GUEST' , 
                                       age number default 10)
 is
 begin
   dbms_output.put_line(name||'�� ���̴� ' || age || '��');
 end;
 
 --����
 exec P_message;
 exec P_message('��ȿ��',20);
 
exec P_message('����ȣ');
exec P_message(age=>50);
exec P_message(age=>30 , name=>'����');

---------------------------------------------------
ex) ���ڵ带 �����ϴ� ���ν��� �ۼ�
    (���� ���ܰ� �߻��ϸ� '���Խ���', �����ϸ� '���Լ���!' �޽��� ���
     �����̸� commit, �����̸� rollback)
     
   --���̺� ����
   create table test(
      id varchar2(20) primary key,
      name varchar2(20),
      age number(3)
   );

  insert into test values('jang','������',10);
  select *From test;

 --���ν��� ����
 create or replace procedure p_insert(param_id test.id%type , 
                  param_name test.name%type, param_age test.age%type)
 is
  v_id test.id%type;
  v_name test.name%type;
  v_age test.age%type;
 begin
   insert into test values(param_id,param_name,param_age);
   commit;
   dbms_output.put_line(param_name || '�� ���� ����!!!');
   select id,name, age into v_id,v_name,v_age from test where id=param_id;
   dbms_output.put_line('�˻���� : '|| v_id || v_name || v_age);
   exception
    when others then dbms_output.put_line(param_name || '�� ���� ����');
    rollback;
 end;
 
 --����!
 exec p_insert('hee2','�̰���',20);
 ----------------------------------------------------------
 ex) job�� �μ��� �޿� job�� �ش��ϴ� ��� ������ �˻��ϴ� ���ν���
 create or replace procedure p_empInfo(param_job emp.job%type)
 is
 data emp%rowtype;
 begin
   select * into data from emp where lower(job) = lower(param_job) ;
   dbms_output.put_line(data.empno || data.ename || data.job || data.sal);
 end;
 
 --����
 exec p_empInfo('PRESIDENT');
  exec p_empInfo('MANAGER'); --���ڵ尡 ������ ��ȯ �Ǿ� �����߻�(Ŀ���ʿ�)
 
--�� ���ν��� Ŀ���� �����ؼ� ����
  create or replace procedure p_empInfo(param_job emp.job%type)
 is
 data emp%rowtype;
 cursor c_data is select * from emp where lower(job) = lower(param_job) ;
 begin
   open c_data;
   loop
     fetch c_data into data;
     exit when c_data%notfound;
     dbms_output.put_line(data.empno || data.ename || data.job || data.sal);
   end loop;
    dbms_output.put_line('�� ���ڵ�� : ' || c_data%rowcount );
   close c_data;
 end;
 
 
  --����
 exec p_empInfo('PRESIDENT');
  exec p_empInfo('MANAGER');
 
 ----------------------------------------
  
 
   create or replace procedure p_test
 is
  v_dname dept.dname%type;
 begin
   select   get_dname(deptno) as �μ��� into v_dname
 from emp where empno=7369;
 DBMS_OUTPUT.PUT_LINE(v_dname);
 end;
 
 exec p_test
 
 
 