select e.last_name, e.first_name, d.dept_no
from employees as e
left join dept_emp as d
on e.emp_no = d.emp_no
;

-- 查找所有员工入职时候的薪水情况
select e.emp_no, s.salary 
from employees as e
left join salaries as s
on e.emp_no = s.emp_no
where e.hire_date = s.from_date
order by e.emp_no desc

-- 查找薪水涨幅超过15次的员工号emp_no以及其对应的涨幅次数t
select e.emp_no, count(e.emp_no) as t
from employees as e
group by e.emp_no
having t > 15

-- 找出所有员工当前(to_date='9999-01-01')具体的薪水salary情况，对于相同的薪水只显示一次,并按照逆序显示
select distinct s.salary as salary from salaries as s
where s.to_date = '9999-01-01'
order by salary desc

select distinct s.salary as salary from salaries as s
where s.to_date like '9999-01-01'
order by salary desc

-- 获取所有部门当前manager的当前薪水情况，给出dept_no, emp_no以及salary
select d.dept_no, d.emp_no, s.salary as salary
from dept_manager as d left join salaries as s
on d.emp_no = s.emp_no
where s.to_date = '9999-01-01'

-- 获取所有非manager的员工emp_no
select distinct e.emp_no from employees as e
where e.emp_no not in (
    select emp_no from dept_manager
)

-- 获取所有员工当前的manager，如果当前的manager是自己的话结果不显示，当前表示to_date='9999-01-01'。
select distinct e.emp_no, d.emp_no as manager_no
from dept_emp as e
left join dept_manager as d on e.dept_no = d.dept_no 
where e.emp_no <> d.emp_no and d.to_date = '9999-01-01'






