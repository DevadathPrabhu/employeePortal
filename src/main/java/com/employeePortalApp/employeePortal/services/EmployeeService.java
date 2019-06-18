package com.employeePortalApp.employeePortal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeePortalApp.employeePortal.entity.Employee;
import com.employeePortalApp.employeePortal.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo employeeRepo;
	
	/*
	 * Returns all the employees in the H2 DB.
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployees() {

		List<Employee> empList = new ArrayList<Employee>();
		Iterable<Employee> empIterble = employeeRepo.findAll();
		Iterator<Employee> empIterator = empIterble.iterator();

		while (empIterator.hasNext()) {
			Employee e = (Employee) empIterator.next();
			empList.add(e);
		}

		return empList;
		
	}

	/*
	 * Saves the employee details to the H2 DB.
	 * @param Employee
	 */
	public void saveEmployee(Employee e) {

		employeeRepo.save(e);

	}

}
