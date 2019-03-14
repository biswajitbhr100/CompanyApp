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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.company.model.Department;
import com.company.service.DepartmentService;
import com.company.validator.DepartmentValidator;
@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentValidator departmentValidator;
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(departmentValidator);
	}
	@RequestMapping(value = "/saveDept",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("dept")@Validated Department dept,BindingResult result) {
		if(result.hasErrors()) {
			System.out.println("Inside Controller");
			return new ModelAndView("redirect:/");
		}
		departmentService.saveDepartment(dept);
		//System.out.println("saved");
		return new ModelAndView("redirect:/addDept.html");
	}
	@RequestMapping(value = "/addDept",method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute("dept") Department dept) {
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("depts", departmentService.getAllDepartments());
		return new ModelAndView("addDept",model);
	}
	@RequestMapping(value = "/deleteDept", method = RequestMethod.GET)
	public ModelAndView delete(@ModelAttribute("dept") Department dept) {
		//System.out.println(dept.getDeptno());
		departmentService.deleteDepartment(dept.getDeptid());
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("depts", departmentService.getAllDepartments());
		return new ModelAndView("redirect:/",model);
	}
	@RequestMapping(value = "/editDept",method = RequestMethod.GET)
	public ModelAndView edit(@ModelAttribute("dept") Department dept){
		Map<String,Object> model = new HashMap<String,Object>();
		//System.out.println(departmentService.getDepartment(2));
		model.put("dept", departmentService.getDepartment(dept.getDeptid()));
		model.put("depts", departmentService.getAllDepartments());
		return new ModelAndView("addDept",model);
	}
	/*@RequestMapping(value = "/index",method = RequestMethod.GET)
	public ModelAndView error(@ModelAttribute("dept")Department dept) {
		return new ModelAndView("index");
	}*/
	@RequestMapping(value = "/depts",method = RequestMethod.GET)
	public List<Department> getAllDepartments(){
		return departmentService.getAllDepartments();
	}
}
