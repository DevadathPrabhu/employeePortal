package com.employeePortalApp.employeePortal.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortalApp.employeePortal.entity.Employee;
import com.employeePortalApp.employeePortal.services.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	/*
	 * REST API to get the list of employees.
	 * @return List<Employee>
	 */
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public List<Employee> getEmployee() {
		
		return employeeService.getAllEmployees();
		
	}
	
	/*
	 * REST API to save the employee details with employee details provided in the request.
	 * @param Employee
	 */
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	public void saveEmployee(@RequestBody Employee employee) {
		
		employeeService.saveEmployee(employee);
		
	}
	
	/*
	 * REST API to save the employee with no employee details in request.
	 * In this case, employee id is randomly generated and rest details are hard coded.
	 */
	@RequestMapping(value="/employeeWithoutBody", method=RequestMethod.POST)
	public void saveEmployeeWithoutBody() {
		
		Random randomNum = new Random();
		Employee employee = new Employee(randomNum.nextInt(), "Devadath", "Prabhu", "M", "31/05/1994", "R&D");
		
		employeeService.saveEmployee(employee);
		
	}
}
