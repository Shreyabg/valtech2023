package com.valtech.training.spring;

public interface Arithmetic {
	int ZERO=0; //it is automatically public static and final(constant)
	//it should be well defined at the time of declaration.
	int add(int a,int b);//green -Public and it is abstract
	int sub(int a,int b);
	int mul(int a,int b);
	int div(int a,int b) throws DivideByZeroException;
	
}

