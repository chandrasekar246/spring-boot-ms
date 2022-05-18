
package com.github.chandrasekar246.spring.sample.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAnnotationAspect {

	@Before("@annotation(Loggable)")
	public void myAdvice() {
		System.out.println("EmployeeAnnotationAspect: Executing myAdvice!!");
	}
}
