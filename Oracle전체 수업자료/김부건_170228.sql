
------------------------------
1)
select * from student where substr(student_jumin, 8, 1) = '2';

2)
select * from student where substr(student_jumin, 1, 2) = '73';

3)
select * from teacher where teacher_name not like '홍%';

4)
select * from teacher where teacher_addr like '%강남구%';

5)
select * from teacher 
  where subject_code = 
  (select subject_code from subject where subject_name = 'java');
  
6)
select * from teacher where teacher_addr is not null;

7)
grant create view, create sequence to boogie;

create view v_stu
as (select * from student where student_no =
  (select student_no from sugang 
    join subject on sugang.subject_code = subject.subject_code
      where lower(subject_name) = 'sql'));

drop view v_stu;

select * from v_stu;

8)
select tt.teacher_no 강사번호, tt.teacher_name 강사이름, tt.subject_code 수강코드,
  sub.subject_name 과목, su.room_no 강의실번호, rm.room_capacity 수용인원
from teacher tt
join subject sub on tt.subject_code = sub.subject_code
join sugangtb su on tt.teacher_no = su.teacher_no
join room rm on su.room_no=rm.room_no;

9)
select student_name 수_이름, student_jumin 수_주민번호, 
decode(substr(student_jumin, 8, 1), '1', '남자', '2', '여자', '게이') 성별
from student;

10)
select rownum, teacher_name 강사이름, teacher_bunho 연락처, teacher_addr 주소
from(select *from teacher order by teacher_name);