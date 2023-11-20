package com.valtech.training.firstspringboot.components;

import org.springframework.stereotype.Component;

@Component
public class SimpleInterestImpl implements SimpleInterest{
  public SimpleInterestImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
private Arithmetic arithmetic=new ArithmeticImpl();
  public SimpleInterestImpl(Arithmetic arithmetic) {
	  this.arithmetic=arithmetic;
  }
  public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	@Override
	public double computInterest(int prin, int roi, int duration) {
		int result=arithmetic.mul(prin, roi);
		//result=arithmetic.mul(result,duration);// ptr/100
		try {
			return arithmetic.div(result, 100);
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		Arithmetic arithmetic=new ArithmeticImpl();
		SimpleInterest si=new SimpleInterestImpl(arithmetic);
		System.out.println(si.computInterest(200, 3, 4));
	}
	

}
