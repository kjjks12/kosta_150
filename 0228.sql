/*
  View
   => 가상테이블
   =>보안 or 복잡한 쿼리를 단순화 시키기 위해서 사용.
   => 뷰를 어떻게 만드느냐에 따라
      DML(insert, update, delete)가능여부가 달라진다.
      
   => 뷰생성방법
    create view 뷰이름
    as 뷰내용;
    
    create or replace view 뷰이름
    as 뷰내용;
    
    create or replace view 뷰이름
    as 뷰내용
    [with read only] --읽기전용
    [with check option]--조건에 만족하지 않는 레코드 대한 DML안됨.
    
  => 뷰 삭제
    drop view 뷰이름;
   
*/


--ex)뷰 생성
 create or replace view v_emp
 as select * from copy_emp;--오류발생(권한없음)
 
 *먼저 권한 부여(scott에게 view생성권한 부여 - system계정만 가능)

 --system계정으로 접속
  grant create view ,create sequence to scott;

--scott접속
create or replace view v_emp
 as select * from copy_emp;
 
 --뷰검색
 select *From v_emp;
 select *From copy_emp;
 
 --뷰 레코드 삭제
 delete from v_emp where deptno=30;
 --레코드 삽입
 insert into copy_emp(empno, ename, sal)values(8001,'삼순이',1000);
 insert into v_emp(empno, ename, sal)values(8002,'삼식이',2000);


1) 보안적인 측면(조건에 해당하는 레코드 와 특정 컬럼만 선택해서 만듦)
   create or replace view v_emp
   as select empno, ename, job, deptno from copy_emp where deptno=20;
   
   --뷰검색
   select * from v_emp;
   select * from copy_emp;
   
   --v_emp에 insert한다(deptno=20 , deptno=30 해본다)
   insert into v_emp values(8004,'김희선','MANAGER',20);
   insert into v_emp values(8005,'정준호','MANAGER',30);
  
    * deptno=30인 레코드를 뷰에 삽입을 해서 성공했지만
      뷰를 검색하면 검색되지 않는다.이유는 실제로 copy_emp테이블 레코드가
      삽입되었고 뷰를 검색할때는 뷰의 조건에 해당하는 deptno=20인 레코드만
      검색되기 때문에 보이지 않는다.(뷰에 레코드를 삽입한 관리자 입장에서 황당!)
      이러한 문제점을 해결하기 위해서는 뷰를 생성할때 
      with check option 을 설정하는것이 좋다.
    
     --뷰 수정!!!!
    create or replace view v_emp
   as select empno, ename, job, deptno from copy_emp where deptno=20
   with check option ;
    
  --v_emp에 insert한다(deptno=20 , deptno=30 해본다)
   insert into v_emp values(8006,'카라','가수',20);
   insert into v_emp values(8007,'소녀','가수',30);-- 오류발생

 2)복잡한 쿼리문을 단순화!!
   ex) 조인!!
     select empno, ename , job ,hiredate ,dname, loc
     from  emp e join dept d
     on e.deptno = d.deptno
 
   --뷰 작성
   create or replace view v_emp
   as select empno, ename , job ,hiredate ,dname, loc
      from  emp e join dept d
      on e.deptno = d.deptno
    with read only; --읽기전용(select전용)

 --뷰검색
 select * from v_emp where empno=7499;
---------------------------------------------------
/*
  sequence - 자동증가 값 설정
  => 생성방법
   create sequence 시퀀스이름
   [start with 시작값]
   [increment by 증가값]
   [maxvalue 최대값]
   [minvale 최소값]
   [cycle | nocycle]
   [cache | nocache]
  
 => 시퀀스 사용
   시퀀스이름.nextval ; 다음값 증가
   시퀀스이름.currval; 현재값
   
  =>시퀀스 수정
   alter sequence 시퀀스이름;
   
  => 시퀀스 삭제
   drop sequence 시퀀스이름;
*/


 * 시퀀스를 작성하기 전에 시퀀스 생성 권한 부여한다.
 
 --시퀀스 생성
create sequence seq_no
start with 10
maxvalue 100
minvalue 5
increment by 10
nocache;

select seq_no.nextval , seq_no.currval
from dual; --처음 10부터 10씩 증가하면서 최대 100이 되면 더이상 안된다.

drop sequence seq_no;

create sequence seq_no
start with 10
maxvalue 100
minvalue 5 --반드시 start with 보다는 작아야 한다.
increment by 10
cycle
nocache;

select seq_no.nextval ,seq_no.currval from dual;

drop sequence seq_no;

create sequence seq_no
start with 10
maxvalue 100
minvalue 5 --반드시 start with 보다는 작아야 한다.
increment by 10
cycle
nocache;

--테이블 생성
create table board(
  no number(3) primary key,
  subject varchar2(30),
  content varchar2(30),
  wirte_date date default sysdate,
  read_count number(3) default 0
)

select * from board;

--글번호 생성을 위한 시퀀스 생성.
create sequence board_no nocache;

--레코드 삽입
insert into board(no, subject, content)
values(board_no.nextval,'자바','잼닌다.'); 

select * from board;
------------------------------------------------
/*
  transaction
   => insert , update , delete문장을 수행 한 결과를
      commit(저장완료) , rollback(저장취소) 
   => 특정 영역을 나누어서 저장 또는 취소를 선택적으로 할수 있다.
      (savepoint 이름 ,  rollback to 이름)
*/

commit;

select * from copy_emp;

--레코드 삭제
delete from copy_emp where deptno=20;
--레코드 수정
update copy_emp set ename='장희정',sal=5000;

rollback;

savepoint a;
--레코드 삭제
delete from copy_emp where deptno=20;
delete from copy_emp where deptno=30;

select * from copy_emp;

savepoint b;
update copy_emp set ename='장희정' , sal=3000 where deptno is null;
insert into copy_emp(empno, ename, sal)values(9000,'정준호',2500);

savepoint c;
insert into copy_emp(empno, ename, sal)values(9001,'카라',3500);
insert into copy_emp(empno, ename, sal)values(9002,'apm',4500);

rollback to b;

rollback to a;


commit;
select *From copy_emp;

-----------------------------------------------------
 /*현재 scott 계정인 경우에 현재 계정에서 jang계정의 테이블 접근!!!!
   => 접근할수 있는 권한을 부여한다.
    grant all on 계정명.테이블이름 to 계정명;
    
   => 접근 권한 해제.
    revoke all on 계정명.테이블이름 from 계정명;
    
    *위 권한을 부여, 해제는 system계정 또는 접근 하려는테이블의
    소유자가 권한을 줄수 있다.
 */
 --현재 계정안에 있는 모든 테이블 정보보기
 select * from tab;
 
 select * from jang.member;
 
 
 


















