package com.github.chandrasekar246.spring.sample.hello.world;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldMain {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"beans.xml")) {

			HelloWorld helloWorld = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld");

			System.out.println(helloWorld.getMessage());
			
			HelloWorld helloWorld2 = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld");
			
			System.out.println(helloWorld2.getMessage());
		}
	}
}
