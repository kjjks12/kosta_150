/*
 PL_SQL
   => 절차적언어(선언,변수,실행부,제어문,함수, 프로시져....)
   => 기본구조
      declare 변수선언;
      begin
          실행문장;
          ....
      end;
*/

 begin
   DBMS_OUTPUT.PUT('아~~ 집에 가고프다....');
   Dbms_Output.put_line('살살 하자구요~~');
   Dbms_Output.put_line('이제~~그만!');
 end;
 
 
 /*
   변수선언!
    declare 변수이름 데이터타입;
    
    *데이터타입 종류
     varchar2, char, number, date,...
     테이블이름.필드명%type
     테이블이름%rowtype
     
     ex)
      declare 변수이름 타입;
      declare 변수이름 타입 := 초기값;
      declare 변수이름 타입 default 초기값;
 */
 
  declare
   name varchar2(20):='장희정';
   age number(3) default 20;
   addr varchar2(30);
  begin
    dbms_output.put_line('이름 : ' || name);
    dbms_output.put_line('나이 : ' || age);
    dbms_output.put_line('주소 : ' || addr);
  end;
 
 ex)  emp테이블에서 emp_id가 6200인 사원의 ename과 sal을 저장해서
      ~님 급여는 ~ 입니다 .출력
    
    declare
     v_name emp.emp_name%type;
     v_sal  emp.sal%type;
    begin
      select emp_name,sal into v_name,v_sal from emp where emp_id=6200;
      dbms_output.put_line(v_name||'님 급여는 '|| v_sal || ' 입니다.');
    end;
  ------------------------------------------------------------------------

 ex) emp_id가 6200인 사원의 모든 정보를 출력!
   
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
   예외처리
   exception
    when 예외종류 then 예외발생했을때실행문장; 
    when 예외종류 then 예외발생했을때실행문장;
    when 예외종류 then 예외발생했을때실행문장;
    ...
    when others then 예외발생했을때실행문장;
   
 */
 declare
  counter number(3):=100;
  begin
     counter := counter/0;
     dbms_output.put_line('값 : ' || counter);
     exception
     --when others then  dbms_output.put_line('0으로 나누면 안돼요!!!');
     when ZERO_DIVIDE then  dbms_output.put_line('0으로 나누면 안돼요!!!');
      when others then  dbms_output.put_line('오류발생');
     dbms_output.put_line('완료!!!!');
  end;
----------------------------------------------------------------
/*
  제어문(조건문, 반복문)
  1) if문
    if 조건식 then 문장;
    elsif 조건식 then 문장;
    elsif 조건식 then 문장;
    ...
    else 문장;
    end if;
  
  2) case문
    case 대상
      when 값 then 문장;
      when 값 then 문장;
      ...
      else 문장;
    end case;
  
*/

ex) 홀짝구분하기
declare no number(3) := 60;
begin
 if mod(no,2) = 0 then dbms_output.Put_line(no|| '는 짝수');
 else dbms_output.Put_line(no|| '는 홀수');
 end if;
end;


declare no number(3) := 60;
begin
  case mod(no,2)
    when 0 then dbms_output.Put_line(no|| '는 짝수');
    else dbms_output.Put_line(no|| '는 홀수');
  end case;
end;
-----------------------------------------------------------
* ppt 문제 작성

ex) emp테이블에서 empno가 7566 의 empno, ename, comm를 검색하여 comm의 값이
    0보다 크면 ename의 커미선은 comm입니다. 출력
    아니면 ename은 커미션을 받지 않습니다. 출력

DECLARE
 vno NUMBER(4); --사원번호
 vname VARCHAR2(20); -- 사원이름
 vcomm emp.comm%TYPE; --comm
BEGIN
 SELECT empno, ename, comm INTO vno, vname, vcomm
 FROM EMP WHERE empno=7369;
 
 IF vcomm > 0 THEN dbms_output.put_line(vname || '의 커미션은'|| vcomm ||'입니다.');
 ELSE
  dbms_output.put_line(vname ||'은 커미션 받지 않습니다.');
END IF;
END;


--case문
DECLARE
 vno NUMBER(4); --사원번호
 vname VARCHAR2(20); -- 사원이름
 vcomm emp.comm%TYPE; --comm
BEGIN
 SELECT empno, ename, nvl(comm,0) INTO vno, vname, vcomm  FROM EMP WHERE empno=7369;
 /*case vcomm> 0  
  when true then  dbms_output.put_line(vname ||'은 커미션 받지 않습니다.');
  ELSE  dbms_output.put_line(vname || '의 커미션은'|| vcomm ||'입니다.');
 end case;*/
 case
  when vcomm > 0 then  dbms_output.put_line(vname ||'은 커미션 받지 않습니다.');
  ELSE  dbms_output.put_line(vname || '의 커미션은'|| vcomm ||'입니다.');
 end case;
END;

select * from emp;

------------------------------------------------------------------------------------------
ex) ex) emp테이블에서 empno가 7566인 레코드의 deptno가
10이면 'Accounting'
20이면 'Research'
30이면 'sales',
40이면 'operation' 을 변수(dname)에 담아서
if문 끝난 다음에 출력해주세요.

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
 dbms_output.put_line('사번      이름     부서명');
 dbms_output.put_line(data.empno ||'    '||data.ename ||'   '||vdname);
END;
--------------------------------------------------------------

case로 변경

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
 dbms_output.put_line('사번      이름     부서명');
 dbms_output.put_line(vno ||'    '||vname ||'   '||vdname);
END;




--------------------------------------------------------
6. if문(empno 7788인 레코드의
    sal의 값이 4000 이상이면 고액년봉
     sal 3000 ~4000 미만이면  일반년봉
     Sal 2000 ~ 3000 미만이면 저소득 년봉
     sal 2000 미면이면 소외계층 )

DECLARE
vno NUMBER(4);
vname VARCHAR2(20);
vdno emp.DEPTNO%TYPE;
vdname VARCHAR2(20) :=NULL;
sal emp.SAL%TYPE;
BEGIN
  SELECT empno, ename,deptno ,sal INTO vno, vname,vdno ,sal
  FROM EMP  WHERE empno=7369;
  IF sal < 2000 THEN vdname :='소외';
  ELSIF sal < 3000 THEN vdname :='저소득';
  ELSIF sal < 4000 THEN vdname :='일반';
  ELSE vdname :='고액';
  END IF;
 dbms_output.put_line('사번      이름     부서명');
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
  when sal < 2000 THEN vdname :='소외';
  when sal < 3000 THEN vdname :='저소득';
  when sal < 4000 THEN vdname :='일반';
  ELSE vdname :='고액';
  END case;

 dbms_output.put_line('사번      이름     부서명');
 dbms_output.put_line(vno ||'    '||vname ||'   '||vdname || '  ' || sal);
END;
-------------------------------------------------------------------
 --반복문
1) for
   for 변수이름 in 시작 .. 끝 loop
     문장;
   end loop;


2) loop

   loop
     문장;
     증감식;
     exit [when 조건식] ; --반복문을 빠져나가라.
   end loop;


3) while

   while 조건식 loop
     문장;
     증감식;
   end loop;

ex) 1 ~ 10까지 출력
 
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
       i:=i+1;-- 1씩증가.
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
 
 문제 ) 2, ,4, 6, 8, 10 출력
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
문제) 2단 구구단 출력
 begin
   for i in 1 .. 9 loop
      dbms_output.put_line(2 || '*' || i || '=' || (2*i));
   end loop;
 end;



문제) 구구단 (9행 8열 출력)
declare 
 hang number(3) := 1;
 dan number(3):= 2;
 begin
  while hang <= 9 loop
    dan := 2;
    while dan <=9 loop -- 2 ~ 9 (8열)
     dbms_output.put(dan || '*' || hang || '=' ||(dan*hang) || '  '); 
     dan := dan+1;
    end loop;
    dbms_output.put_line(''); 
   hang := hang+1;
  end loop;--9행
 end;



문제) 1~ 10까지 총합 구하기

declare  
 total number(4) default 0; 
 i number(2) default 1;
begin
  loop
    total := total+i;
    i:= i+1;
    exit when i=11; 
  end loop;
  dbms_output.put_line('총합 : ' || total);
end;
--------------------------------------------------------
/*
  Cursor
   =>select의 결과 집합이 여러개 레코드를 반환했을때 사용!
   => 커서 사용방법
    1)선언
      cursor  커서이름 is select문장; --선언이기때문에 declare위치에 사용
    
    2)열기
     open 커서이름; --begin문장안에 있어야 함.
     
    3)데이터가져오기(패치)
      fetch 커서이름 into 변수이름;--반복문안에...
      
    4)닫기
    close 커서이름;
*/

ex) emp테이블의 ename을 검색
select  ename from emp where empno=7499;

declare vname emp.ename%type;
begin
  select  ename into vname from emp ;--where empno=7499; 오류발생!!
  dbms_output.put_line('이름 : ' || vname);
end;

--위 문장으로 커서활용으로 변경!
declare
cursor c_name is select ename from emp; --선언
v_name emp.ename%type;
begin
 open c_name; --열기
  loop
    fetch c_name into v_name;
     exit when c_name%notfound;
     dbms_output.put_line(v_name);
     --exit when c_name%notfound;
  end loop;
   dbms_output.put_line('레코드 수 : '|| c_name%rowcount);
 close c_name;--닫기
end;
 
 ex) emp테이블에서 ename, job, sal의 정보를 모두 출력(cursor)
 
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
 
 
 
 ex) emp테이블에서 모든 레코드 모든 컬럼의 정보를 출력(cursor, rowtype)
 
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
  PL_SQL 서브프로그램
  1)함수 : 반드시 리턴을한다.
    => 미리 기능을 만들어 놓고 호출해서 사용하는데 반드시 한개의 값만
       리턴 할수 있다.
    => 작성방법
     create or replace function 함수이름(변수이름 타입, 변수이름 타입,....)
     return 타입 is 변수이름 데이터타입;
     begin
       문장;
       
       return 변수이름;
     end;
  
   => 함수호출방법
     select절이나 where절에서 함수이름(인수값,....) 호출해서 사용한다.
   
  
  2)프로시져
    => 내부적으로 순차적인 여러작업을 할때 사용함.
       순차적인 작업을 한번에 일괄처리(transaction)를 하기 위해서 많이사용.
       
   => 작성방법
    create or replace procedure 프로시져이름(변수이름 타입, 변수이름 타입,...)
    is
    프로시져내에서 사용할변수 선언;
    begin
       문장;
    end;
 
  => 프로시져 실행방법
    exec 프로시져이름(값,....);
------------------------------------------------------------

ex) emp테이블에서 사원번호에 해당하는 급여를 가져오는 함수만든다.
 create or replace function emp_sal(e_empno emp.empno%type)
 return number is e_sal emp.sal%type;
 begin
  select sal into e_sal from emp where empno=e_empno ;
  return e_sal;
 end;
 
 --함수 사용하기
 select emp_sal(9001) from dual;
 
 select empno, ename, sal, emp_sal(empno) from emp;
 
 ex) 특정 사원이 급여보다 많이 받는 사원의 정보를 출력한다.
   select * from emp
   where sal > emp_sal(7566);
 
 
 ex)
 사원정보와 사원이 소속된 부서의 이름을 검색(기존, 서브쿼리 또는 조인)
      => 소속된 부서이름을 가져오는 함수를 생성한 후 함수 이용해본다.

 select empno, ename, job, emp.deptno, dname 
 from emp join dept
 on emp.deptno= dept.deptno;
 
 --함수작성(부서번호에 해당하는 부서명을 리턴하는 함수)
 create or replace function get_dname(v_deptno dept.deptno%type)
 return varchar2 is d_name dept.dname%type;
 begin
   select dname into d_name from dept where deptno=v_deptno;
   return d_name;
 end;
 
 --호출
 select empno, ename, job, deptno, get_dname(deptno) as 부서명
 from emp;
 
 ----------------------------------------------------------------------
 *프로시져 예제
ex) 메시지를 출력하는 프로시져 작성
 create or replace procedure P_message
 is
 begin
   dbms_output.put_line('오늘은 목요일 청소하는날~~');
 end;
 
 --실행
 exec P_message;
 
 ex) 이름을 인수로 받아 메시지를 출력하는 프로시져 작성
 
  create or replace procedure P_message(name in varchar2)
 is
 begin
   dbms_output.put_line(name || '님 오늘은 청소하는날~~');
 end;
 
 --실행
 exec P_message('장희정');
 exec P_message; --오류발생
 exec P_message('장희정','안녕');--오류발생
 
 
 --프로시져 작성할때 인수의 기본값을설정!!!
 create or replace procedure P_message(name in varchar2 := 'GUEST')
 is
 begin
   dbms_output.put_line(name || '님 오늘은 청소하는날~~');
 end;
 
  --실행
 exec P_message('장희정');
 exec P_message; --기본값 설정!
 exec P_message('장희정','안녕');--오류발생
 --------------------------------------------------
 ex) 이름과 나이를 인수로 받아 메시지 출력
 
 create or replace procedure P_message(name in varchar2 := 'GUEST' , 
                                       age number default 10)
 is
 begin
   dbms_output.put_line(name||'님 나이는 ' || age || '살');
 end;
 
 --실행
 exec P_message;
 exec P_message('이효리',20);
 
exec P_message('정준호');
exec P_message(age=>50);
exec P_message(age=>30 , name=>'원빈');

---------------------------------------------------
ex) 레코드를 삽입하는 프로시져 작성
    (만약 예외가 발생하면 '가입실패', 성공하면 '가입성공!' 메시지 출력
     성공이면 commit, 실패이면 rollback)
     
   --테이블 생성
   create table test(
      id varchar2(20) primary key,
      name varchar2(20),
      age number(3)
   );

  insert into test values('jang','장희정',10);
  select *From test;

 --프로시져 생성
 create or replace procedure p_insert(param_id test.id%type , 
                  param_name test.name%type, param_age test.age%type)
 is
  v_id test.id%type;
  v_name test.name%type;
  v_age test.age%type;
 begin
   insert into test values(param_id,param_name,param_age);
   commit;
   dbms_output.put_line(param_name || '님 가입 축하!!!');
   select id,name, age into v_id,v_name,v_age from test where id=param_id;
   dbms_output.put_line('검색결과 : '|| v_id || v_name || v_age);
   exception
    when others then dbms_output.put_line(param_name || '님 가입 실패');
    rollback;
 end;
 
 --실행!
 exec p_insert('hee2','이가현',20);
 ----------------------------------------------------------
 ex) job을 인수로 받에 job에 해당하는 모든 정보를 검색하는 프로시져
 create or replace procedure p_empInfo(param_job emp.job%type)
 is
 data emp%rowtype;
 begin
   select * into data from emp where lower(job) = lower(param_job) ;
   dbms_output.put_line(data.empno || data.ename || data.job || data.sal);
 end;
 
 --실행
 exec p_empInfo('PRESIDENT');
  exec p_empInfo('MANAGER'); --레코드가 여러개 반환 되어 오류발생(커서필요)
 
--위 프로시져 커서를 적용해서 변경
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
    dbms_output.put_line('총 레코드수 : ' || c_data%rowcount );
   close c_data;
 end;
 
 
  --실행
 exec p_empInfo('PRESIDENT');
  exec p_empInfo('MANAGER');
 
 ----------------------------------------
  
 
   create or replace procedure p_test
 is
  v_dname dept.dname%type;
 begin
   select   get_dname(deptno) as 부서명 into v_dname
 from emp where empno=7369;
 DBMS_OUTPUT.PUT_LINE(v_dname);
 end;
 
 exec p_test
 
 
 