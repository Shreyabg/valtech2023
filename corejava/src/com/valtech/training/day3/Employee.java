package com.valtech.training.day3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {
	String Name;
Integer seniority;
Integer experience; // from the date of joining to the company
int age;
int salary;
public Employee(String n,int s,int e,int a,int salary) {
	Name=n;
	seniority=s;
	experience=e;
	age=a;
	this.salary=salary;
	
	
}
public String toString(){
	return "\n Seniority" + seniority+ " Experience= "+experience+ " name= "+Name;
}
public int compareTo(Employee o) {
	// TODO Auto-generated method stub
	return (this.seniority.compareTo(o.seniority))+(this.experience.compareTo(o.experience));//+ (this.Name.compareTo(o.Name));
}


	public static void main(String[] args) {
    Employee e1=new Employee("John",12,30,60,90000);	
    Employee e2=new Employee("pohn",4,24,50,85000);
    Employee e3=new Employee("fohn",12,20,30,50000);
    Employee e4=new Employee("rohn",12,24,45,40000);
    Employee e5=new Employee("eohn",1,8,29,20000);
    List<Employee> li=new ArrayList<Employee>();
    li.add(e1);
    li.add(e2);
    li.add(e3);
    li.add(e4);
    li.add(e5);
   Collections.sort(li);
    
    System.out.println( li);
	}
}	




