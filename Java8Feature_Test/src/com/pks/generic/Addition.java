package com.pks.generic;

public class Addition {
	
	public static void main(String args[]) {
		
		Calculate<Double> calc=new Calculate<Double>(10.00);
		
		System.out.println(calc.getCalculate());
		calc.<String>printValues("rahul");
		
	}

}
