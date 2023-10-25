package com.valtech.training.day1;

import java.io.Serializable;

public class Point implements Comparable<Point>,Serializable {
	//1.constants
	//2.static block
	//3.variables
	//4.constructor
	//5.Methods
	public static final Point ORIGIN = new Point();
	// Static Block:- Is used to initialize the static data member.
	//It is executed before the main method at the time of classloading
	static {
		ORIGIN.x=1000;
		ORIGIN.y=2000;
		System.out.println(ORIGIN);//returns package name along 
		//with memory location of object
	}
	protected int x;
	protected transient int y;
	
	public Point()
	{
		System.out.println("Point Constructor");
		}
	public Point(int x,int y)
	{super();//even if not written by default
	System.out.println("IN Ctor of Point");
		this.x=x;
		this.y=y;
	}
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return (x-o.x)==0?(y-o.y):(x-o.x);
		
	}
	
	
	public double distance(Point other)
	{
		System.out.println("Distance with another point");
		return distance(other.x,other.y);
	}
	public double distance(int x,int y)
	{
		int diffx=this.x-x;
		int diffy=this.y-y;
		
	 return Math.sqrt(diffx*diffx + diffy*diffy);
	}
public double distance()
	//normally methods are public
{ 
	System.out.println("distance in point");
	int diffx=x-ORIGIN.x;
    int diffy=y-ORIGIN.y;

	return Math.sqrt(diffx*diffx + diffy*diffy);
	}
	@Override
	public boolean equals(Object obj) {
		Point p=(Point) obj;
		return p.x==x && p.y==y;
	// TODO Auto-generated method stub
		
	}
	//@Override
     public int hashCode() {	// TODO Auto-generated method stub
		return toString().hashCode();
}
	//@Override
	public String toString() {
	// TODO Auto-generated method stub
		return "X=" + x +"Y="+y+"Distance="+ distance();
	}
	public static void main(String[] args) {
		Point p=new Point(2,3);
		p.x=10;
		p.y=20;
		System.out.println(p.distance(1,1));
		Point p1=new Point();
		System.out.println(p1.distance(p));
		System.out.println(p.toString());
	}
}
