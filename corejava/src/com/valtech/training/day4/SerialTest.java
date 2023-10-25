package com.valtech.training.day4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.valtech.training.day1.Point;
import com.valtech.training.day1.Point3D;

public class SerialTest {

	public static void main(String[] args) throws Exception {
   Point p=new Point(2,3);
   System.out.println(p);
   ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("objects")));
   oos.writeObject(p);
   oos.flush();//anything that is in cache should be written to underlined file
   oos.close();
   ObjectInputStream ois=new ObjectInputStream(new FileInputStream(new  File("objects")));
   Point p1=(Point)ois.readObject();
   System.out.println(p1);
   System.out.println("hello=" + (p==p1));
   
   Point3D p3d=new Point3D(10,20,30);
   ObjectOutputStream oos1=new ObjectOutputStream(new FileOutputStream(new File("objects")));
   oos1.writeObject(p3d);
   oos1.flush();//anything that is in cache should be written to underlined file
   oos1.close();
   ObjectInputStream ois1=new ObjectInputStream(new FileInputStream(new  File("objects")));
   
   Point3D p3d1=(Point3D)ois1.readObject();
   System.out.println(p3d==p3d1);
   System.out.println(p3d1.distance());
   
   
	}

}
