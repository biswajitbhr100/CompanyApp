package com.company.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.company.model.Employee;
import com.company.service.DepartmentService;
import com.company.service.EmployeeService;
@Controller
public class EmployeeController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@RequestMapping(value = "/saveEmp",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("command") Employee emp) {
		employeeService.addEmployee(emp);
		return new ModelAndView("redirect:/addEmp.html");
	}
	@RequestMapping(value = "/addEmp",method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute("command") Employee emp) {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("emps", employeeService.retriveAllEmployee());
		model.put("depts", departmentService.getAllDepartments());
		return new ModelAndView("addEmp",model);
	}
	@RequestMapping(value = "/deleteEmp",method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("command") Employee emp) {
		employeeService.removeEmployee(emp.getEmpid());
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("emps", employeeService.retriveAllEmployee());
		model.put("depts", departmentService.getAllDepartments());
		return new ModelAndView("redirect:/addEmp.html",model);
	}
	@RequestMapping(value = "/editEmp",method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("command") Employee emp) {
		Map<String,Object> model = new HashMap<String,Object>();
		Employee e = employeeService.retriveEmployee(emp.getEmpid());
		//System.out.println(e.convert(emp.getEmpdoj()));
		model.put("emp", e);
		model.put("emps", employeeService.retriveAllEmployee());
		model.put("depts", departmentService.getAllDepartments());
		return new ModelAndView("addEmp",model);
	}
	@RequestMapping(value = "/emps",method = RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		return employeeService.retriveAllEmployee();
	}
	
}
