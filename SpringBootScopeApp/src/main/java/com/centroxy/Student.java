package com.centroxy;

public class Student {
   private int rollno;
   private String name;
   
   public Student() {
	System.out.println("Student bean created...");
   }

public int getRollno() {
	return rollno;
}

public void setRollno(int rollno) {
	this.rollno = rollno;
	System.out.println("Setter called for rollno...");
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
	System.out.println("Setter called for name...");
}
   
   
}
