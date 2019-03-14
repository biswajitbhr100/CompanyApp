package com.company.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import org.hibernate.annotations.NaturalId;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1882620179525996095L;
	@Id
	@Column(name = "DEPTID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long deptid;
	@Column(name = "DEPTNO",nullable = false,unique = true)
	@NaturalId(mutable = true)
	private long deptno;
	@Column(name = "DEPTNAME",nullable = false,unique = true)
	private String deptname;
	@OneToMany(mappedBy = "dept",fetch = FetchType.LAZY)
	private List<Employee> emps = new ArrayList<Employee>();
	public Department() {
		
	}
	public void setDeptid(long deptid) {
		this.deptid = deptid;
	}
	public long getDeptid() {
		return deptid;
	}
	public void setDeptno(long deptno) {
		this.deptno = deptno;
	}
	public long getDeptno() {
		return deptno;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	public List<Employee> getEmps(){
		return emps;
	}
}
