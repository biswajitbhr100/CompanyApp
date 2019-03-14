package com.company.validator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.company.model.Department;
@Component
public class DepartmentValidator implements Validator{
	public boolean supports(Class<?> clazz) {
		return Department.class.equals(clazz);
	}
	public void validate(Object obj,Errors err) {
		ValidationUtils.rejectIfEmpty(err, "deptno", "dept.deptno.empty");
		ValidationUtils.rejectIfEmpty(err, "deptname", "dept.deptname.empty");
		//ValidationUtils.rejectIfEmptyOrWhitespace(err, "deptname", "dept.deptname.empty");
		System.out.println("Errors Found");
		//err.rejectValue("deptname", "required", "Specify Deptname");
		Department dept = (Department)obj;
	}
}
