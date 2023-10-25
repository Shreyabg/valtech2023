package com.valtech.training.AssignmentJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {

    @Override
    public void createDepartment(Department department) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO DEPARTMENT (depId,depName, LOCATION) VALUES (?,?, ?)");
        ps.setInt(1, department.getId());
        ps.setString(2, department.getName());
        ps.setString(3, department.getLocation());
        int rowsUpdated = ps.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
        conn.close();
    }

    @Override
    public Department getDepartment(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT DEPID, DEPNAME, LOCATION FROM DEPARTMENT WHERE ID = ?");
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        Department department = null;
        if (rs.next()) {
            department = mapRowToDepartment(rs);
        }
        conn.close();
        return department;
    }

    @Override
    public List<Department> getAllDepartments() throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT DEPID,DEPNAME, LOCATION FROM DEPARTMENT");
        ResultSet rs = ps.executeQuery();
        List<Department> departments = new ArrayList<>();
        while (rs.next()) {
            departments.add(mapRowToDepartment(rs));
        }
        conn.close();
        return departments;
    }

    @Override
    public void updateDepartment(Department department) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("UPDATE DEPARTMENT SET DEPNAME = ?, LOCATION = ? WHERE DEPID = ?");
        ps.setString(1, department.getName());
        ps.setString(2, department.getLocation());
        ps.setInt(3, department.getId());
        int rowsUpdated = ps.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
        conn.close();
    }

    @Override
    public void deleteDepartment(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM DEPARTMENT WHERE depID = ?");
        ps.setInt(1, id);
        int rowsUpdated = ps.executeUpdate();
        System.out.println("Rows Updated: " + rowsUpdated);
        conn.close();
    }

    private Department mapRowToDepartment(ResultSet rs) throws SQLException {
        int id = rs.getInt("depID");
        String name = rs.getString("depNAME");
        String location = rs.getString("LOCATION");
        return new Department(id, name, location);
    }

    private Connection getConnection() throws SQLException {
        // Replace with your database connection details
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/valtech2023?useSSL=false", "root", "root");
    }
    public static void main(String[] args) throws Exception {
		DepartmentDAO dept=new DepartmentDAOImpl();
		//dept.createDepartment(new Department(3,"EEE","Mysore"));
		dept.deleteDepartment(0);
	}
}
