package com.github.chandrasekar246.spring.sample.hello.world;

public class HelloWorld {

	private String message;

	public String getMessage() {
		System.out.println(this);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void init() throws Exception {
		System.out.println("Initialized: " + this);
	}

	public void dest() throws Exception {
		System.out.println("Destroying... " + this);
	}
}
