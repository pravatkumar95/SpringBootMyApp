package com.centroxy.main;

import java.io.File;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String args[]) {
		try {
	//File configFile = new File("/SpringBootScopeApp/src/main/java/com/centroxy/conf/applicationContext.xml");

    ApplicationContext container=new ClassPathXmlApplicationContext("com/centroxy/conf/applicationContext.xml");

  
    Object obj=container.getBean("stObj");

    System.out.println("Container started");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}
