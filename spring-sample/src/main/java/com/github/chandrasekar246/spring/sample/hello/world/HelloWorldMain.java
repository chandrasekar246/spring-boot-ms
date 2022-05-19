package com.github.chandrasekar246.spring.sample.hello.world;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldMain {

	public static void main(String[] args) throws InterruptedException {
		try (ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(
				"beans.xml")) {

			HelloWorld helloWorldSingleton = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld");

			System.out.println(helloWorldSingleton.getMessage());

			HelloWorld helloWorldSingleton2 = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld");

			System.out.println(helloWorldSingleton2.getMessage());

			HelloWorld helloWorldPrototype = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld2");

			System.out.println(helloWorldPrototype.getMessage());

			HelloWorld helloWorldPrototype2 = (HelloWorld) classPathXmlApplicationContext.getBean("helloWorld2");

			System.out.println(helloWorldPrototype2.getMessage());
		}
	}
}
