package com.company.service;
import com.company.model.Department;
import com.company.repository.DepartmentDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("departmentService")
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
	private DepartmentDao departmentDao;
	@Transactional
	public void saveDepartment(Department dept) {
		departmentDao.saveDepartment(dept);
	}
	public Department getDepartment(long deptno) {
		return departmentDao.getDepartment(deptno);
	}
	@Transactional
	public void deleteDepartment(long deptno) {
		departmentDao.deleteDepartment(deptno);
		//System.out.println("deleted " + deptno );
	}
	@Transactional
	public List<Department> getAllDepartments() {
		return departmentDao.getAllDepartments();
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
}
