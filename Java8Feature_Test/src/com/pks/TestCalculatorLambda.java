package com.pks;

public class TestCalculatorLambda {
	public static void main(String[] args) {
		
		Calculator calc= (int a,int b) ->{
			return  a+b;
		};
		System.out.println(calc.sum(30,50));
		
		
	}
	
	

}
