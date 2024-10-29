package com.pks;

import java.util.Arrays;
import java.util.List;

public class LambdaExpression01{
	
	public static void main(String args[]) {
		
//		List<String> list1=List.of("raja","karan","hari","rekha");
//		list1.add(0,"tapan");
//		list1.forEach(a -> System.out.println(a));
		
		String[] str= {"rekha","meena","shravan"};
		
		List<String> s1=Arrays.asList(str);
		s1.add(0,"karna");
		System.out.println(s1);
		
		
		
		
	}

}
