package com.springaop.learn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomAspect {
	@Before("@annotation(com.springaop.learn.aspect.Loggable)")
	public void myAdvice(){
		System.out.println("Executing customized method!!");
	}
}
