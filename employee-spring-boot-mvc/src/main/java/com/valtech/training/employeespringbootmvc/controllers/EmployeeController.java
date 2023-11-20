package com.valtech.training.employeespringbootmvc.controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valtech.training.employeespringbootmvc.model.EmployeeModel;
import com.valtech.training.employeespringbootmvc.service.EmployeeService;






@Controller
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/new")
	public String newOrder(Model model) {
		model.addAttribute("employee", new EmployeeModel());
		return "employees/editemp";
	}
	@GetMapping("/list")
	public String listOrders(Model model) {
		model.addAttribute("employees",
				empService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employees/list";

	}
	@GetMapping("/editemp")
	public String editOrder(@RequestParam("id")int id,Model model) {
		
		model.addAttribute("employee",
				new EmployeeModel(empService.getEmployee(id)));
		return "employees/editemp";	
	}
	@PostMapping(path = "/add",params = "submit")
	public String saveEmployee(@ModelAttribute EmployeeModel empModel, Model model) {

		empService.createEmployee(empModel.getEmployee());

		model.addAttribute("employees",
				empService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));

		return "employees/list";
	}
	@PostMapping(path = "/add", params = "cancel")
	public String cancelEditEmployee(Model model) {	
		model.addAttribute("employees",
				empService.getAllEmployees().stream().map(e -> new EmployeeModel(e)).collect(Collectors.toList()));
		return "employees/list";
	}

	
	
	
	

}
