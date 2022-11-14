package com.employee.Service;

import java.util.List;

import com.employee.Entity.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee updateEmployee(Integer id, String firstName);

	public String deleteEmployee(Integer id);

}
