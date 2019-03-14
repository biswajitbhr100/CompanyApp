package com.company.repository;
import com.company.model.Department;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void saveDepartment(Department dept) {
		sessionFactory.getCurrentSession().saveOrUpdate(dept);
	}
	public Department getDepartment(long deptid) {
		Department d = null;
		d = (Department)sessionFactory.getCurrentSession().get(Department.class, deptid);
		return d;
	}
	public void deleteDepartment(long deptid) {
		//sessionFactory.getCurrentSession().createCriteria("DELETE FROM DEPARTMENT WHERE DEPTNO="+deptno);
		//System.out.println("Record Deleted");
		Department s = (Department)sessionFactory.getCurrentSession().load(Department.class,deptid);
		
		if(null != s) {
			sessionFactory.getCurrentSession().delete(s);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Department> getAllDepartments(){
		return (List<Department>) sessionFactory.getCurrentSession().createCriteria(Department.class).list();
	}
}
