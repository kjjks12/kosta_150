select * from emp;

* 테이블 복사 - 제약조건은 복사안됨!!!
 1) 테이블구조와 레코드 모두 복사
 create table 테이블이름
 as 복사할테이블구조;
 
 create table copy_emp
 as select * from emp;
 
 select * from copy_emp;
 
 --제약조건 추가
 alter table copy_emp add constraint copy_emp_empno_pk primary key(empno);
 
 
 2) 원하는 컬럼과 레코드만 복사
 create table copy_emp2
 as select empno, ename, job, sal from emp where deptno=20;
 
 
 drop table copy_emp2;
 
 select * from copy_emp2;
 
 
 3) 테이블 구조만 복사
   create table copy_emp3
   as select * from emp where 1=0;
   
   select * from copy_emp3;
   
   --------------------------------------------------
  
   --레코드 삽입
   insert into 테이블이름(컬럼명, 컬러명,....) values(값,값,....);
   insert into 테이블이름 values(값,값,....);
   
   --레코드 수정
   update 테이블이름
   set 컬럼명=변경값, 컬럼명=변경값,....
   [where 조건식]
   
   --레코드 삭제
   delete from 테이블이름
   [where 조건식]
   
   truncate table 테이블이름 ;--모든레코드삭제(rollback안됨)
 
 -------------------------------------------------------------------
   1. scott계정으로 접속한다.
   2. emp테이블 전체를 복사한다.
   
   3. 복사한 테이블을 가지고 실습한다.
     select * from copy_emp;
     
  ex) empno가 7499의 ename을 '장희정', sal을 2000으로 변경
   update copy_emp 
   set ename='장희정' , sal=2000  
   where empno=7499;
  
  ex) sal 1000 ~ 2000사이인 레코드의 job을 '학생', hiredate를
      오늘 날짜로 변경한다.
      
      update copy_emp
      set job='학생' , hiredate=sysdate
      where sal >=1000 and sal <=2000;
      
      update copy_emp
      set job='학생' , hiredate=sysdate
      where sal between 1000 and 2000 ;
      
      
  ex) sal 3000이상인 레코드를 삭제한다.
    delete from copy_emp
    where sal >=3000;
    
 -----------------------------------------------------------
 *select문장
 /*
   select distinct | * | 컬럼명 as 별칭, 컬럼명 별칭 ,......
   from 테이블이름
   where 조건식
   order by 정렬대상컬럼 asc | desc , 정렬대상컬럼 asc|desc,...
 
 */
 ex) 원하는 컬럼과 별칭 주기
 select * from emp;
 
 select empno as "사원 번호" , ename 이름, job, sal  from emp;
 
 ex) ~님 급여는 ~ 입니다. 
  select ename || '님 급여는 ' || sal || '입니다.' as 급여정보
  from emp;
  
ex) 직무(job) 종류 검색
select job from emp order by job;
select distinct job from emp order by job; --중복행 제거
 
 
ex) job을 기준으로 내림차순정렬하고 같으면 sal을 기준으로 내림차순 정렬
 select * from emp
 order by job desc , sal desc;
 -------------------------------------------------------------
 ex) sal + comm 더해서 검색
 select empno, ename, sal, comm ,  (sal + comm)*12 as 년봉
 from emp;
 
 * null은 연산이 안된다(null을 다른값으로 변경)
    nvl(값,변경값)
      -> 값에서 null값을 찾아 null을 변경값을 대치한다.
 
  select empno, ename, sal, comm ,  
  (sal + nvl(comm,0))*12 || '만원' as 년봉
 from emp;
 
 --조건
  1) or
  2) and
  3) 컬럼명 in (값,....)
  4) 컬럼명 between 최소 and 최대
  5) not 을 이용 ( 1,2,3,4 모 가능)
  
ex) empno가 7499,7566, 7654 인 사원검색 (or  , in 모두 해본다)
 select * from emp
 where empno=7499 or empno=7566 or empno=7654;
 
 select * from emp
 where empno in (7499,7566,7654);
 
 
 select * from emp where not (empno=7499 or empno=7566 or empno=7654);
  select * from emp where empno not in (7499,7566,7654);


ex) sal 2000 ~ 3000 사이인 사원의 정보 검색 (and, between 모두 해본다.)
 select * from emp where sal >=2000 and sal <=3000;
 select * from emp where sal between 2000 and 3000;
 
 select * from emp where not (sal >=2000 and sal <=3000);
 select * from emp where sal not between 2000 and 3000;


ex) deptno가 10이거나 20인 사원중에서 sal가 1000 ~ 2000사이가
    아닌 사원 검색
    select * from emp
    where deptno in (10,20) and  (sal not between 1000 and 2000)
    order by sal;
    

ex) job이 salesman이면서 sal가 1500이상인 사원 검색
  select * from emp  where job ='salesman';
  
   *주의 : oracle은 데이터값을 대소문자를 구분한다.
           lower(값)  or  upper(값)
           
   select ename, lower(ename), upper(ename) from emp;
    
  select * from emp  where lower(job) = lower('salesman');
  
  
  select * from emp  
  where lower(job) = lower('salesman') and sal >=1500
----------------------------------------------------------------------
 --문자열검색
  1) _ : 한글자검색
  2) % : 0개 이상글자검색
  
    주의 :  _와 %는 like연산자와 함께 사용해야한다.
 
 ex) job에 a문자열을 포함한 모든 레코드 검색
  select * from emp
  where lower(job) like '%a%';
 
 ex) ename의 첫글자 C로 시작하고 끝끌자가 K로 끝나는 5글자 레코드 검색
 select * from emp where upper(ename) like 'C___K';
 
 ex) job의 끝 글자가 R로 끝나는 레코드 검색
 select * from emp where upper(job) like '%R';
------------------------------------------------------------------------
ex)comm 이 null인 레코드 검색???
 select * from emp where comm = null;
 select * from emp where comm = 'null';
 
 결론 : null찾는 방법
        is null
        is not null
        
 select * from emp where comm is null;
 select * from emp where comm is not null;
 ----------------------------------------------------------------
 any : 최소한 하나라도 일치하면 참
      컬럼명 > any(값,값,....)   ==> 최소값보다 크면 참.
      컬럼명 < any(값,값,....)   ==> 최대값보다 작으면 참.
 
 all : 모두 일치(만족)해야만 참.
       컬럼명 > all(값,값,....)   ==> 최대값보다 크면 참.
       컬럼명 < all(값,값,....)   ==> 최소값보다 작으면 참.
 
   *any와 all을 주로 서브쿼리에서 많이 이용됨!!
   
   select * from emp 
   where sal > any (1000,2000 ,3000) order by sal; --최소값 보다크면 참
   
   select * from emp 
   where sal < any (1000,2000 ,3000) order by sal; --최대값 보다 작으면 참.
   
   select * from emp 
   where sal > all (1000,2000 ,3000) order by sal; --최대값보다 크면 참.
   
   select * from emp 
   where sal < all (1000,2000 ,3000) order by sal; --최소값보다 작으면 참
   
   ex) deptno가 20인 사원들 중 급여의 최대값보다 많이 받는 사원 검색
   
   select * from emp
   where sal > all (select sal from emp where deptno =20)
   
   --------------------------------------------------------------
   --집계함수
   sum() : 합계
   max() :최대값
   min() : 최소값
   avg() : 평균(null을 제외한 평균)
   count(컬럼명) : null을 제외한 레코드수
   count(*) : null을 포함한 총 레코드수
   rank : 순위
   
   --성적표 테이블
   create table sungjuk(
      ban number(1),
      name varchar2(20),
      kor number(3),
      eng number(3),
      math number(3)
   );
   
   -- 레코드 삽입
  insert into sungjuk values(1, '김준',90,80,70); 
  insert into sungjuk values(1, '최광준',70,50,40);
  
  insert into sungjuk values(2, '박태규',50,70,20);
  insert into sungjuk values(2, '이상호',30,70,20);
  insert into sungjuk values(2, '김혜림',50,80,90);
  
  insert into sungjuk values(3, '정해찬',90,80,95);
  insert into sungjuk values(3, '김정훈',50,30,60);
  insert into sungjuk values(3, '윤진영',null,50,60);
  
  select * from sungjuk;  
  
  ex) 개인별 총점과 평균을 구한다.
   select ban, name, kor, eng, math , 
   (nvl(kor,0)+eng+math) as 총점 , 
   round((nvl(kor,0)+eng+math) /3 , 0)as 평균
   from sungjuk;
   
  
  ex) 국어점수의 총점, 평균, 최대, 최소값
  select sum(kor) , avg(kor)  , avg(nvl(kor,0)), max(kor) , min(kor)
  from sungjuk; 
    * 집계함수의 결과는 반드시 전체레코드를 가지고 총점, 평균, 최대,최소
      를 구하는 것이기때문에 결과 레코드는 한개이다.
  
  ex) 총레코드 수
  select count(kor), count(*) from sungjuk;
  
  ex) 각 반별 국어점수의 총점과 평균
  select ban , sum(kor) , avg(kor)
  from  sungjuk
  group by ban;
  
  
  
  select name , sum(kor) , avg(kor)
  from  sungjuk;--오류
   * 일반컬럼과 집계함수를 함께 select절에서 사용할수 없다.
      단, group by절에 나온 컬럼은 select절에서 사용가능하다.
      
      
  ex) emp테이블에서 각 부서별 급여의평균과레코드수(인원수) 검색!
   select deptno , avg(sal) , count(sal)
   from emp
   group by deptno
   
  ex) kor의 점수가 50 이상인 레코드들의 각 반별 합계, 평균 구한다.
  select ban , sum(kor), avg(kor)
  from sungjuk
  where kor >=50
  group by ban;  
  
  
  ex) 각 반별 kor의 평균이 50 이상인 레코드들의  합계, 평균 구한다.
   select ban , sum(kor), avg(kor)
  from sungjuk
  where avg(kor) >=50
  group by ban;  --오류발생(집계함수를 where절에서 조건으로 사용할수 없다)
   
  select ban , sum(kor), round(avg(kor))
  from sungjuk
  group by ban
  having avg(kor) >=50;
  
   * 결론 : 집계함수의 결과를 조건으로 사용할때는 having절을 사용한다.    
            이때, group by절 없이 having을 사용하는 것은 의미 없다!!!
  

  --순위 구하기
  ex) emp테이블에서 sal이 3000인 사원이 몇등급인지 검색!!!
  select rank(3000) within group(order by sal )from emp;
  select rank(3000) within group(order by sal desc)from emp;
 ---------------------------------------------------------------------  
   --숫자함수
   round(숫자, 자리수) : 자리수 = 0 이면 정수로 반올림
                                  1 이면 첫번째 자리까지 반올림
                                  
  ceil(숫자) : 정수로 올림
  floor(숫자 : 정수로 내림
  trunc(숫자, 자리수) : 자리수까지 버림.
  mod(숫자, 나눌수)  : 나머지
    
 ex)
   select sysdate , '장희정' , 25000  from dual;
   
   select 245.34561 , round(245.34561 , 0 ) , round(245.34561, 2),
   ceil(245.34561) ,floor(245.34561) , trunc(245.34561 , 2)
   from dual;
  -------------------------------------------------------------
  *문자열 함수
  upper(문자열)
  lower(문자열)
  initcap(문자열) : 단어의 첫글자를 대문자로 변환.
  
  instr(문자열, 찾을문자열) : 찾을 문자열이 있는 위치(index)를 알려준다.
  instr(문자열, 찾을문자열 ,시작위치) 
  instr(문자열, 찾을문자열, 시작위치, 몇번지위치) :
    => 시작위치에서 부터 몇번지 위치에 있는 문자의 위치를 검색한다.
    => 시작위치를 -1을 주면 오른쪽 부터 검색한다.
    => 찾는 문자열이 없을 경우 0을 리턴.
   
 substr(문자열, 시작번지) : 문자열에서 시작번지부터 끝까지 추출
 substr(문자열, 시작번지 , 개수) :문자열에서 시작번지부터 개수까지 추출
 
 lpad(문자열, 전체자리수, 문자)
 rpad(문자열, 전체자리수, 문자)
 ltrim(문자열) : 왼쪽 공백제거
 rtrim(문자열) : 오른쪽 공백제거
 
 length(문자열) : 문자열의 길이.

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
  
ex) emp테이블에서 job의 세번째 글자가 a인 레코드 검색(
  1) like이용
   select * from emp where lower(job) like '__a%';
  
  2) substr이용
   select * from emp where  substr(lower(job) ,3,1)='a'
  
  3) instr이용
  select * from emp where instr(lower(job),'a',3,1) =3;
   
  
   
 ex) emp테이블에서 hiredate가 1980인 레코드 검색 (substr이용)  
   select * from emp where substr(hiredate,1,2) ='80';
   
   select hiredate , to_char(hiredate ,'YYYY' ) ,
    to_char(hiredate ,'YYYY-MM-DD' ) , 
     to_char(hiredate ,'YYYY-MM-DD HH:MI:SS' )
   from emp;
   
   
   select * from emp
   where substr( to_char(hiredate, 'YYYY-MI-DD') , 1, 4) = '1980';
   
   
  ex)문자열 길이
  select ename ,length(ename) , job , length(job) from emp; 
 
 -----------------------------------------------------------------
  * 형변환함수
  to_char() : 문자열로 변환
  to_date() : 날짜로 변환
  to_number() : 숫자로변환
  
  ex) to_char(날짜 ,'YYYY-MM-DD HH:MI:SS');
      to_char(256000 , '999,999');
 
  select 2568700000 , to_char(256870 , '999,999') , 
  to_char(2568700000 , '999,999,999,999')
  from dual;
---------------------------------------------------------
 select sysdate , 
 to_char(sysdate ,'YYYY-MM-DD HH:MI:SS')
 from dual;
 -------------------------------------------------------
  *날짜함수
   sysdate  :현재날짜와 시간
   months_between(날짜,날짜) : 두 날짜 의 개월수의 차이 구함.
   add_months(날짜, 숫자) : 날짜에서 숫자만큼 개월수를 더한다.
   next_day(날짜, 요일) : 날짜에서 가장 가까운 요일의 날짜를 구함.
     - 요일 1이면 일요일, 2이면 월요일...... 7이면  토요일
   last_day(날짜) : 날짜에 해당하는 그달의 마지막 날짜를 구함.
   
   select months_between(sysdate , '2016-2-3')  from dual;
   select add_months(sysdate, 5) from dual;
   
   select last_day(sysdate) from dual;
  
 ex) hiredate를 기준으로 총 근무개월수를 구한다(현재날짜를 기준으로..)
     조건 : 소수점버림, 총근무 ~ 개월  출력 , 별칭은 총 근무 개월 수
  select hiredate , 
  '총 ' || floor(months_between(sysdate , hiredate)) || '개월' as "총 근무 개월 수"
  from emp;
  
 ex)오늘날짜를 기준으로 가장 빠른 화요일 구한다.
    select next_day(sysdate, 3) from dual;
 
 
 ex) 현재달의 마지막 일 구한다.
   select last_day(sysdate) from dual;
 
 ex) 우리가 만난지 100일 언제인지 구한다.
   select to_date('2017-01-23') +100 
   from dual;
 
  
  
  


 