
package com.github.chandrasekar246.spring.sample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {

	@Before("execution(public String getName())")
	public void getNameAdvice() {
		System.out.println("EmployeeAspect: Executing Advice on getName()");
	}

	@Before("execution(* com.github.chandrasekar246.spring.sample.aop.*.get*())")
	public void getAllAdvice() {
		System.out.println("EmployeeAspect: Service method getter called");
	}
}
