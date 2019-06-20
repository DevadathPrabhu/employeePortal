package com.employeePortalApp.employeePortal.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.employeePortalApp.employeePortal.entity.Employee;
import com.employeePortalApp.employeePortal.repo.EmployeeRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	EmployeeRepo employeeRepo;
	
	@Test
	public void testGetEmployeesWithDetail() {
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee(1, "Devadath", "Prabhu", "Male", "31/05/1994", "R&D");
		employeeList.add(employee);
		
		doReturn(employeeList).when(employeeRepo).findAll();
		
		List<Employee> employees = employeeService.getEmployees();
		
		verify(employeeRepo, times(1)).findAll();
		assertThat(employees.size(), equalTo(1));
		assertThat(employees.get(0).getId(), equalTo(1));
		assertThat(employees.get(0).getfName(), equalTo("Devadath"));
		assertThat(employees.get(0).getlName(), equalTo("Prabhu"));
		assertThat(employees.get(0).getGender(), equalTo("Male"));
		assertThat(employees.get(0).getDob(), equalTo("31/05/1994"));
		assertThat(employees.get(0).getDepartment(), equalTo("R&D"));
		
	}
	
	@Test
	public void testGetEmployeesWithoutDetail() {
		
		doReturn(new ArrayList<Employee>()).when(employeeRepo).findAll();
		
		List<Employee> employees = employeeService.getEmployees();
		
		verify(employeeRepo, times(1)).findAll();
		assertThat(employees.size(), equalTo(0));
		
	}
	
	@Test
	public void testSaveEmployee() {
		
		Employee employee = new Employee(1, "Devadath", "Prabhu", "Male", "31/05/1994", "R&D");
		
		doReturn(null).when(employeeRepo).save(employee);
		
		employeeService.saveEmployee(employee);
		
		verify(employeeRepo, times(1)).save(employee);
		
	}
	
}
