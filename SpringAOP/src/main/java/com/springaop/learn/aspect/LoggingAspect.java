package com.springaop.learn.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Pointcut("execution(* EmployeeManager.getEmployeeById(..))")
	public void getCall() {}
	
	@Pointcut("execution(* EmployeeManager.*(..))")
	public void allMethod() {}
	
	
	@Before("getCall()")
	public void logBeforeV1(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBeforeV1() : " + joinPoint.getSignature().getName());
	}

	@Before("allMethod()")
	public void logBeforeV2(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logBeforeV2() : " + joinPoint.getSignature().getName());
	}

	@After("getCall()")
	public void logAfterV1(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfterV1() : " + joinPoint.getSignature().getName());
	}

	@After("allMethod()")
	public void logAfterV2(JoinPoint joinPoint) {
		System.out.println("LoggingAspect.logAfterV2() : " + joinPoint.getSignature().getName());
	}
	
	
	@Before("execution(public void com.springaop.learn.aspect..deleteEmployee(*))")
	public void logAgrgumentPassed(JoinPoint joinPoint){
		System.out.println("LoggingAspect.logAgrgumentPassed on method="+joinPoint.toString());		
		System.out.println("\t\t\tAgruments Passed=" + Arrays.toString(joinPoint.getArgs()));

	}
	
	//Advice arguments, will be applied to bean methods with single String argument
	@Before("args(id)")
	public void logStringArguments(Integer id){
		System.out.println("Integer argument passed="+id);
	}
	
	@AfterThrowing("within(com.springaop.learn.aspect.EmployeeManager)")
	public void logExceptions(JoinPoint joinPoint){
		System.out.println("LoggingAspect.logExceptions "+joinPoint.toString());
	}
	
	@AfterReturning(pointcut="execution(* EmployeeManager.getName(..))", returning="returnString")
	public void getNameReturningAdvice(String returnString){
		System.out.println("LoggingAspect.getNameReturningAdvice executed. Returned String="+returnString);
	}
	
	@Around("getCall()")
	public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		System.out.println("LoggingAspect.employeeAroundAdvice Before invoking getEmployeeById() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("LoggingAspect.employeeAroundAdvice After invoking getEmployeeById() method. Return value="+value);
		return value;
	}
}
