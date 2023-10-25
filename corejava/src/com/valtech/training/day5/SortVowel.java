package com.valtech.training.day5;

public class SortVowel {
 
 
String[] breakToWords() 
{String Sen="hello how are you";
 return Sen.split(" ");
}
  void countVowelsForEachWord(String[] s) {
	 
	for(int i=0;i<s.length;i++) {
		
		System.out.println(s[i]);
		String m=s[i];
		int countV=0;
		int countCon=0;
		 int[] xV ;
			int[] xC;
		
		for(int j=0;j<m.length();j++) {
			if(m.charAt(j)=='a' || m.charAt(j)=='e' ||m.charAt(j)=='i' || m.charAt(j)=='o' || m.charAt(j)=='u') {
				countV++;	
			}
			else {
				countCon++;
			}
			
		//System.out.println(m.charAt(j));
			
			
		}
		System.out.println(countV++);
		
		
	}
	
	
	
	  
	 
   }



	
	
	
	
	
	public static void main(String[] args) {
    
	SortVowel sv=new SortVowel();	
	String[] splitted=sv.breakToWords();
	
	
	
	sv.countVowelsForEachWord(splitted);
		
	}

}
