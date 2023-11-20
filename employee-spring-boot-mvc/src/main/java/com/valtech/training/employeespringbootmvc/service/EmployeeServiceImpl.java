package com.valtech.training.employeespringbootmvc.service;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.employeespringbootmvc.entities.Employee;
import com.valtech.training.employeespringbootmvc.repositories.EmployeeRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo empRepo;
	
	@PostConstruct
	public void populateOrders() {
		empRepo.save(new Employee("John",32,2,1,30000));
		empRepo.save(new Employee("Alexa",23,1,1,20000));
		empRepo.save(new Employee("Michel",25,2,2,50000));
		empRepo.save(new Employee("Adhi",26,2,2,50000));
		
	}
	
	
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		System.out.println(empRepo.getClass().getName());
		return empRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}

	@Override
	public Employee getEmployee(int empId) {
		// TODO Auto-generated method stub
		return empRepo.getReferenceById(empId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
