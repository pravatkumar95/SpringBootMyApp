package com.pks;

public class Employee {
	
	public int id;
	public String name;
	
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		
		this.name=name;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
