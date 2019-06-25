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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.employeePortalApp.employeePortal.entity.Employee;
import com.employeePortalApp.employeePortal.repo.EmployeeRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Spy
	@InjectMocks
	private EmployeeService employeeService;
	
	@Mock
	private EmployeeRepo employeeRepo;
	
	@Test
	public void testGetEmployeesWithoutSort() {
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee(1, "Devadath", "Prabhu", "Male", "31/05/1994", "R&D");
		employeeList.add(employee);
		employee = new Employee(2, "Gurudath", "Prabhu", "Male", "01/05/1998", "R&D");
		employeeList.add(employee);
		employee = new Employee(3, "Ankit", "Prabhu", "Male", "01/05/1992", "R&D");
		employeeList.add(employee);
		
		doReturn(employeeList).when(employeeRepo).findAll();
		
		List<Employee> employees = employeeService.getEmployees(false);
		
		verify(employeeRepo, times(1)).findAll();
		assertThat(employees.size(), equalTo(3));
		assertThat(employees.get(0).getId(), equalTo(1));
		assertThat(employees.get(0).getfName(), equalTo("Devadath"));
		assertThat(employees.get(0).getlName(), equalTo("Prabhu"));
		assertThat(employees.get(0).getGender(), equalTo("Male"));
		assertThat(employees.get(0).getDob(), equalTo("31/05/1994"));
		assertThat(employees.get(0).getDepartment(), equalTo("R&D"));
		
		assertThat(employees.get(1).getfName(), equalTo("Gurudath"));
		assertThat(employees.get(2).getfName(), equalTo("Ankit"));
		
	}
	
	@Test
	public void testGetEmployeesWithSort() {
		
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Employee employee = new Employee(1, "Devadath", "Prabhu", "Male", "31/05/1994", "R&D");
		employeeList.add(employee);
		employee = new Employee(2, "Gurudath", "Prabhu", "Male", "01/05/1998", "R&D");
		employeeList.add(employee);
		employee = new Employee(3, "Ankit", "Prabhu", "Male", "01/05/1992", "R&D");
		employeeList.add(employee);
		
		doReturn(employeeList).when(employeeRepo).findAll();
		
		List<Employee> employees = employeeService.getEmployees(true);
		
		verify(employeeRepo, times(1)).findAll();
		assertThat(employees.size(), equalTo(3));
		assertThat(employees.get(0).getfName(), equalTo("Ankit"));
		assertThat(employees.get(1).getfName(), equalTo("Devadath"));
		assertThat(employees.get(2).getfName(), equalTo("Gurudath"));
		
	}
	
	@Test
	public void testGetEmployeesFromEmptyDB() {
		
		doReturn(new ArrayList<Employee>()).when(employeeRepo).findAll();
		
		List<Employee> employees = employeeService.getEmployees(false);
		
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
