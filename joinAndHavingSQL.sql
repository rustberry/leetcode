-- The following SQL statement lists the employees that have registered more than 10 orders:
-- Rigth join version for practice by yourself.
-- The left join version:
select e.LastName, e.FirstName, count(OrderID) as orderCnt from Orders as o
left join Employees as e
on o.EmployeeID == e.EmployeeID
group by o.EmployeeID
having count(OrderID) > 10
order by orderCnt
desc
;

-- The following SQL statement lists if the employees "Davolio" or "Fuller" have registered more than 25 orders:

select e.LastName, count(OrderID) as orderCnt
from Orders as o
left join Employees as e
on o.EmployeeID == e.EmployeeID
-- where e.LastName in ('Davolio', 'Fuller') is also
where e.LastName like 'Davolio' OR e.LastName like 'Fuller'
group by o.EmployeeID
having orderCnt > 25


-- The following SQL statement lists the number of customers in each country. Only include countries with more than 5 customers:

select Country, count(CustomerID) as numbers
from Customers group by Country
having numbers > 5


-- List the suppliers with a product price less than 20:

select s.SupplierName, p.Price from Products as p
left join Suppliers as s
on p.SupplierID = s.SupplierID
where p.Price < 20
order by p.Price desc