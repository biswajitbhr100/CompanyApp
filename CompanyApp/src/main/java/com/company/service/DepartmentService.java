package com.company.service;
import java.util.List;

import com.company.model.Department;
public interface DepartmentService {
	public void saveDepartment(Department dept);
	public Department getDepartment(long deptno);
	public void deleteDepartment(long deptno);
	public List<Department> getAllDepartments();
}
