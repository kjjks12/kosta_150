
------------------------------
1)
select * from student where substr(student_jumin, 8, 1) = '2';

2)
select * from student where substr(student_jumin, 1, 2) = '73';

3)
select * from teacher where teacher_name not like 'ȫ%';

4)
select * from teacher where teacher_addr like '%������%';

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
select tt.teacher_no �����ȣ, tt.teacher_name �����̸�, tt.subject_code �����ڵ�,
  sub.subject_name ����, su.room_no ���ǽǹ�ȣ, rm.room_capacity �����ο�
from teacher tt
join subject sub on tt.subject_code = sub.subject_code
join sugangtb su on tt.teacher_no = su.teacher_no
join room rm on su.room_no=rm.room_no;

9)
select student_name ��_�̸�, student_jumin ��_�ֹι�ȣ, 
decode(substr(student_jumin, 8, 1), '1', '����', '2', '����', '����') ����
from student;

10)
select rownum, teacher_name �����̸�, teacher_bunho ����ó, teacher_addr �ּ�
from(select *from teacher order by teacher_name);