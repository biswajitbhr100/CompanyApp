package com.company.service;

import java.util.List;

import com.company.model.Employee;

public interface EmployeeService {
	public void addEmployee(Employee emp);
	public Employee retriveEmployee(long empno);
	public void removeEmployee(long empno);
	public List<Employee> retriveAllEmployee();
}
