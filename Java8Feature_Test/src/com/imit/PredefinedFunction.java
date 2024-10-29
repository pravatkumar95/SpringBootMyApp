package com.imit;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredefinedFunction {
	
  public static void main(String[] args) {
	  
	  //Function
	   Function<String,String> fun=(String b) ->{
		   
		   return b;
	   };
	   System.out.println(fun.apply("pravat"));
	   
	   //bifunction
	   
	   BiFunction<String[],String[],List<String>> fun2=(String[] a,String[] b) ->{
		   
		   List<String> s1=Arrays.asList(a);
		    List<String> s2=Arrays.asList(b);
		    return s2;
	   };
	   String ss1[]= {"pravat","deepak","meera"};
	   String ss2[]= {"muna","deepak","meera"};
	   System.out.println(fun2.apply(ss1,ss2));
	   
	   //consumer
	   System.out.println("------consumer-----------");
	   
	   Consumer<String> con= a -> System.out.println(a);
	   con.accept("rahul");
	   
	   //BiConsumer
	   BiConsumer<String,String> con2= (String a,String b) ->{
		   System.out.println(a+" "+b);
	   };
	   
	   con2.accept("pravat","karthik");
	   
	   //supplier
	   System.out.println("------supplier---------");
	   
	   Supplier<String> sup= () ->{
		   
		   return "welcome to java world";
		   
	   };
	   System.out.println(sup.get());
	   
	   //predicate
	   System.out.println("------predicate--------");
	   
	   Predicate<String> pred= (String s1) ->{
		   return s1.equalsIgnoreCase("raja");
	   };
	   System.out.println(pred.test("raja"));
	   
	   
	  
	  
	
}

}
