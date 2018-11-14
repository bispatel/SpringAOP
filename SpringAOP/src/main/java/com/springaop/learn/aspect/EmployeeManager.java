package com.springaop.learn.aspect;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
	
	public EmployeeDTO getEmployeeById(Integer employeeId) {
        System.out.println("Method getEmployeeById() called");
        return new EmployeeDTO();
    }
 
    public List<EmployeeDTO> getAllEmployee() {
        System.out.println("Method getAllEmployee() called");
        return new ArrayList<EmployeeDTO>();
    }
 
    public void createEmployee(EmployeeDTO employee) {
        System.out.println("Method createEmployee() called");
    }
 
    public void deleteEmployee(Integer employeeId) {
        System.out.println("Method deleteEmployee() called");
    }
 
    public void updateEmployee(EmployeeDTO employee) {
        System.out.println("Method updateEmployee() called");
    }
    
    public void insertEmployee(EmployeeDTO employee) throws Exception{
        System.out.println("Method insertEmployee() called");
        throw new Exception("Invalid Name");
    }
    
    public String getName(String name) {
    	return "Hello "+name;
    }
    
    @Loggable
    public String customAspectMethod() {
    	return "Hi";
    }
}
