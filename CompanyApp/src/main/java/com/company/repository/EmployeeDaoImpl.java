package com.company.repository;
import com.company.model.Employee;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void saveEmployee(Employee emp) {
		sessionFactory.getCurrentSession().saveOrUpdate(emp);
	}
	public Employee getEmployee(long empid) {
		Employee e = null;
		e = (Employee)sessionFactory.getCurrentSession().get(Employee.class, empid);
		return e;
	}
	public void deleteEmployee(long empid) {
		//sessionFactory.getCurrentSession().createCriteria("DELETE FROM EMPLOYEE WHERE EMPID = " + empid);
		Employee e = (Employee)sessionFactory.getCurrentSession().load(Employee.class,empid);
		
		if(null != e) {
			sessionFactory.getCurrentSession().delete(e);
		}
	}
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee(){
		return (List<Employee>)sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}
}
