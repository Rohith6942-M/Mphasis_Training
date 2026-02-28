package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Employee;
import com.test.exception.EmployeeNotFoundException;
import com.test.repository.EmployeeRepository;
import com.test.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/employee/v1/api")
@Tag(name = "EMPLOYEE CRUD OPERATIONS")
public class EmployeeController {


	@Autowired
	private EmployeeService bookService;
	
	@Autowired
	private EmployeeRepository repository;
	
	@PostMapping(value = "/create")
	@Operation(summary = "CREATE EMPLOYEE LIST")
	public ResponseEntity<Employee> createBook(@RequestBody Employee emp )
	{
		Employee ep = bookService.saveEmployee(emp);
		if(ep != null)
		{
			return new ResponseEntity<>(ep, HttpStatus.CREATED);
		}
		else
		{
			return new ResponseEntity<>(ep, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(value = "/list")
	@Operation(summary = "LIST ALL EMPLOYEE")
	public ResponseEntity<List<Employee>> listAllEmployee()
	{
		List<Employee> list = bookService.getAllEmployee();
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/{id}")
	@Operation(summary = "SEARCH EMPLOYEE LIST")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable int id)
	{
		Optional<Employee> bk = bookService.getEmployeeById(id);
		if(bk != null)
		{
			return new ResponseEntity<>(bk, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(bk, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}")
	@Operation(summary = "UPDATE LIST")
	public ResponseEntity<Employee> updateBookById(@PathVariable int id, @RequestBody Employee emp)
	{
		emp.setId(id);
		Employee bk = bookService.updateEmployee(emp);
		if(bk != null)
		{
			return new ResponseEntity<>(bk, HttpStatus.ACCEPTED);
		}
		else
		{
			//return new ResponseEntity<>(bk, HttpStatus.NOT_FOUND);
			throw new EmployeeNotFoundException("NO_CONTENT_FOR_GIVEN_REQUEST");
		}
	}
	
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "DELETE EMPLOYEE IN LIST")
	public ResponseEntity<List<Employee>> deleteBookById(@PathVariable int id)
	{
		List<Employee> list = bookService.deleteEmployeeById(id);
		if(list != null)
		{
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/byname/{name}")
	@Operation(summary = "GET EMPLOYEE BY NAME")
	public ResponseEntity<List<Employee>> getEmployeeByName(@PathVariable String name)
	{
		List<Employee> eobj = repository.getEmployeeByName(name);
		if(eobj.size() > 0)
		{
			return new ResponseEntity<>(eobj, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(eobj, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/bycompany/{company}")
	@Operation(summary = "GET EMPLOYEE BY COMPANY")
	public ResponseEntity<List<Employee>> getEmployeeByCompany(@PathVariable String company)
	{
		List<Employee> list = repository.getEmployeeByCompany(company);
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/emplist/asc")
	@Operation(summary = "employees list sorted in ascending order")
	public ResponseEntity<List<Employee>> getEmployeeASC()
	{
		List<Employee> list = repository.getAllEmployeeASC();
		if(list.size() > 0)
		{
			return new ResponseEntity<>(list, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		}
	}
}
