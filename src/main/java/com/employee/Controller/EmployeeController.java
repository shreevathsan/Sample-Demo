package com.employee.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Entity.Employee;
import com.employee.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);

	@PostMapping(value = "/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {

		ResponseEntity<Employee> response;

		logger.info("Request Received from the user to save the employee details for name :: {}"
				+ employee.getFirstName() + "" + employee.getLastName());

		// calling the service layer for saving the employee
		Employee employeeResponse = employeeService.saveEmployee(employee);

		response = new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);

		return response;

	}

	@GetMapping("/getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		ResponseEntity<List<Employee>> response;

		logger.info("Got the request from the User to get Employee List :::");

		// calling the service layer for getting all employees in DB
		List<Employee> employeeList = employeeService.getAllEmployees();

		response = new ResponseEntity<>(employeeList, HttpStatus.CREATED);

		return response;

	}

	@PatchMapping("/update/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer employeeId, @RequestBody Employee employee) {

		ResponseEntity<Employee> response;

		logger.info("Got the request from the User to Update Employee firstName for id :::" + employeeId);

		// calling the service layer for updating the fristName for the given employeeId
		Employee employeeResponse = employeeService.updateEmployee(employeeId, employee.getFirstName());

		response = new ResponseEntity<>(employeeResponse, HttpStatus.CREATED);

		return response;

	}

	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {

		ResponseEntity<String> response;

		logger.info("Got the request from the User delete the user for the id :::" + id);

		// calling the service layer for updating the fristName for the given employeeId
		String functionResponse = employeeService.deleteEmployee(id);

		response = new ResponseEntity<>(functionResponse, HttpStatus.CREATED);

		return response;

	}

}
