package com.pks;

public class Doctor implements Comparable<Doctor> {
	
	private Integer id;
	private String name;
	private String department;
	
	public Doctor(Integer id,String name,String department) {
		this.id=id;
		this.name=name;
		this.department=department;
	}
	
	
	

	@Override
	public int compareTo(Doctor o) {
		// TODO Auto-generated method stub
		if(this.name.compareTo(o.name) !=0) {
			return this.name.compareTo(o.name);
		}
		else {
			return this.id-o.id;
		}
	}
	
	public String toString() {
		
		return "id="+this.id+"name="+this.name+"department="+this.department;
	}
	

}
