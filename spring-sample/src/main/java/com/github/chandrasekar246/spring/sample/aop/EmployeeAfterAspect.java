
package com.github.chandrasekar246.spring.sample.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAfterAspect {

	@After("args(name)")
	public void logStringArguments(String name) {
		System.out.println("EmployeeAfterAspect: Running After Advice. String argument passed=" + name);
	}

	@AfterThrowing("within(Employee)")
	public void logExceptions(JoinPoint joinPoint) {
		System.out.println("EmployeeAfterAspect: Exception thrown in Employee Method=" + joinPoint.toString());
	}

	@AfterReturning(pointcut = "execution(* getName())", returning = "returnString")
	public void getNameReturningAdvice(String returnString) {
		System.out.println("EmployeeAfterAspect: getNameReturningAdvice executed. Returned String=" + returnString);
	}

}
