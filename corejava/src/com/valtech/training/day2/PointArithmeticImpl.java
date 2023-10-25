package com.valtech.training.day2;

public class PointArithmeticImpl implements PointArithmetic {
	

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		return b-a;
	}
	double distance(PointArithmetic o) {
		return Math.sqrt(o.a*o.a+o.b*o.b);
	}
	public static void main(String[] args) {
		PointArithmetic p=new PointArithmeticImpl();
		PointArithmeticImpl p1=new PointArithmeticImpl();
		System.out.println(p1.distance(p));
		
		
	}
	

}
