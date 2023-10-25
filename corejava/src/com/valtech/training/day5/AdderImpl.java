package com.valtech.training.day5;

public class AdderImpl implements Adder{
    
	@Override
	public int add(int a, int b) {
		return a+b;
	}
	public static void main(String[] args) { 
		Adder a=new AdderImpl();
		System.out.println(a.add(2,3));
		//all these 3 serve the same purpose
		Adder a1=new Adder() {
			public int add(int a,int b) {
				return a+b;
			}
		};
		
		
		System.out.println(a1.add(1,10));
		//lambda Expressions
		Adder a2=(i,j)->{return(i+j);};
		System.out.println(a2.add(3, 4));

}
}
