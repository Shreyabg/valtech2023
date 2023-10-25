package com.valtech.training.AssignmentJDBC;

public class Department {
	private int depId;
	private String depName;
	private String location;
	
	public String toString() {
		return "Employee [id=" + depId + ", name=" + depName + ", location=" + location +"]";
	}
	public Department(String name, String location) {
		super();
		this.depName = name;
		this.location = location;
	}
	public Department(int id, String name, String location) {
		super();
		this.depId = id;
		this.depName = name;
		this.location = location;
	}
	public int getId() {
		return depId;
	}
	public void setId(int id) {
		this.depId = id;
	}
	public String getName() {
		return depName;
	}
	public void setName(String name) {
		this.depName = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	

}