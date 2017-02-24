/* 테이블 생성  6개*/
CREATE TABLE SUBJECT(
SUBJECT_CODE VARCHAR2(5) CONSTRAINT SUBJECT_CODE_PK PRIMARY KEY,
SUBJECT VARCHAR2(20) NOT NULL
);

  select*from subject;
  
  insert into subject values('j1001','sql');
  insert into subject values('j1002','Win2000');
  insert into subject values('j1003','ASP');
  insert into subject values('j1004','Php');
  insert into subject values('j1005','java');
  insert into subject values('j1006','javascript');

CREATE TABLE ROOM(
ROOM_NO NUMBER CONSTRAINT ROOM_NO_PK PRIMARY KEY,
CAPACITY NUMBER NOT NULL
);

  insert into ROOM values(901,34);
  insert into ROOM values(902,35);
  insert into ROOM values(903,25);
  insert into ROOM values(904,32);
  insert into ROOM values(905,30);
  insert into ROOM values(906,35);
  
  select*from room;



CREATE TABLE TEACHER(
TEACHER_NO NUMBER CONSTRAINT TEACHER_NO_PK  PRIMARY KEY,
TEACHER_NAME VARCHAR2(12) NOT NULL,
Resident_Registration_Number  VARCHAR2(14) NOT NULL,
CONTACT  VARCHAR2(14) NOT NULL,
ADDRESS VARCHAR2(50),
EMAIL VARCHAR2(20),
Course_Code VARCHAR2(5),
CONSTRAINT COURSE_CODE_FK FOREIGN KEY (Course_Code) REFERENCES SUGANGTB(COURSE_CODE)
);

  insert into TEACHER values(1,'홍길동','700918-7622011','031-295-1234','성남시 중원구 신흥동','kkk@jok.or.kr','j1001');
  insert into TEACHER values(2,'유관순','710419-2018916','02-345-2345','서울시 강남구 개포동','kkk@jok.or.kr','j1002');
  insert into TEACHER values(3,'이승복','730112-1344911','031-1234-6789','서울시 강남구 논현동','sss@jok.or.kr','j1003');
  insert into TEACHER values(4,'모택동','730301-1167623','031-567-5678','서울시 서초구 서초동','mmm@jok.or.kr','j1004');
  insert into TEACHER values(5,'주롱지','730322-2037921','031-789-3456','서울시 강서구 가양동','xxx@jok.or.kr','j1005');
  insert into TEACHER values(6,'이순신','731122-1646213','031-234-8901','서울시 강북구 미아동','ppp@jok.or.kr','j1006');
  

CREATE TABLE STUDENT(
STUDENT_NO NUMBER CONSTRAINT STUDENT_NO_PK PRIMARY KEY,
NAME VARCHAR2(12) NOT NULL,
Resident_Registration_Number VARCHAR2(14) NOT NULL,
CONTACT VARCHAR2(14) NOT NULL,
ADDRESS VARCHAR2(50),
EMAIL VARCHAR2(20)
);

  insert into STUDENT values(1,'김현진','771212-2346111','017-888-8888','부산','aaa@hanmail.net');
  insert into STUDENT values(2,'김석주','720112-1234812','016-999-9999','경기','bbb@hanmail.net');
  insert into STUDENT values(3,'고훈기','730102-1555555','017-555-5555','서울','ccc@hanmail.net');
  insert into STUDENT values(4,'유민경','801111-2222222','017-222-2222','전남','ddd@hanmail.net');
  insert into STUDENT values(5,'김영수','811231-1777777','017-777-7777','충주','eee@hanmail.net');
  insert into STUDENT values(6,'박상원','790915-1333333','017-333-3333','강원','fff@hanmail.net');


CREATE TABLE SUGANG(
STUDENT_NO NUMBER CONSTRAINT SUGANG_PK PRIMARY KEY  REFERENCES STUDENT(STUDENT_NO),
COURSE_CODE VARCHAR2(5) CONSTRAINT SUGANG_FK REFERENCES SUBJECT(SUBJECT_CODE)
);

  insert into SUGANG values(1,'j1001');
  insert into SUGANG values(2,'j1002');
  insert into SUGANG values(3,'j1003');
  insert into SUGANG values(4,'j1004');
  insert into SUGANG values(5,'j1005');
  insert into SUGANG values(6,'j1006');


CREATE TABLE SUGANGTB(
COURSE_CODE VARCHAR2(5) PRIMARY KEY REFERENCES  SUBJECT(SUBJECT_CODE),
COURSE_NUMBER NUMBER CONSTRAINT COURSE_NUMBER_FK REFERENCES ROOM(ROOM_NO),
TIME NUMBER NOT NULL,
TEACHER_NO CONSTRAINT SUGANGTB_FK REFERENCES TEACHER(TEACHER_NO)
);
  
  insert into SUGANGTB values('j1001',901,2,1);
  insert into SUGANGTB values('j1002',902,2,2);
  insert into SUGANGTB values('j1003',903,2,3);
  insert into SUGANGTB values('j1004',904,2,4);
  insert into SUGANGTB values('j1005',905,2,5);
  insert into SUGANGTB values('j1006',906,2,6);


  select*from subject;
  select*from room;
  select*from teacher;
  select*from student;
  select*from sugang;
  select*from sugangtb;
