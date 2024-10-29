package com.pks;

public class TestCalculator {
	public static void main(String args[]) {
	
	Calculator calc=new Calculator() {
		
		public int sum(int a,int b) {
			return a+b;
		}
	};
	
	int result=calc.sum(10,20);
	System.out.println("result is"+result);

}
}
