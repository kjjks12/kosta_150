/*
  자료형 - DATATYPE
  1) 문자형
     VARCHAR2(BYTE수) , CHAR(BYTE수) 
     NVARCHAR2 , NCHAR, TEXT ,LONG
  
  2) 숫자형
     NUMBER(자리수)
     NUMBER(자리수,자리수) - 실수형
     INT , SMALLINT ,INTEGER
     
  3) 날짜형
     DATE 

*/

--테이블생성
 CREATE TABLE 테이블이름(
   컬럼명 DATATYPE [NULL | NOT NULL] [제약조건],
   컬럼명 DATATYPE [NULL | NOT NULL] [제약조건],
   ...
 );


--EX) 자료형 TEST
 CREATE TABLE TYPE_TEST(
   name1 char(5), --고정길이
   name2 varchar2(5), -- 가변길이
   name3 varchar2(5 byte), -- 5byte(한글은 2글자만 가능)
   name4 varchar2(5 char), -- 5문자
   name5 char, --1byte설정
   name6 varchar2(3) -- 반드시 자리수지정 필수!!
 );
 
 --레코드 삽입
 insert into type_test(name1, name2,name3,name4,name5,name6)
 values('장','희','정','입','A','B');
 
 insert into type_test(name3) values('장희정'); --오류(최대 5byte이므로안됨)
insert into type_test(name4) values('장희정');
 
 --레코드 검색
 select  * from type_test;
 
 --테이블 구조
 desc type_test;
 
 --숫자형 test
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
insert into number_test(num2) values(100);--오류(2자리만가능)

insert into number_test(num3) values(230.54587);
insert into number_test(num1) values(25000);
select * from number_test;

--날짜형
create table date_test(
   birth date
);

insert into date_test(birth) values('2017-08-20');
insert into date_test(birth) values(sysdate);

select * from date_test;
----------------------------------------------------------
/*
  제약조건 종류
  1) primary key 
  2) Foreign key
  3) unique
  4) check
  5) default 
*/

   1) primary key 
   => 기본키, 대표키, 주키
   => 중복안됨, not null
   => 한테이블에 반드시 한개만 존재
      (여러개의 컬럼을 묶어서 하나의 pk가능)
   => 자동으로 unique index 설정(검색속도 빠르게 처리)

 ex)
  create table member(
     id varchar2(20) constraint member_id_pk primary key,
     name varchar2(10) not null,
     age number(3)
  );
  
  select * from member;
  
  --레코드 삽입
  insert into member(id,name,age) values('jang','장희정',18);

  insert into member(id,name,age) values(null,'장희정',18);--오류
  insert into member(id,name,age) values('jang','장희정',18);--오류
  
 insert into member(id,name,age) values('hee','장희정',18);--성공
 
 insert into member(id,name,age) values('kim','장희정',null);--성공
 
 insert into member(id,name,age) values('aa',null,20); --오류
 
 
 --테이블 삭제
 drop table member;
 
 
 *두개의 컬럼을 하나로 묶어서 PK설정
 create table member(
   id varchar2(20) ,
   name varchar2(10),
   age number(3),
   constraint member_id_name_pk primary key(id,name)
 )
 
 select * from member;
 
 insert into member(id, name, age) values('aa','장희정',10);
 
 insert into member(id, name, age) values('bb','장희정',10);
 
 insert into member(id, name, age) values('aa','이나영',10);
 
  insert into member(id, name, age) values('aa','이나영',30); --오류
 
 insert into member(id, name, age) values('cc', null,30); --오류발생
 
 -------------------------------------------------------------------
 2) Foreign key - 외래키,참조키,fk
  => 다른 테이블의 기본키를 참조 하는것.
  => 레코드를 삽입할때 참조되는 컬럼의 값 이외에는 삽입 안됨.
  => 한테이블에 여러개의 fk 설정. null허용 ,중복가능.
  => insert 할때 : 부모 insert -> 자식 insert 
     delete 할때 : 자식 delete -> 부모 delete
     만약, fk를 설정할때 on delete cascade 를 함께 사용하면
           부모삭제될때 참조되고 있는 자식레코드도 함께 삭제된다.
 
 
 ex) 부서정보 테이블
  create table dept(
    dept_no  number(3) constraint dept_no_pk primary key ,
    dname varchar2(20)
  );
 
 ex) 사원정보 테이블
 create table emp(
   empno number(3) constraint emp_empno_pk primary key,
   ename varchar2(20),
   dept_no number(3) constraint emp_deptno_fk references dept(dept_no)
 );
 
 insert into emp(empno, ename, dept_no)values(1, '장희정',100);--오류(부모키 없어서 안됨)
 insert into emp(empno, ename, dept_no)values(1, '장희정',null);
 
 ex)  dept테이블 레코드 삽입
 insert into dept(dept_no , dname)values(100,'교육부');
 insert into dept(dept_no , dname)values(200,'경리부');
 insert into dept(dept_no , dname)values(300,'행정부');
 
 select *from dept;
   
 select * from emp;
 
 ex) emp테이블 레코드 삽입
 insert into emp values(2,'이효리',200);
 insert into emp values(3,'정준호',200);
insert into emp values(4,'이가현',100);

--레코드 삭제
 1) 부모삭제
  delete from dept where dept_no=300; --참조되는 자식키 없으므로 삭제완료
  delete from dept where dept_no=200;--오류(참조되는 자식키를 먼저 삭제..)
 
  --자식키 삭제
  delete from emp where dept_no=200;
  
  --부모키 삭제
 
 select * from dept;
 select * from emp;
 
 --테이블 삭제
 drop table emp;
 drop table dept;
 -------------------------------------------------
  * fk 설정할때 on delete cascade 지정
 
ex) 부서정보 테이블
  create table dept(
    dept_no  number(3) constraint dept_no_pk primary key ,
    dname varchar2(20)
  );
 
 ex) 사원정보 테이블
 create table emp(
   empno number(3) constraint emp_empno_pk primary key,
   ename varchar2(20),
   dept_no number(3) constraint emp_deptno_fk 
    references dept(dept_no) on delete cascade
 );
 
 select * from dept;
 select * from emp;
 
 --자식이 참조되고 있는 부모키를 삭제해본다.
 delete from dept where dept_no=200;
 
 
 
 
 *fk(외래키)를 별도로 설정하는 방법
 drop table emp;
 
  create table emp(
   empno number(3) constraint emp_empno_pk primary key,
   ename varchar2(20),
   dept_no number(3) ,
   constraint emp_fk foreign key(dept_no) references dept(dept_no)
   on delete cascade
 );
 





