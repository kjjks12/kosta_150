--과목테이블
create table subject(
	수강코드 varchar2(5) constraint 수강_pk primary key,
	과목 varchar2(20) not null
)

--강의실 테이블
create table room(
	강의실번호 number primary key ,
	수용인원 number not null
)

--강사 테이블
create table teacher(
	강사번호 number constraint tpk primary key,
	강사이름 varchar2(12) not null,
	주민등록번호 varchar2(14) not null,
	연락처 varchar2(14) not null,
	주소 varchar2(50),
	이메일 varchar2(20),
	수강코드 varchar2(5) not null constraint tfk  references subject(수강코드)
)

--수강생 테이블
create table student(
	수강생번호 number primary key,
	수_이름 varchar2(12) not null,
	수_주민등록번호 varchar2(14)  not null,
	수_연락처 varchar2(14) not null,
	수_주소 varchar2(50),
	수_이메일 varchar2(20)
)

--수강 테이블
create table sugang(
	수강생번호 number constraint su_pk primary KEY 
                    constraint su_fk references student(수강생번호),
	수강코드  varchar2(5) references subject(수강코드)

)
--수강과목
create table sugangTB(
	수강코드 varchar2(5) 
  primary KEY  references subject(수강코드),
	강의실번호 number references Room(강의실번호),
	시간 number not null,
	강사번호 number constraint tbfk  references teacher(강사번호),
	foreign key(수강코드) references subject(수강코드)
)

insert into subject values('j1001','sql');
insert into subject values('j1002','Win2000');
insert into subject values('j1003','ASP');
insert into subject values('j1004','Php');
insert into subject values('j1005','java');
insert into subject values('j1006','javascript');


insert into room values(901,34);
insert into room values(902,35);
insert into room values(903,25);
insert into room values(904,32);
insert into room values(905,30);
insert into room values(906,35);

insert INTO teacher values(01,'홍길동','700918-1622011','031-295-1234','성남시 중원구 신흥동','kkk@jok.or.kr','j1001');
insert INTO teacher values(02,'유관순','710419-2018916','02-345-2345','서울 강남구 개포동','kkk@jok.or.kr','j1002');
insert INTO teacher values(03,'이승복','730112-1344911','031-1234-6789','서울시 강남구 논현동','sss@jok.or.kr','j1003');
insert INTO teacher values(04,'모택동','730301-1167623','031-567-5678','서울시 서초구 서초동','mmm@jok.or.kr','j1004');
insert INTO teacher values(05,'주롱지','730322-2037921','031-789-3456','서울시 강서구 가양동','xxx@jok.or.kr','j1005');
insert INTO teacher values(06,'이순신','731122-1646213','031-234-8901','서울시 강북구 미아동','ppp@jok.or.kr','j1006');


insert INTO student values(01,'김현진','771212-2346111','017-888-8888','부산','aaa@hanmail.net');
insert INTO student values(02,'김석주','720112-1234812','016-999-9999','경기','bbb@hanmail.net');
insert INTO student values(03,'고훈기','730102-1555555','017-555-5555','서울','ccc@hanmail.net');
insert INTO student values(04,'유민경','801111-2222222','017-222-2222','전남','ddd@hanmail.net');
insert INTO student values(05,'김영수','811231-1777777','017-777-7777','충주','eee@hanmail.net');
insert INTO student values(06,'박상원','790915-1333333','017-333-3333','강원','fff@hanmail.net');


insert into sugang values(01,'j1001');
insert into sugang values(02,'j1002');
insert into sugang values(03,'j1003');
insert into sugang values(04,'j1004');
insert into sugang values(05,'j1005');
insert into sugang values(06,'j1006');


insert into sugangtb values('j1001',901,2,01);
insert into sugangtb values('j1002',902,2,02);
insert into sugangtb values('j1003',903,2,03);
insert into sugangtb values('j1004',904,2,04);
insert into sugangtb values('j1005',905,2,05);
insert into sugangtb values('j1006',906,2,06);


--문제풀이

select 수_주민등록번호 , substr(수_주민등록번호,8,1) from student;

--성별이 여자인 학생의 정보
select * from student
where substr(수_주민등록번호,8,1) ='2';

select * from student
where  수_주민등록번호 like '%-2%';


--생년월일이 1973년인 학생의 정보
select * from student
where substr(수_주민등록번호,1,2)='73';

select * from student
where 수_주민등록번호 like '73%';

--성이 홍이 아닌강사의 정보
3)
select * from teacher
where  substr(강사이름,1,1)!='홍';

select * from teacher
where  substr(강사이름,1,1)!='홍';

select * from teacher
where  강사이름 not like '홍%';


4)
select * from teacher  where 주소 like '%강남구%';


5)
--Java를 강의하는 강사 정보검색(서브쿼리 이용)
 1) Java과목에 해당하는 수강코드를 검색한다.
 
 2) 검색된 수강코드를 조건으로 사용한다.
select * from teacher where 수강코드 = 
(select 수강코드 from subject where 과목='java')





--주소가 null이 아닌 강사의 정보
select * from teacher
where 주소 is not null;


7)
--system계정으로 접속한다.
grant create view to jang;

--sql수업을 수강하고 있는 학생의 정보
CREATE VIEW v_stu
as
select  st.수강생번호,수_이름, 수_주민등록번호, 수_연락처,수_주소, 수_이메일, sub.수강코드, 과목
from student  st inner join sugang  su
		on st.수강생번호=su.수강생번호 inner join subject sub
				on su.수강코드=sub.수강코드
where sub.과목='sql';


SELECT *FROM v_stu;

8)
/*강사가 담당하고 있는 과목과 그 과목이 어느강의실에서 진행되며
총 수용 잉원이 몇명인지를검색   */
CREATE VIEW v_tear
as
select te.강사번호,강사이름,te.수강코드,과목,ro.강의실번호, 수용인원
   from teacher te
		inner join subject su on te.수강코드=su.수강코드
		inner join sugangtb sug on su.수강코드=sug.수강코드
		inner join room ro on sug.강의실번호=ro.강의실번호;
    
    

SELECT * FROM v_tear where 강사이름 = '유관순';


9)
SELECT 수_이름, 수_주민등록번호,
CASE
 WHEN SUBSTR(수_주민등록번호,8,1) = 1 THEN '남자'
 WHEN SUBSTR(수_주민등록번호,8,1) = 2 THEN '여자'
END AS 성별
FROM student


10)
SELECT ROWNUM,강사이름, 연락처, 주소
FROM (SELECT * FROM teacher ORDER BY 강사이름); --인라인 뷰


COMMIT;



