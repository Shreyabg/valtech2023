package com.valtech.training.employeespringbootmvc.service;

import java.util.List;

import com.valtech.training.employeespringbootmvc.entities.Employee;



public interface EmployeeService {
	Employee createEmployee(Employee emp);

	Employee updateEmployee(Employee emp);

	Employee getEmployee(int empId);

	List<Employee> getAllEmployees();

}
