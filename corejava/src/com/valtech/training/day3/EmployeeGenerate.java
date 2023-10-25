package com.valtech.training.day3;

import java.util.Random;

public class EmployeeGenerate {
		int age;
		String Name;
		int level;
		int experience;

		
		
		String RandomName() {
			 String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			 String alphabetSmall = "abcdefghijklmnopqrstuvwxyz";

			    // create random string builder
			    StringBuilder sb = new StringBuilder();

			    // create an object of Random class
			    Random random = new Random();

			    // specify length of random string
			    int length = random.nextInt(6) + 4;
			    char randChar = alphabet.charAt(random.nextInt(alphabet.length()));
			    sb.append(randChar);

			    for(int i = 1; i < length; i++) {

			      // generate random index number
			      int index = random.nextInt(alphabetSmall.length());

			      // get character specified by index
			      // from the string
			      char randomChar = alphabetSmall.charAt(index);

			      // append the character to string builder
			      sb.append(randomChar);
			     
		         }
			    return sb.toString();
			    }
		
		
		EmployeeGenerate Generate(EmployeeGenerate x) {
			Random rand = new Random();
			int min=20;
			int max=60;
			int min1=1;
			int max1=5;
			int min2=10;
			int max2=15;
			 x.age = rand.nextInt(max - min + 1) + min;
			x.Name=RandomName();
			if(x.age<25) {
				x.experience = rand.nextInt(10) + 0;
			}
			else if(x.age<45) {
			x.experience = rand.nextInt(max2 - min2 + 1) + min2;
			}
			else {
				x.experience=rand.nextInt(15)+15;			}
			
			if(x.experience<=15 && x.age<40) {
			x.level = rand.nextInt(max1 - min1 + 1) + min1;}
			else {
				x.level = rand.nextInt(10 - 6 + 1) + 6;
			}
			return x;
		}

	

	public static void main(String[] args) {
      EmployeeGenerate e1=new EmployeeGenerate();
      EmployeeGenerate e2=new EmployeeGenerate();
      EmployeeGenerate e3=new EmployeeGenerate();
      EmployeeGenerate e4=new EmployeeGenerate();
      EmployeeGenerate e5=new EmployeeGenerate();
      e1.Generate(e1);
      e2.Generate(e2);
      e3.Generate(e3);
      e4.Generate(e4);
      e5.Generate(e5);
      
      System.out.println("Employee 1" +" age= " + e1.age +" Name= "+ e1.Name +" level= "+ e1.level +" Experiance= "+e1.experience);
      System.out.println("Employee 2" +" age= " + e2.age +" Name= "+ e2.Name +" level= "+ e2.level +" Experiance= "+e2.experience);
      System.out.println("Employee 3" +" age= " + e3.age +" Name= "+ e3.Name +" level= "+ e3.level +" Experiance= "+e3.experience);
      System.out.println("Employee 4" +" age= " + e4.age +" Name= "+ e4.Name +" level= "+ e4.level +" Experiance= "+e4.experience);
      System.out.println("Employee 5" +" age= " + e5.age +" Name= "+ e5.Name +" level= "+ e5.level +" Experiance= "+e5.experience);
	}

}
