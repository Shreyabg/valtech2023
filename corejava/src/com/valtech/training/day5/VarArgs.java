package com.valtech.training.day5;

public class VarArgs {
	
	public int add(int a,int ...b) {//atleast 1 arg 'a' has to be present
		//varargs 'b' should always be last argument and should be only once
		int result=a;
		//b is an array
		for(int b1:b) {
			result+=b1;
		}
		//System.out.println(b.length);//b acts like an array
		return result;
	}
	public static void main(String[] args) {
		VarArgs va=new VarArgs();
		System.out.println(va.add(2));
		System.out.println(va.add(2, 3));
		System.out.println(va.add(2, 3,4));
		System.out.println(va.add(2, 3,4,5));	
	}

}
