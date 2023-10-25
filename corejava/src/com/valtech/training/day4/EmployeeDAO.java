package com.valtech.training.day4;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	public long count() throws SQLException;

	void deleteEmployee(int id)throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws Exception;

	void saveEmployee(Employee emp);

	List<Employee> getAllEmployees() throws Exception;

	Employee getEmployee(int id) throws SQLException;

}