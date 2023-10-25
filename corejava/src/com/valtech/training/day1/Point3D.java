package com.valtech.training.day1;

public class Point3D extends Point {
	public static final Point3D ORIGIN =new Point3D();
	private int z;
	public Point3D() {
		
	}
     public Point3D(int x,int y,int z) {
    	 super(x,y);
    	 System.out.println("In ctor of Point 3D");
    	 this.z=z;
		
	}
      @Override
    public boolean equals(Object obj) {
    	  Point3D p=(Point3D) obj;
    	// TODO Auto-generated method stub
    	return p.x==x && p.y==y &&p.z==z;
    }
      @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return "X="+x+"Y="+y+"Z="+z;
    }
     public double distance(int x,int y,int z) {
    	 int diffx=this.x-x;
    	 int diffy=this.y-y;
    	int diffz=this.z-z;
    	return Math.sqrt(diffx*diffx+diffy*diffy+diffz*diffz);
     }
	//public static final Point3D ORIGIN =new Point3D();
	public double distance( Point3D p) {
		return distance(p.x,p.y,p.z);
		
	}
	
	public double distance() {
		// TODO Auto-generated method stub
		System.out.println("point 3D distane");
		return Math.sqrt(x*x +y*y +z*z);
	}
	public static void main(String[] args) {
		ORIGIN.x=10;
		System.out.println(Point.ORIGIN.distance());
		System.out.println(ORIGIN.distance());
		Point3D p=new Point3D(10,20,30);
		Point p1=new Point3D();
		System.out.println(p.distance());
		System.out.println(p1.distance());
		
		
		
	}

}
