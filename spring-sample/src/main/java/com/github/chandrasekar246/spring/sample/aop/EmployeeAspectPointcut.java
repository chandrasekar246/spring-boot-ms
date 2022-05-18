
package com.github.chandrasekar246.spring.sample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspectPointcut {

	@Before("getNamePointcut()")
	public void loggingAdvice() {
		System.out.println("EmployeeAspectPointcut: Executing loggingAdvice on getName()");
	}

	@Before("getNamePointcut()")
	public void secondAdvice() {
		System.out.println("EmployeeAspectPointcut: Executing secondAdvice on getName()");
	}

	@Pointcut("execution(public String getName())")
	public void getNamePointcut() {
		System.out.println("EmployeeAspectPointcut: Executing Advice on getName()");
	}

	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice() {
		System.out.println("EmployeeAspectPointcut: Before executing service method");
	}

	// Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(com.github.chandrasekar246.spring.sample.aop.*)")
	public void allMethodsPointcut() {
		System.out.println("EmployeeAspectPointcut: Service method getter called");
	}

}
