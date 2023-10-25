package com.valtech.training.AssignmentJDBC;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    void createDepartment(Department department) throws SQLException;

    Department getDepartment(int id) throws SQLException;

    List<Department> getAllDepartments() throws SQLException;

    void updateDepartment(Department department) throws SQLException;

    void deleteDepartment(int id) throws SQLException;
}
