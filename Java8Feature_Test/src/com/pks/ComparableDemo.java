package com.pks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ComparableDemo {
	
	public static void main(String args[]) {
		Doctor d1=new Doctor(100,"rahul","cardiology");
		Doctor d2=new Doctor(200,"mahesh","casuality");
		Doctor d3=new Doctor(50,"aftab","Neurology");
		
//	  List<Doctor> doctor1 =List.of(d1);
//	  List<Doctor> doctor2=List.of(d2);
//	  List<Doctor> doctor3=List.of(d3);
//	  List<List<Doctor>> doctors=new ArrayList<>();
//	  doctors.add(doctor1);
//	  doctors.add(doctor2);
//	  doctors.add(doctor3);
		Doctor[] doctors=new Doctor[3];
		doctors[0]=d1;
		doctors[1]=d2;
		doctors[2]=d3;
		for(Doctor d: doctors) {
			System.out.println(d);
		
			
		}
	  Arrays.sort(doctors);
	  System.out.println("-------------");
	  for(Doctor d: doctors) {
			System.out.println(d);
			
		}
	  
	  
	}

}
