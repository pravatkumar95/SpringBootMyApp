package com.pks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertArrayListToMap {

	public static void main(String args[]) {
		
		List<Student> list=new ArrayList<>();
		Student st1=new Student(101,"ram");
		Student st2=new Student(102,"karan");
		Student st3=new Student(103,"sameer");
		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		Map<Integer,String> map=new HashMap<>();
		for(Student std: list) {
			
			map.put(std.getId(),std.getName());
		}
		
		System.out.println(list);
		System.out.println(map);
		
	}
}
