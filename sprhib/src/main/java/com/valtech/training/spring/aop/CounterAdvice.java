package com.valtech.training.spring.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice{

	/*
	 *method is method that you want to invoke
	 *args is arguments that will be passed to the method
	 *target is the object on which this method will be executed 
	 * 
	 * 
	 * */
	private Map<String,Integer> counters=new HashMap<String,Integer>();
	
	public void loadCounters() {
		
		
		try{
		File file=new File("counters.txt");
		    if(file.exists()) {
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));
			counters=(Map<String,Integer>)ois.readObject();
		   }
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("loading counters..." +counters);
	}
	public void saveCounters() {
		
		System.out.println("saving counters..."+counters);
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("counters.txt")));
			oos.writeObject(counters);
			oos.flush();
			oos.close();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		
		
//		for (int i = 0; i < args.length; i++) {
//			int a=(Integer)args[i];
//			args[i] = a%2==0 ? a:-a;
//			
//		}
	String methodName = method.getName();
	System.out.println("Method being called is " +methodName);	
	System.out.println("arguments is" + ArrayUtils.toString(args));
	if(counters.containsKey(methodName)) {
		counters.put(methodName, counters.get(methodName)+1);
	}
	else {
		counters.put(methodName,1);
	}
	System.out.println(counters);
	}

}
