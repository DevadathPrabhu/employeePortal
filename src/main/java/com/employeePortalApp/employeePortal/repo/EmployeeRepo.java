package com.employeePortalApp.employeePortal.repo;

import org.springframework.data.repository.CrudRepository;

import com.employeePortalApp.employeePortal.entity.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer>{

}
