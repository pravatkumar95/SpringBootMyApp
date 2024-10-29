package com.pks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerApp {
	
	public static void main(String[] args) {
		
		System.out.println("Without forEach method");
		
		Employee e1=new Employee(101,"raja");
		Employee e2=new Employee(102,"karan");
		Employee e3=new Employee(103,"rahul");
		
		List<Employee> listEmployee=new ArrayList<Employee>();
		listEmployee.add(e1);
		listEmployee.add(e2);
		listEmployee.add(e3);
		//1 way Consumer<Employee> consume= (emp) -> System.out.println(emp.getId()+" "+emp.getName());
//		2 way Consumer<List<Employee>> consume= (emp) -> {
//			
//			Iterator itr=emp.iterator();
//			while(itr.hasNext()) {
//				
//				Employee emp1=(Employee)itr.next();
//				System.out.println(emp1.getId()+" "+emp1.getName());
//			}
//			
//			
//		};
//		
//		
//		
//		consume.accept(listEmployee);
		
		//3rd  way
		
		listEmployee.forEach( emp -> System.out.println(emp.getId()+" "+emp.getName()) );
		
	}

}
