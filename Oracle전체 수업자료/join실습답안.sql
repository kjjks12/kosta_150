
--------------------------------------------------------------------------

SELECT * FROM emp; --�������
SELECT * FROM dept;-- �μ�����
SELECT * FROM salgrade; --�޿�����

-- 1. SMITH �� ����  ���� �˻�(ename, emp.deptno, loc .)
select ename, emp.deptno, loc
from emp join dept
on  emp.deptno=dept.deptno where ename='SMITH';


--2. NEW YORK�� �ٹ��ϴ� ����� �̸��� �޿��� ���
select ename, sal 
from emp join dept 
on emp.deptno=dept.deptno
and loc = 'NEW YORK';

--3. ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի��� ���
select ename, hiredate , dname
from emp JOIN dept
on  emp.deptno=dept.deptno where dname='ACCOUNTING';


-- 4. ������ MANAGER�� ����� �̸�, �μ��� ���
select ename, dname, job 
from emp join dept
on  emp.deptno = dept.deptno
where job='MANAGER';


-- 5. ����� �޿��� �� ��������� �˻�
-- between A and B
select * from salgrade;
select * from emp;

select ename, sal, grade
from emp JOIN salgrade
on emp.sal between losal and hisal order by sal;


--6. ��� ���̺��� �μ� ��ȣ��
--�μ� ���̺��� �����ؼ� �μ���, �޿� ��޵� �˻�
select e.ename, d.dname, s.grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno and sal between losal and hisal;


--ANSI����
select e.ename, d.dname, s.grade
from emp e join dept d
on e.deptno=d.deptno  JOIN salgrade s
ON sal between losal and hisal;



--7. SMITH�� �޴���(mgr) �̸�(ename) �˻�
  => 1. SMITH�� mgr �˻��Ѵ�.
  => 2. �˻��� mgr�� empno�� ������ �ִ� ����� ename�� �˻��Ѵ�.

select ename, mgr from emp where ename='SMITH';
select ename, empno from emp where empno=7902;


select e.ename || '�� �޴����� ' || m.ename
from emp e, emp m -- e�� ���, m�� ������
where  e.mgr=m.empno AND e.ename='SMITH';

--self����
select e1.ename || '�� �޴����� ' || e2.ename 
from emp  e1 join emp e2
ON  e1.mgr=e2.empno  and e1.ename='SMITH';


--8. �����ڰ� KING�� ������� �̸��� ����(job) �˻�
select e.ename, e.job
from emp e, emp m
where e.mgr = m.empno and m.ename='KING';


select e.ename, e.job
from emp e join emp m
on e.mgr = m.empno and m.ename='KING';


--9. SMITH �� ������ �μ���ȣ(dpetno)���� �ٹ��ϴ� ����� �̸� ���
-- ��, SMITH ������ ���� ��� �Ұ�
select e.ename ���, ee.ename �����ٹ����
from emp e , emp ee --��� , ���ϻ��
where e.deptno = ee.deptno
and e.ename='SMITH' and ee.ename != 'SMITH' ;

------------------------------------------------
-
  1.  ������� �̸��� �ٹ���(loc) �˻�
  
  2. ������� �̸��� �ٹ���(loc) �˻�

-10. SMITH �� ������ �ٹ���(loc) -dept ���� �ٹ��ϴ� ����� �̸� -ename ���
-- ��, SMITH ������ ���� ��� �Ұ�
select *
from  emp e1 join dept d1
on e1.deptno = d1.deptno
where SMITH�� deptno�� ���ؼ� �ٸ�������� deptno�� ������ ���Ѵ�.


select e1.ename , d1.loc, e2.ename, d2.loc
from  (emp e1 join dept d1
on e1.deptno = d1.deptno) join 
(emp e2 join dept d2 on e2.deptno=d2.deptno) 
on  d1.loc = d2.loc where e1.ename='SMITH' and e2.ename!='SMITH'



------------------------------------------------
-- 11, �����, �ش� �ϴ� �޴����� �˻�
-- �ݵ�� ��� �����(CEO����) ���� �˻�
-- CEO�� ��� �޴��� ���� null
  select e.ename �����, m.ename �޴����̸�
 from emp e left join emp m
on e.mgr = m.empno;


select e.ename �����, m.ename �޴����̸�
 from emp e , emp m
where e.mgr = m.empno(+);






