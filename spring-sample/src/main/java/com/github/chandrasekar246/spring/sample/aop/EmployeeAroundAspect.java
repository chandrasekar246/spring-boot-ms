
package com.github.chandrasekar246.spring.sample.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAroundAspect {

	@Around("execution(* Employee.getName())")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("EmployeeAroundAspect: Before invoking getName() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("EmployeeAroundAspect: After invoking getName() method. Return value=" + value);
		return value;
	}
}
