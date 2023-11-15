package com.valtech.training.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.valtech.training.hibernate.Employee;
@Repository //All DAO classes will be defined using the repository
//@Service for all classes that are service class.. they will need Tx Support
//@Controller for all classes when we want them to be used for presentation logic
//@component they are general classes which  have to be registered with beanfactory
public class EmployeeDAOImpl implements EmployeeDAO {
	
	
@Autowired	
private SessionFactory sessionFactory;
@Override
public void deleteEmployee(Employee emp) {
	Session ses= sessionFactory.getCurrentSession();
	ses.delete(emp);
	ses.clear();
	}
@Override
public Employee saveEmployee(Employee emp) {
	Session ses= sessionFactory.getCurrentSession();
	ses.persist(emp);
	//ses.close();
	return emp;
	
}
@Override
public Employee loadEmployee(int empId) {
	Session ses= sessionFactory.getCurrentSession();
	Employee emp=(Employee) ses.load(Employee.class, empId);
	//ses.close();
	return emp;	
}
@Override
public Employee updateEmployee(Employee emp) {
	Session ses= sessionFactory.getCurrentSession();
   emp=(Employee)ses.merge(emp);
	//ses.close();
	return emp;
}
@Override
public List<Employee> getAllEmployees() {
	Session ses= sessionFactory.getCurrentSession();
	List<Employee> emps=ses.createQuery("from Employee e").list();
	//ses.close();
	return emps;
	}

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

	
	

}
