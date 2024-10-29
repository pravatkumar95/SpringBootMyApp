package com.pks.generic;

class Calculate<T extends Number> {
	
	private T t;
	
	public Calculate(T t) {
		this.t=t;
	}
	
	public T getCalculate() {
		return t;
	}
	
	public void setCalculate(T t) {
		this.t=t;
	}
	
	public <String> void printValues(String t) {
		System.out.println(t);
		
	}
	

}
