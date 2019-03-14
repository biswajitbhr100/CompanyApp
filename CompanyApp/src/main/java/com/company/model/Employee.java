package com.company.model;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8686248114934125188L;
	@Id
	@Column(name = "EMPID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empid;
	@Column(name = "EMPNO",nullable = false,unique = true)
	private long empno;
	@Column(name = "EMPNAME",nullable = false)
	private String empname;
	@Column(name = "EMPJOB",nullable = false)
	private String empjob;
	@Column(name = "EMPSALARY",nullable = false)
	private long empsalary;
	@Column(name = "EMPDOJ",nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate empdoj;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "DEPTNO",referencedColumnName = "DEPTNO")
	private Department dept;
	public Employee() {
		
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpno(long empno) {
		this.empno = empno;
	}
	public long getEmpno() {
		return empno;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpjob(String empjob) {
		this.empjob = empjob;
	}
	public String getEmpjob() {
		return empjob;
	}
	public void setEmpsalary(long empsalary) {
		this.empsalary = empsalary;
	}
	public long getEmpsalary() {
		return empsalary;
	}
	public void setEmpdoj(LocalDate empdoj) {
		this.empdoj = empdoj;
	}
	public LocalDate getEmpdoj() {
		return empdoj;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public Department getDept() {
		return dept;
	}
	/*public java.util.Date convert(LocalDate date){
		return date.toDateTimeAtStartOfDay().toDate();
	}*/
}
