package com.valtech.training.day5;

public class ArrayCheck {
   int a[]= {4,5,6,4,5,2,1};
   
   boolean checkArray() {
	   
	   
	   for(int i=0;i<a.length-1;i++) {
		   
		   
		  if(a[i]<a[i+1]) {
			  continue;
			  
		  }
		  if(a[i]>a[i+1]) {
			 for(int j=i;j<a.length-1;j++) {
				 
				 if(a[j]<a[j+1]) {
					 return false;
				 }
			 } 
			  
		  }
		   
	   }
	   return true;
   }
   
	public static void main(String[] args) {
		
    ArrayCheck Arr=new ArrayCheck();
    boolean res= Arr.checkArray();
    System.out.println(res );

		
	}

}
