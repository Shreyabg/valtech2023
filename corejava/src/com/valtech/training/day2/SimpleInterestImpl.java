package com.valtech.training.day2;

public class SimpleInterestImpl implements SimpleInterest{
  private Arithmetic arithmetic;
  public SimpleInterestImpl(Arithmetic arithmetic) {
	  this.arithmetic=arithmetic;
  }
  public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	@Override
	public double computInterest(int prin, int roi, int duration) {
		int result=arithmetic.mul(prin, roi);
		result=arithmetic.mul(result,duration);// ptr/100
		return arithmetic.div(result, 100);
	}
	public static void main(String[] args) {
		Arithmetic arithmetic=new ArithmeticImpl();
		SimpleInterest si=new SimpleInterestImpl(arithmetic);
		System.out.println(si.computInterest(200, 3, 4));
	}
	

}
