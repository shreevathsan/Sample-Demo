package com.employee.Service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Entity.Employee;
import com.employee.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee saveEmployee(Employee employee) {
		logger.info("About to save the Employee ::" + employee.getFirstName() + "" + employee.getLastName());
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {

		logger.info("About to get the Employee List ::");
		return employeeRepository.findAll();

	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee updateEmployee(Integer id, String firstName) {

		logger.info("About to update the employee firstName ::");

		// updating the firstName of the employee
		employeeRepository.updateEmployee(id, firstName);

		// getting the updated employee from the Database
		return employeeRepository.getById(id);

	}

	@SuppressWarnings("deprecation")
	@Override
	public String deleteEmployee(Integer id) {

		logger.info("About to delete the employee for id ::" + id);

		// deleting the record in the DataBase
		employeeRepository.deleteById(id);

		// validating whether the record has been deleted or not
		Employee employee = employeeRepository.getById(id);

		if (null != employee) {
			return "Employee Deleted Successfully";
		}

		return "Employee not deleted. please try again later";

	}

}
