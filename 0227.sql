/*
  select문장에서 조건에 따라 실행문장을 다르게 출력 하기 위한 함수!
  1) decode(비교대상,값,문장,값,문장....... , 문장);
  
  2)case [비교대상]
       when  조건 then 문장
       when  조건 then 문장
       ...
       else 문장
    end;
*/

ex) emp테이블에서 deptno가 10이면 관리부, 20이면 교육부, 30이면
    경리부 ,이외의 값은 행정부 를 출력하고 컬럼명은 부서명 이라고 한다.
    
    select empno, ename, job , deptno , 
    decode(deptno , 10,'관리부',20,'교육부',30 ,'경리부','행정부') as 부서명
    from emp order by deptno;
    
    select empno, ename, job , deptno , 
    case deptno
      when 10 then '관리부'
      when 20 then '교육부'
      when 30 then '경ㄹ리부'
      else '행정부'
    end as 부서명
    from emp order by deptno;
    
    
    select empno, ename, job , deptno , 
    case 
      when deptno=10 then '관리부'
      when deptno=20 then '교육부'
      when deptno=30 then '경ㄹ리부'
      else '행정부'
    end as 부서명
    from emp order by deptno;
    
    select * from emp;
    
  ex)job이 manager인 경우 sal*0.1, ANALYST 인경우는   sal *0.2
     SALESMAN인 경우는 sal * 0.3을 구해서 성과급 필드를 만든다.
      (case end, decode 다 해본다)
      
      select ename, job, sal , 
      decode(lower(job) , 'manager',sal*0.1 , 'analyst', sal*0.2,
       'salesman' , sal*0.3) as 성과급
      from emp order by job ;
      
     select ename, job, sal , 
     case lower(job)
       when 'manager' then sal*0.1
       when 'analyst' then sal*0.2
       when 'salesman' then sal*0.3
     end as 성과급
      from emp order by job ;
      
      
      
      
      
  ex) sal이 2000이하이면 '저소득층'
      sal이 2001 ~ 4000사이면 '중산층'
      sal이 4001 이상이면 '고소득층'  구하여 등급 별칭 해준다.
      (case end)
            
    select ename, sal , 
    case 
     when sal <=2000 then '저소득층'
     --when sal between 2001 and 4000 then '중산층'
     when sal<=4000 then '중산층'
     else '고소득층'
    end as 등급
    from emp order by sal;
    
--------------------------------------------------------------  
 /*
    join
    => 한번의 select문장으로 여러 테이블의 컬럼을 검색할때 이용.
    => join의 종류
      1) inner join(eq조인 = 동등조인)
      2) Outer join
          -left
          -right
          -full(sql조인방식에서 지원안됨, ANSI조인방식에서만 지원)
      3) self조인
      
    => 코딩방식
    1)sql조인방식
      select 컬럼명,....
      from 테이블이름 , 테이블이름,....
      where  조건식 and ......
    
    2) ANSI조인방식(최신버젼 =  국제표준기법)
       select 컬럼명,....
       from 테이블이름 inner join 테이블이름
       on 조건식
 */   
 
 ex)테이블 생성
 create table test1(
    id number(3) primary key,
    name varchar2(30),
    addr varchar2(30)
 );
 
insert into test1 values(1,'장희정','판교');
insert into test1 values(2,'소녀시대','서울');
insert into test1 values(3,'카라','대구'); 
insert into test1 values(4,'여자친구','서울');
 insert into test1 values(5,'시스타','제주도');
 
 select * from test1;
 
 create table test2(
   code char(3) primary key,
   id number(3) references test1(id),
   job varchar2(20),
   sal number(5)
 );
 
 insert into test2 values('A01',1 ,'강사',1000);
 insert into test2 values('A02',3 ,'가수',3000);
 insert into test2 values('A03',5 ,'가수',5000);
 insert into test2 values('A04',null ,'개그맨',7000);
 
 
 select * from test1;
 select * from test2;
 
  --ex) id, name, job, sal정보를 검색
   1) SQL조인방법
    select test1.id, name ,job ,sal
    from test1 , test2
    where test1.id = test2.id;
    
    --테이블이름별칭이용.
    select t1.id, name ,job ,sal
    from test1 t1 , test2 t2
    where t1.id = t2.id;
    
    select *
    from test1 t1 , test2 t2
    where t1.id = t2.id;
    
    
   
   2) ANSI조인방법
    select test1.id, name ,job ,sal
    from test1 join test2
    on test1.id = test2.id;
    
    --테이블이름 별칭만들기
    select t1.id, name ,job ,sal
    from test1  t1 join test2 t2
    on t1.id = t2. 
    
    --using(컬럼명) => Ansi조인에서만 가능.(fk로 지정된 컬럼의 이름이 같은경우)
    select id, name ,job ,sal -- using을 사용한 경우 컬럼명이 중복되더라도 컬럼명만 명시한다.
    from test1  t1 join test2 t2
    using(id);
    
  --Outer조인  - SQL 조인방식
   1) left조인
   select t1.id, name, job ,sal
   from test1 t1 , test2 t2
   where  t1.id = t2.id(+);
   
   2) right조인
    select t1.id, name, job ,sal
   from test1 t1 , test2 t2
   where  t1.id(+) = t2.id;
   
   --Outer조인  - ANSI 조인방식
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
     
  * 2개이상의 테이블을 조인...
   1) SQL조인
    select 컬럼명,....
    from 테이블이름 , 테이블이름 ,테이블이름,.......
    where 조건식 and 조건식 and 조건식.....
   
   
   2) ANSI조인
   select 컬럼명,....
   from 테이블이름 join 테이블이름
   on 조건식 join 테이블이름 on 조건식 
             join 테이블이름 on 조건식.....
  
  
  *self조인방법
   (하나의 테이블을 두개로 만들어 자기자신 테이블과 조인하는 것)
   
   ex) emp테이블에서 각 사원들의 직속상관이 누구인지 알고싶다????
      ( ~사원의 직속상관은 ~ 입니다.)
      
    select e1.empno , e1.ename , e1.mgr , e2.empno ,e2.ename
    from emp e1 join emp e2 --e1은 사원정보, e2는 관리자정보
    on e1.mgr = e2.empno;
    
    
     select e1.empno , e1.ename , e1.mgr , e2.empno ,e2.ename
    from emp e1 left join emp e2 --e1은 사원정보, e2는 관리자정보
    on e1.mgr = e2.empno;
    
    select * from emp;
      
 -------------------------------------------------------
 /*
    Set집합
    1)union - 중복행을 제거하고 수직으로 레코드를 합친다.
      union All - 중복행을 포함해서 수직으로 레코드를 합친다.
      
    2) intersect - 교집합(두 테이블의 공통된 레코드만 검색)
    3) minus - 차집합 
 */
 
 ex) 테이블 복사
 create table copy_emp5
 as select empno, ename, job, sal from emp where deptno=20;
 
insert into copy_emp5 values(8000,'장희정','tearcher',1000);
insert into copy_emp5 values(8001,'카라','tearcher',2000);
insert into copy_emp5 values(8002,'이나영','tearcher',3000);

select * from copy_emp5;

1) union
select empno, ename, job, sal from emp
union --중복행제거
select empno, ename, job, sal from copy_emp5;


select empno, ename, job, sal from emp
union all --중복행제거
select empno, ename, job, sal from copy_emp5;
     
     
select empno, ename, job, sal from emp
intersect --교집합
select empno, ename, job, sal from copy_emp5; 


select empno, ename, job, sal from emp
minus --차집합
select empno, ename, job, sal from copy_emp5; 
-------------------------------------------------------
/*
   SubQuery - 부질의
   => 메인쿼리안에서 또 다른 쿼리문이 존재!
   => 반드시 서브쿼리는 ()-괄호로 묶는다.
   => 서브쿼리가 먼저 실행된후 그 결과를 메인쿼리의 조건으로 사용.
   => 서브쿼리의 결과 한개 인 경우에는 비교연산자 사용가능.
   => 서브쿼리의 결과가 2개 이상인 경우는 in, any, all을 사용.
   => 주로 서브쿼리는 select절에서 많이 사용하지만
       insert, update ,delete에서도 사용가능!
*/
  ex) sal의 평균 급여보다 많이 받는 사원의 정보 검색
   1) 평균급여를 구한다.
     select avg(sal) from emp
     
   2) 구한 결과를 조건으로 사용한다.
   select * from emp where sal > 2077;
    
    *위 의 두문장으로 subquery로 변경!
    select * from emp where sal > (select avg(sal) from emp);
    
 ex) 서브쿼리 결과 레코드수가 여러개 일 경우...
   job에 'a'문자열이 들어간 사원의 부서와 같은 곳에서 근무하는
   사원의 부서이름 검색
   1)  job에 'a'문자열이 들어간 사원의 부서번호를 구한다.
    select distinct deptno from emp where lower(job) like '%a%'
   
   2) 1)에서 나온 결과를 조건으로 사용
     select dname from dept 
     where  deptno in
     (select distinct deptno from emp where lower(job) like '%a%')
    
   any : 최소한 하나라도 일치하면 참
      컬럼명 > any(값,값,....)   ==> 최소값보다 크면 참.
      컬럼명 < any(값,값,....)   ==> 최대값보다 작으면 참.
 
  all : 모두 일치(만족)해야만 참.
       컬럼명 > all(값,값,....)   ==> 최대값보다 크면 참.
       컬럼명 < all(값,값,....)   ==> 최소값보다 작으면 참.
 
   *any와 all을 주로 서브쿼리에서 많이 이용됨!!  
    
   ex) 부서번호가 30인 사원들의 급여중에서 가장 많은 급여보다
       더 많이 받는 사원의 정보를 구한다.
      1) 부서번호가 30인 사원들의 급여을 알아온다.
        select sal from emp where deptno=30 
        
      select * from emp 
      where sal > all (select sal from emp where deptno=30 );
      
      select * from emp 
      where sal >  (select max(sal) from emp where deptno=30 );
     
    
    ex) 부서번호가 30인 사원들의 급여중에서 가장 적은 급여보다
       더 많이 받는 사원의 정보를 구한다. 
       
       select * from emp 
      where sal > any(select sal from emp where deptno=30 );
      
      select * from emp 
      where sal > (select min(sal) from emp where deptno=30 );
   
   
  --테이블복새
  create table sub_emp
  as select * from emp where 1=0;
  
  select * from sub_emp;
       
 * insert할때
 insert into sub_emp (select * from emp where deptno=20)
 
 insert into sub_emp(empno, ename, job)
 (select empno, ename ,job from emp where deptno=10)
 
 
 * update할때
 update sub_emp
 set sal=(select avg(sal) from sub_emp)
 where empno=7369;
 
  -수정할때 한번에 여러개 컬럼을 수정하는 경우
  update sub_emp
  set (sal ,ename ,job) = 
       (select sal, ename, job from emp  where empno=7499)
  where empno=7369;
  
  select * from sub_emp;
  
 
 * delete할때
 delete from sub_emp
 where job=(select job from emp where empno=7499);
 
 
 *인라인 뷰(from절 뒤에 서브쿼리가 오는 것)
 
  select rownum 번호 , ename, job, sal 
  from emp 
  order by sal desc; 
  
  --먼저 정렬한다.
  select *
  from emp 
  order by sal desc; 
  
   
    select rownum 번호,ename, job, sal 
  from ( select * from emp order by sal desc)
  
  ;
 
 
 
 
 
 
 
 
 
 
 
    
    