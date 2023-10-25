package com.valtech.training.AssignmentJDBC;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	public long count() throws SQLException;

	void deleteEmployee(int id)throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws Exception;

	void saveEmployee(Employee emp);
    void setEmployeeDepartment(int employeeId, int departmentId) throws SQLException;

	List<Employee> getAllEmployees() throws Exception;

	Employee getEmployee(int id) throws SQLException;
	
	List<Employee> getEmployeeByDepartment(int departmentId) throws SQLException;
	
	List<Employee> getEmployeeSalaryGreaterThan(int minSalary) throws SQLException;
	
	

	List<Employee> getEmployeesBySeniority() throws SQLException;

	List<Employee> getEmployeesByLocation(String location) throws SQLException;

	List<Employee> getEmployeesByAgeBetween(int minAge, int maxAge) throws SQLException;

}