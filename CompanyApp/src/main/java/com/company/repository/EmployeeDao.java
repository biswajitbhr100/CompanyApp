package com.company.repository;
import java.util.List;

import com.company.model.Employee;
public interface EmployeeDao {
	public void saveEmployee(Employee emp);
	public Employee getEmployee(long empno);
	public void deleteEmployee(long empno);
	public List<Employee> getAllEmployee();
}
