
--------------------------------------------------------------------------

SELECT * FROM emp; --사원정보
SELECT * FROM dept;-- 부서정보
SELECT * FROM salgrade; --급여정보

-- 1. SMITH 에 대한  정보 검색(ename, emp.deptno, loc .)
select ename, emp.deptno, loc
from emp join dept
on  emp.deptno=dept.deptno where ename='SMITH';


--2. NEW YORK에 근무하는 사원의 이름과 급여를 출력
select ename, sal 
from emp join dept 
on emp.deptno=dept.deptno
and loc = 'NEW YORK';

--3. ACCOUNTING 부서 소속 사원의 이름과 입사일 출력
select ename, hiredate , dname
from emp JOIN dept
on  emp.deptno=dept.deptno where dname='ACCOUNTING';


-- 4. 직급이 MANAGER인 사원의 이름, 부서명 출력
select ename, dname, job 
from emp join dept
on  emp.deptno = dept.deptno
where job='MANAGER';


-- 5. 사원의 급여가 몇 등급인지를 검색
-- between A and B
select * from salgrade;
select * from emp;

select ename, sal, grade
from emp JOIN salgrade
on emp.sal between losal and hisal order by sal;


--6. 사원 테이블의 부서 번호로
--부서 테이블을 참조해서 부서명, 급여 등급도 검색
select e.ename, d.dname, s.grade
from emp e, dept d, salgrade s
where e.deptno=d.deptno and sal between losal and hisal;


--ANSI조인
select e.ename, d.dname, s.grade
from emp e join dept d
on e.deptno=d.deptno  JOIN salgrade s
ON sal between losal and hisal;



--7. SMITH의 메니저(mgr) 이름(ename) 검색
  => 1. SMITH의 mgr 검색한다.
  => 2. 검색된 mgr을 empno로 가지고 있는 사원의 ename을 검색한다.

select ename, mgr from emp where ename='SMITH';
select ename, empno from emp where empno=7902;


select e.ename || '의 메니저는 ' || m.ename
from emp e, emp m -- e는 사원, m은 관리자
where  e.mgr=m.empno AND e.ename='SMITH';

--self조인
select e1.ename || '의 메니저는 ' || e2.ename 
from emp  e1 join emp e2
ON  e1.mgr=e2.empno  and e1.ename='SMITH';


--8. 관리자가 KING인 사원들의 이름과 직급(job) 검색
select e.ename, e.job
from emp e, emp m
where e.mgr = m.empno and m.ename='KING';


select e.ename, e.job
from emp e join emp m
on e.mgr = m.empno and m.ename='KING';


--9. SMITH 와 동일한 부서번호(dpetno)에서 근무하는 사원의 이름 출력
-- 단, SMITH 데이터 절대 출력 불가
select e.ename 사원, ee.ename 같은근무사원
from emp e , emp ee --사원 , 동일사원
where e.deptno = ee.deptno
and e.ename='SMITH' and ee.ename != 'SMITH' ;

------------------------------------------------
-
  1.  각사원의 이름과 근무지(loc) 검색
  
  2. 각사원의 이름과 근무지(loc) 검색

-10. SMITH 와 동일한 근무지(loc) -dept 에서 근무하는 사원의 이름 -ename 출력
-- 단, SMITH 데이터 절대 출력 불가
select *
from  emp e1 join dept d1
on e1.deptno = d1.deptno
where SMITH의 deptno를 구해서 다른사원들의 deptno와 같은걸 구한다.


select e1.ename , d1.loc, e2.ename, d2.loc
from  (emp e1 join dept d1
on e1.deptno = d1.deptno) join 
(emp e2 join dept d2 on e2.deptno=d2.deptno) 
on  d1.loc = d2.loc where e1.ename='SMITH' and e2.ename!='SMITH'



------------------------------------------------
-- 11, 사원명, 해당 하는 메니저명 검색
-- 반드시 모든 사원들(CEO포함) 정보 검색
-- CEO인 경우 메니저 정보 null
  select e.ename 사원명, m.ename 메니져이름
 from emp e left join emp m
on e.mgr = m.empno;


select e.ename 사원명, m.ename 메니져이름
 from emp e , emp m
where e.mgr = m.empno(+);






