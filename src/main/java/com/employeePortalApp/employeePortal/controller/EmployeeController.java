package com.employeePortalApp.employeePortal.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeePortalApp.employeePortal.entity.Employee;
import com.employeePortalApp.employeePortal.services.EmployeeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/*
	 * REST API to get the list of employees.
	 * @return List<Employee>
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	@ApiOperation(value = "Get employees",
		notes = "Get all the employees. Supports sorting based on fName through the parameter sort.")
	public List<Employee> getEmployees(
			@ApiParam(value = "Sorts the result if positive", required = false) 
			@RequestParam(required = false, defaultValue = "false")
			Boolean sort) {
		
		return employeeService.getEmployees(sort);
		
	}
	
	/*
	 * REST API to save the employee details with employee details provided in the request.
	 * @param Employee
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/employee", method=RequestMethod.POST)
	@ApiOperation(value = "Save employee",
		notes = "Save the employee with given details.")
	public Employee saveEmployee(
			@ApiParam(value = "Employee details") 
			@RequestBody Employee employee) {
		
		return employeeService.saveEmployee(employee);
		
	}
	
	/*
	 * REST API to save the employee with no employee details in request.
	 * In this case, employee id is randomly generated and rest details are hard coded.
	 * Note: This API is only to populate DB randomly.
	 */
	@RequestMapping(value="/employeeWithoutBody", method=RequestMethod.POST)
	@ApiOperation(value = "Save employee",
		notes = "Used for testing purpose. Saves the employee using hardcoded employee details.")
	public Employee saveEmployeeWithoutBody() {
		
		Random randomNum = new Random();
		Employee employee = new Employee(randomNum.nextInt(), "Devadath", "Prabhu", "M", "31/05/1994", "R&D");
		
		return employeeService.saveEmployee(employee);
		
	}
}
