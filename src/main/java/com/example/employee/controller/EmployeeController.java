package com.example.employee.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.employee.model.Employee;
import com.example.employee.service.IEmployeeService;

@Controller
@RequestMapping("/employee") 
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service; //HAS-A
	/**
	 * 1.show register page
	 * on enter/register URL(GET)
	 * @return
	 */
	@GetMapping("/register")
	public String showRegister() {
		return "EmployeeRegister";
	}
	
	/**
	 * 2.This method will read form data as ModelAttribute.
	 * perform save() operation using service that return id generated
	 * construct one message and send to UI using Model memory
	 * on entering URL:/save with TYPE:POST
	 * @param employee
	 * @param model
	 * @return
	 */
	@PostMapping("/save")
	public String saveEmployee( @ModelAttribute Employee employee,Model model){
		Integer id=service.saveEmployee(employee);
		String message=new StringBuffer().append("Employee '").append(id).append("' save").toString();
		//model.addAttribute("message", "employee save" +id);
		model.addAttribute("message", message);
		return "EmployeeRegister";
		
	}
	@GetMapping("/all")
	public String getAllEmployee(Model model){
		List<Employee> list=service.getAllEmployee();
		model.addAttribute("list",list);
		
		return "EmployeeData";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Integer id, Model model) {
		//call service
	     service.deleteEmployee(id);
		//send details to UI
		model.addAttribute("message", "Employee '"+id+"' Delected");
		model.addAttribute("list", service.getAllEmployee());
		return "EmployeeData";
		
	}
	@GetMapping("/edit")
	public String showEdit(@RequestParam Integer id,Model model) {
		Employee e=service.getOneEmployee(id);
		model.addAttribute("employee", e);
		return "EmployeeEdit";
		}
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee, Model model) {
		service.updateEmployee(employee);
		model.addAttribute("message", "Employee'"+employee.getId()+"' Updated");
		return "redirect:all";
	}
	
}
