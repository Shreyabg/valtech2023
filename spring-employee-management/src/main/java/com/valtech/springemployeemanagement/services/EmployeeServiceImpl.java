package com.valtech.springemployeemanagement.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.springemployeemanagement.entities.Department;
import com.valtech.springemployeemanagement.entities.Employee;
import com.valtech.springemployeemanagement.repositories.DepartmentRepository;
import com.valtech.springemployeemanagement.repositories.EmployeeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;

	@PostConstruct
	public void populateEmployeesAndDepartments() {

		Department dep = new Department("front End", "Bangalore");
		Department dep1 = new Department("backend", "Bangalore");
		Department dep2 = new Department("manager", "Bangalore");
		Department dep3 = new Department("sales", "Bangalore");
		Department dep4 = new Department("HR", "Bangalore");

		Employee employee = new Employee("Shreya", 20, 1, 1, 45000, dep);
		Employee employee1 = new Employee("Kavya", 22, 1, 1, 45000, dep1);
		Employee employee2 = new Employee("Adni", 21, 1, 1, 45000, dep2);
		Employee employee3 = new Employee("John", 20, 1, 1, 45000, dep3);
		Employee employee4 = new Employee("Michel", 22, 1, 1, 45000, dep4);

		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		employeeRepository.save(employee2);
		employeeRepository.save(employee3);
		employeeRepository.save(employee4);

		departmentRepository.save(dep);
		departmentRepository.save(dep1);
		departmentRepository.save(dep2);
		departmentRepository.save(dep3);
		departmentRepository.save(dep4);
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.getReferenceById(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(int id) {
		departmentRepository.deleteById(id);
	}

	@Override
	public Department getDepartmentById(int id) {
		return departmentRepository.getReferenceById(id);
	}

	@Override
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public int getFirstId() {
		return departmentRepository.findMinId();
	}

	@Override
	public int getLastId() {
		return departmentRepository.findMaxId();
	}

	@Override
	public int getPreviousId(int id) {
		int previousId = departmentRepository.findPreviousId(id);
		return (previousId == 0) ? getLastId() : previousId;
	}

	@Override
	public int getNextId(int id) {
		int nextId = departmentRepository.findNextId(id);
		return (nextId == 0) ? getFirstId() : nextId;
	}

	@Override
	public List<Employee> getAllEmployeesByDepartment(int id) {
		return employeeRepository.findEmployeeByDepartmentId(id);
	}
}
