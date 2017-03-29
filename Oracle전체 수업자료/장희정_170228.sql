--�������̺�
create table subject(
	�����ڵ� varchar2(5) constraint ����_pk primary key,
	���� varchar2(20) not null
)

--���ǽ� ���̺�
create table room(
	���ǽǹ�ȣ number primary key ,
	�����ο� number not null
)

--���� ���̺�
create table teacher(
	�����ȣ number constraint tpk primary key,
	�����̸� varchar2(12) not null,
	�ֹε�Ϲ�ȣ varchar2(14) not null,
	����ó varchar2(14) not null,
	�ּ� varchar2(50),
	�̸��� varchar2(20),
	�����ڵ� varchar2(5) not null constraint tfk  references subject(�����ڵ�)
)

--������ ���̺�
create table student(
	��������ȣ number primary key,
	��_�̸� varchar2(12) not null,
	��_�ֹε�Ϲ�ȣ varchar2(14)  not null,
	��_����ó varchar2(14) not null,
	��_�ּ� varchar2(50),
	��_�̸��� varchar2(20)
)

--���� ���̺�
create table sugang(
	��������ȣ number constraint su_pk primary KEY 
                    constraint su_fk references student(��������ȣ),
	�����ڵ�  varchar2(5) references subject(�����ڵ�)

)
--��������
create table sugangTB(
	�����ڵ� varchar2(5) 
  primary KEY  references subject(�����ڵ�),
	���ǽǹ�ȣ number references Room(���ǽǹ�ȣ),
	�ð� number not null,
	�����ȣ number constraint tbfk  references teacher(�����ȣ),
	foreign key(�����ڵ�) references subject(�����ڵ�)
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

insert INTO teacher values(01,'ȫ�浿','700918-1622011','031-295-1234','������ �߿��� ���ﵿ','kkk@jok.or.kr','j1001');
insert INTO teacher values(02,'������','710419-2018916','02-345-2345','���� ������ ������','kkk@jok.or.kr','j1002');
insert INTO teacher values(03,'�̽º�','730112-1344911','031-1234-6789','����� ������ ������','sss@jok.or.kr','j1003');
insert INTO teacher values(04,'���õ�','730301-1167623','031-567-5678','����� ���ʱ� ���ʵ�','mmm@jok.or.kr','j1004');
insert INTO teacher values(05,'�ַ���','730322-2037921','031-789-3456','����� ������ ���絿','xxx@jok.or.kr','j1005');
insert INTO teacher values(06,'�̼���','731122-1646213','031-234-8901','����� ���ϱ� �̾Ƶ�','ppp@jok.or.kr','j1006');


insert INTO student values(01,'������','771212-2346111','017-888-8888','�λ�','aaa@hanmail.net');
insert INTO student values(02,'�輮��','720112-1234812','016-999-9999','���','bbb@hanmail.net');
insert INTO student values(03,'���Ʊ�','730102-1555555','017-555-5555','����','ccc@hanmail.net');
insert INTO student values(04,'���ΰ�','801111-2222222','017-222-2222','����','ddd@hanmail.net');
insert INTO student values(05,'�迵��','811231-1777777','017-777-7777','����','eee@hanmail.net');
insert INTO student values(06,'�ڻ��','790915-1333333','017-333-3333','����','fff@hanmail.net');


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


--����Ǯ��

select ��_�ֹε�Ϲ�ȣ , substr(��_�ֹε�Ϲ�ȣ,8,1) from student;

--������ ������ �л��� ����
select * from student
where substr(��_�ֹε�Ϲ�ȣ,8,1) ='2';

select * from student
where  ��_�ֹε�Ϲ�ȣ like '%-2%';


--��������� 1973���� �л��� ����
select * from student
where substr(��_�ֹε�Ϲ�ȣ,1,2)='73';

select * from student
where ��_�ֹε�Ϲ�ȣ like '73%';

--���� ȫ�� �ƴѰ����� ����
3)
select * from teacher
where  substr(�����̸�,1,1)!='ȫ';

select * from teacher
where  substr(�����̸�,1,1)!='ȫ';

select * from teacher
where  �����̸� not like 'ȫ%';


4)
select * from teacher  where �ּ� like '%������%';


5)
--Java�� �����ϴ� ���� �����˻�(�������� �̿�)
 1) Java���� �ش��ϴ� �����ڵ带 �˻��Ѵ�.
 
 2) �˻��� �����ڵ带 �������� ����Ѵ�.
select * from teacher where �����ڵ� = 
(select �����ڵ� from subject where ����='java')





--�ּҰ� null�� �ƴ� ������ ����
select * from teacher
where �ּ� is not null;


7)
--system�������� �����Ѵ�.
grant create view to jang;

--sql������ �����ϰ� �ִ� �л��� ����
CREATE VIEW v_stu
as
select  st.��������ȣ,��_�̸�, ��_�ֹε�Ϲ�ȣ, ��_����ó,��_�ּ�, ��_�̸���, sub.�����ڵ�, ����
from student  st inner join sugang  su
		on st.��������ȣ=su.��������ȣ inner join subject sub
				on su.�����ڵ�=sub.�����ڵ�
where sub.����='sql';


SELECT *FROM v_stu;

8)
/*���簡 ����ϰ� �ִ� ����� �� ������ ������ǽǿ��� ����Ǹ�
�� ���� �׿��� ����������˻�   */
CREATE VIEW v_tear
as
select te.�����ȣ,�����̸�,te.�����ڵ�,����,ro.���ǽǹ�ȣ, �����ο�
   from teacher te
		inner join subject su on te.�����ڵ�=su.�����ڵ�
		inner join sugangtb sug on su.�����ڵ�=sug.�����ڵ�
		inner join room ro on sug.���ǽǹ�ȣ=ro.���ǽǹ�ȣ;
    
    

SELECT * FROM v_tear where �����̸� = '������';


9)
SELECT ��_�̸�, ��_�ֹε�Ϲ�ȣ,
CASE
 WHEN SUBSTR(��_�ֹε�Ϲ�ȣ,8,1) = 1 THEN '����'
 WHEN SUBSTR(��_�ֹε�Ϲ�ȣ,8,1) = 2 THEN '����'
END AS ����
FROM student


10)
SELECT ROWNUM,�����̸�, ����ó, �ּ�
FROM (SELECT * FROM teacher ORDER BY �����̸�); --�ζ��� ��


COMMIT;



