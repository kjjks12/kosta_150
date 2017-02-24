/*
  자료형 - DATATYPE
  1) 문자형
      CHAR(BYTE수),VARCHAR2(BYTE수)
      NVARCHAR2, NCHAR, TEXT, LONG
      
  2) 숫자형
      NUMBER(자리수)
      NUMBER(자리수,소수점자리수)-실수형
      INT, SMALLINT
      
  3) 날짜형
      DATE
*/

--테이블 생성
CREATE TABLE 테이블 이름 (
  컬럼명 DATATYPE _[NULL | NOT NULL] [제약조건],
  
);

EX) 자료형 test
CREATE TABLE TYPE_TEST(
  name1 char(5),          --고정길이 
  name2 varchar(5),       --가변길이
  name3 varchar(5 byte),  --5byte(한글은 2글자만 가능)
  name4 varchar(5 char),  --5문자.5글자
  name5 char,             --default 1byte지정
  name6 varchar2(3)       --반드시 자리수 지정 필수
);

--레코드 삽입
insert into type_test(name1, name2, name3, name4, name5, name6)
values('황','유','정','입','A','b');

insert into type_test(name3) values('황유정');--오류!최대5byte이므로 안됨
insert into type_test(name4) values('황유정');--9byte이지만 세글자이므로 들어감

--레코드 검색
select * from type_test;

delete type_test from [where 조건식]  



--레코드 구조
desc TYPE_TEST;


--숫자형 test
create table number_test(
  num1 number,              --default가 ??
  num2 number(2),           --두자리!(-99~99)
  num3 number(5,2),         --총 다섯자리중 두자리는 소수점자리
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


--날짜형
create table date_test(
  birth date
);

drop table date_test;


insert into date_test(birth) values('1992-08-18');
insert into date_test(birth) values(sysdate);

select * from date_test;


---------------------------------------------------------------------------------------

/*
  제약조건 종류
  1) primary key ★
  2) Foreign key ★
  3) unique
  4) check
  5) default
*/

1) primary key (기본키, 대표키, 주키)
- 중복안됨, Not null
- 한테이블에 반드시 한개만 존재  (여러개의 컬럼을 묶어서 하나의 pk가능)
- 자동으로 unique index 설정  (검색속도 빠르게 처리)

ex)
create table member(
  id varchar2(20) constraint member_id_pk PRIMARY KEY,
  name varchar2(10) not null,
  age number(3)

);
  
select * from member;

--레코드삽입
insert into member(id,name,age) values('hyj','황유정',26);
insert into member(id,name,age) values(null,'황유정',26);  --오류! id는 기본키이므로 not null
insert into member(id,name,age) values('hyj','황유정',26); --오류!      기본키는 중복안됨
insert into member(id,name,age) values('hwang','황유정',26);
insert into member(id,name,age) values('zzZZ','우동이',null);
insert into member(id,name,age) values('abcd',null,26);
insert into member  values('apple','우동우',26);
  
--테이블 삭제
drop table member;


*2개의 컬럼을 하나로 묶어서 기본키로 설정
create table member(
  id varchar2(20),
  name varchar2(10),
  age number(3),
  
  constraint member_id_name_pk PRIMARY KEY(id,name)
);

select * from member;

insert into member values('udong','우동이',20);
insert into member values('udong2','우동이',20);
insert into member values('udong','우동이2',20); --2개의 pk중 하나는 달라도 저장가능.다른키로 인식
insert into member values('udong','우동이',20);  --오류! 기본키 중복
insert into member values('udong3',null,20);     --오류! 기본키 not null

------------------------------------------------------------------------------------
2) Foreign key(외래키, 참조키, fk)
- 다른테이블의 기본키를 참조하는 것.
- 레코드를 삽입할때 참조되는 칼럼의 값 이외에는 삽입 안됨.
- 한테이블에 여러개의 fk 설정가능하다.
- 중복을 허용하고 null도 허용
- insert 할때 : 부모테이블 insert -> 자식테이블 insert 순서 
- delete 할때 : 자식테이블 delete -> 부모테이블 delete (부모 먼저 지우면 무결성에 위배)
- 만약, fk를 설정할때 on delete cascade 키워드를 함께 사용하면
  부모가 삭제될때 참조되고 있는 자식레코드도 함께 삭제된다.
  
  
ex)부서정보 테이블
create table dept(
  dept_no number(3) constraint dept_no_pk PRIMARY KEY,
  dname varchar2(20) 
);

ex)사원정보 테이블
create table emp(
  emp_no number(3) constraint emp_empno_pk PRIMARY KEY,
  ename varchar2(20),
  dept_no number(3) constraint emp_deptno_fk references dept(dept_no) 
);


insert into emp values(1,'황유정',100);    --오류!
insert into emp values(1,'황유정',null);

insert into dept values(100,'개발부');
insert into dept values(200,'기획부');
insert into dept values(300,'영업부');

select * from dept;
select * from emp;

ex) emp테이블 레코드 삽입
insert into emp values(2,'최성훈',200);
insert into emp values(3,'멍청이',200);
insert into emp values(4,'말미잘',100);
insert into emp values(5,'똥깨',400);     --오류! 외래키로 지정된 dep_no의 400이 부모테이블에 없으므로

--레코드 삭제
1) 부모삭제 
delete from dept where dept_no=300;       --참조되는 자식키가 없으므로 삭제가 가능하다.
delete from dept where dept_no=200;       --참조되는 자식키가 있으므로 삭제가 불가능하다.
2) 자식삭제                               --on delete cascade키워드 사용하면 삭제 가능
delete from emp where dept_no=200;    

--테이블 삭제 
drop table dept;
drop table emp;

-------------------------------------------------------
* fk 설정할때 on delete cascade 지정 

ex)부서정보 테이블
create table dept(
  dept_no number(3) constraint dept_no_pk PRIMARY KEY,
  dname varchar2(20) 
);

ex)사원정보 테이블
create table emp(
  emp_no number(3) constraint emp_empno_pk PRIMARY KEY,
  ename varchar2(20),
  dept_no number(3) constraint emp_deptno_fk references dept(dept_no) on delete cascade
);

select * from dept;
select * from emp;


--부모의 레코드가 삭제되면서 참조하는 자식의 레코드도 같이 삭제된다.
delete from dept where dept_no=200;


-----------------------------------------------------
*외래키를 별도로 설정하는 방법

ex)사원정보 테이블
create table emp(
  emp_no number(3),
  ename varchar2(20),
  dept_no number(3),
  
  constraint emp_pk PRIMARY KEY(emp_no),
  constraint emp_fk FOREIGN KEY(dept_no) references dept(dept_no) on delete cascade
);

--------------------------------------------------------------------------------------
3)unique
- null허용, 중복안됨 , not null 을 지정하면 pk동일
- 한테이블에 여러개의 컬럼이 unique 가능

4)check
- 조건을 설정하여 insert 할때 조건 이외의 값을 삽입하지 못하도록 하는것.

5)default
- 기본값을 설정해서 자동으로 지정된 기본값이 삽입되도록 하는것.


ex) 테이블생성
create table test(
  id varchar2(10) UNIQUE,                     --중복안됨, null허용
  jumin char(13) not null UNIQUE,             --중복안됨, null불가 =>기본키와 같은 효과
  age number(2) CHECK (age between 10 and 20),
  gender char(2 char) DEFAULT '남자' not null --DEFAULT를 설정할 때 not null도 함께 사용하려면 ? DEFAULT키워드를 먼저 작성한다.
);

insert into test values('hwang', '1111',12,default);
insert into test(jumin,age) values('222',15);
insert into test(jumin,age) values('222',16); --오류! 주민번호 중복안됨
insert into test(jumin,age) values('333',50); --오류! 나이 범위

select * from test;


-----------------------------------------------------------------------------------------
--테이블의 구조 변경
1) 컬럼 추가
  -alter table 테이블명 add 컬럼명 자료형 제약조건, 컬럼명 자료형 제약조건, ....;
  
2) 컬럼 삭제
  -alter table 테이블명 drop column 컬럼명;
  
3) 데이터타입 수정
  -alter table 테이블명 modify 컬럼명 변경자료형;
  -주로 사이즈를 늘릴때 사용
  
4) 제약조건 추가
  -alter table 테이블명 add constraint 별칭 제약조건(컬럼명);
  
5) 제약조건 삭제
  -alter table 테이블명 drop constraint 별칭;
  
6) 컬럼 이름 변경
  -alter table 테이블명 rename column 기존컬럼명 to 변경컬럼명;


ex)사원정보 테이블로 연습!!!
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
alter table emp add etc2 varchar2(20) not null;                  --오류
alter table emp add etc2 varchar2(20) default '기타2'not null;   --오류

alter table emp add etc3 varchar2(10) constraint pk PRIMARY KEY default '우왁'; --오류
--칼럼을 추가하면서 동시에 기본키 설정 할수없다!!


alter table emp drop column etc3;

select * from emp

------------------------------------------------------------------------------------
*테이블 복사
1)테이블구조와 레코드 모두 복사

2)원하는 컬럼과 레코드만 복사

3)테이블 구조만 복사