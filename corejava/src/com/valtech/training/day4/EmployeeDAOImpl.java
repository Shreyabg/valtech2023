package com.valtech.training.day4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//CRUD
//Create
//Read
//Update
//Delete
public class EmployeeDAOImpl implements EmployeeDAO {
	@Override
	public void deleteEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("DELETE FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();
	}

	@Override
	public void updateEmployee(Employee emp) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("UPDATE EMPLOYEE SET NAME =?,AGE=?,EXPERIENCE=?,SENIORITY=?,SALARY=? WHERE ID=?");
		populatePreparedStatementFromEmployee(emp, ps);
		ps.setInt(6, emp.getId());
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();
	}

	@Override
	public void createEmployee(Employee emp) throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = conn
				.prepareStatement("INSERT INTO EMPLOYEE(NAME,AGE,EXPERIENCE,SENIORITY,SALARY) values(?,?,?,?,?)");
		populatePreparedStatementFromEmployee(emp, ps);
		int rowsUpdated = ps.executeUpdate();
		System.out.println("Rows Updated" + rowsUpdated);
		conn.close();
	}

	private void populatePreparedStatementFromEmployee(Employee emp, PreparedStatement ps) throws SQLException {
		ps.setString(1, emp.getName());
		ps.setInt(2, emp.getAge());
		ps.setInt(3, emp.getExperience());
		ps.setInt(4, emp.getSeniority());
		ps.setInt(5, emp.getSalary());
	}

	@Override
	public void saveEmployee(Employee emp) {

	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		Connection conn = getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		List<Employee> emps = new ArrayList<>();
		while (rs.next()) {
			emps.add(mapRowToEmployee(rs));

		}
		conn.close();

		return emps;

	}

	@Override
	public Employee getEmployee(int id) throws SQLException {
		Connection conn = getConnection();
		// prepared statement for execution plan
		PreparedStatement ps = conn
				.prepareStatement("SELECT ID,NAME,AGE,EXPERIENCE,SENIORITY,SALARY FROM EMPLOYEE WHERE ID=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Employee e = mapRowToEmployee(rs);
			conn.close();
			return e;
		} else {
			System.out.println("No Row with id= " + id + "found...");
			return null;
		}

	}

	private Employee mapRowToEmployee(ResultSet rs) throws SQLException {
		Employee e = new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setAge(rs.getInt(3));
		e.setExperience(rs.getInt(4));
		e.setSeniority(rs.getInt(5));
		e.setSalary(rs.getInt(6));
		return e;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
		// ?useSSL=Secure Software layer .This is for latest version
	}

	public static void main(String[] args) throws Exception {
		EmployeeDAO dao = new EmployeeDAOImpl();
//		System.out.println(dao.getEmployee(1));
//		System.out.println(dao.getEmployee(2));
		 dao.createEmployee(new Employee("Xyz",35,12,3,75000));
//		Employee e=dao.getEmployee(3);
//		e.setSeniority(5);
//		dao.updateEmployee(e);
//		dao.deleteEmployee(3);
//		dao.count();
//		System.out.println(dao.getAllEmployees());
//		System.out.println(dao.count());

	}

	@Override
	public long count() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		// prepared statement for execution plan
		PreparedStatement ps = conn.prepareStatement("SELECT COUNT(ID) FROM EMPLOYEE");
		ResultSet rs = ps.executeQuery();
		rs.next();
      	long count = rs.getLong(1);
		conn.close();
		return count;

	}
	
}
