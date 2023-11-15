package com.valtech.training.firstspringboot.components;

public class ArithmeticImpl implements Arithmetic{

	@Override
	public int add(int a, int b) {
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		return a-b;
	}

	@Override
	public int mul(int a, int b) {
		
		return a*b;
	}

	@Override
	public int div(int a, int b) throws DivideByZeroException{
	if(b==0)
	{
		throw new DivideByZeroException("Zero cannot be used as denominator");
	}
	return a/b;
	}
	public static void main(String[] args) throws DivideByZeroException{
		Arithmetic a=new ArithmeticImpl();
		try{
			System.out.println(a.div(5,1));	
		}
		catch(DivideByZeroException e) {
		System.out.println(e.getMessage());
	}
		catch(Exception e) {
			System.out.println("can this be seen" );
		}
		finally {
			System.out.println("always seen");
		}
		System.out.println(a.mul(4,2));

	//can make abstract or implement
	


} }
