package com.valtech.training.employeespringbootmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.employeespringbootmvc.entities.Employee;
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
