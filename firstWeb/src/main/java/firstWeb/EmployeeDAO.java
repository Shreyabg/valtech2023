package firstWeb;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
	public long count() throws SQLException;
	int firstId() throws SQLException;
	int lastId() throws SQLException;
	int nextId(int id) throws SQLException;
	int previousId(int id) throws SQLException;
	

	void deleteEmployee(int id)throws SQLException;

	void updateEmployee(Employee emp) throws SQLException;

	void createEmployee(Employee emp) throws Exception;

	void saveEmployee(Employee emp);

	List<Employee> getAllEmployees() throws Exception;

	Employee getEmployee(int id) throws SQLException;
	

}