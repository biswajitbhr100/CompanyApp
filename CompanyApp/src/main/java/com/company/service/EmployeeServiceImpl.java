package com.company.service;
import com.company.model.Employee;
import com.company.repository.EmployeeDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	@Transactional
	public void addEmployee(Employee emp) {
		employeeDao.saveEmployee(emp);
	}
	public Employee retriveEmployee(long empid) {
		return employeeDao.getEmployee(empid);
	}
	@Transactional
	public void removeEmployee(long empid) {
		employeeDao.deleteEmployee(empid);
	}
	@Transactional
	public List<Employee> retriveAllEmployee() {
		return employeeDao.getAllEmployee();
	}
	public void setEmployeeDAO(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
