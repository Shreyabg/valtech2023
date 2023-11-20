package com.valtech.training.employeespringbootmvc.model;

import com.valtech.training.employeespringbootmvc.entities.Employee;

public class EmployeeModel {
	private int id;
	private String name;
	private int age;
	private int experience;
	private int seniority;
	private int salary;
	
	
	
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeModel(Employee e) {
		this.id=e.getId();
		this.name=e.getName();
		this.age=e.getAge();
		this.experience=e.getExperience();
		this.seniority=e.getSeniority();
		this.salary=e.getSalary();
		
	}
	public Employee getEmployee() {
		return new Employee(id,name,age,experience,seniority,salary);
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getSeniority() {
		return seniority;
	}
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
