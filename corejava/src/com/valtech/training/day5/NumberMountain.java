package com.valtech.training.day5;

public class NumberMountain {
	public static void main(String[] args) {
		NumberMountain nm=new NumberMountain();
		System.out.println(nm.isMountain(4,5,3,2,1));
		System.out.println(nm.isMountain(4,3,3,2,1));
		System.out.println(nm.isMountain(6,5,3,2,1));
		System.out.println(nm.isMountain(4,5,3,5,1));
		System.out.println(nm.isMountain(4,5,6,7,8));
	
	}
	
	private boolean isMountain(int ...i) {
		
		int peak=identifyPeak(i);
		if(peak==0 || peak==i.length-1)return false;
		//check if it is in asc
		boolean asc=checkAscending(i,peak);
		//check if the other is desc
		boolean desc=checkDescending(i,peak);
		return asc && desc;
		
	}
	

	private boolean checkDescending(int[] i,int peak) {
		boolean desc=true;
		for(int j=peak;j< i.length-1;j++) {
			if(i[j]<i[j+1]) {
				desc=false;
			}
		}
		
		return desc;
	}

	private boolean checkAscending(int []i,int peak) {
		boolean asc=true;
		for(int j=0;j<peak-1;j++) {
			if(i[j]>i[j+1]) {
				asc=false;
			}
		}
		return asc;
	}

	private int identifyPeak(int[] i) {
		int index=0;
		int max=0;
		for(int j=0;j<i.length;j++) {
		if(i[j]>max) {
			
			max=i[j];
			index=j;
			
		}
		}
		
		return index;
	}

}
