package com.springaop.learn.aspect;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {
	@SuppressWarnings("resource")
	public static void main(String[] args) {

		 AnnotationConfigApplicationContext context
	        = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeManager manager = context.getBean(EmployeeManager.class);
		System.out.println("---Get Method Called---");
		manager.getEmployeeById(1);
		System.out.println("\n----Create Method Called----");
		manager.createEmployee(new EmployeeDTO());
		
		System.out.println("\n----Delete Method Called----");
		manager.deleteEmployee(105);
		
		System.out.println("\n----@AfterThrowing Method Called----");
		try {
			manager.insertEmployee(new EmployeeDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("\n----@AfterReturning Method Called----");
		manager.getName("Bishwajit");
		
		manager.customAspectMethod();
	}
}
