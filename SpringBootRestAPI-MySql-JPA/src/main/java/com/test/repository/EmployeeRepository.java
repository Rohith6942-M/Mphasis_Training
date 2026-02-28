package com.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.test.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//both methods are same but using different ways of coding
//	@Query("select e from Employee e where e.name = ?1")
//	List<Employee> getEmployeeByName(String name);
//	
//	@Query("select e from Employee e where e.company = ?1")
//	List<Employee> getEmployeeByCompany(String company);
	
	@Query("select e from Employee e where e.name = :name")
	List<Employee> getEmployeeByName(@Param("name")String name);
	
	@Query("select e from Employee e where e.company = :company")
	List<Employee> getEmployeeByCompany(@Param("company")String company);
	
	@Query("select e from Employee e order by e.name ASC")
	List<Employee> getAllEmployeeASC();
	
	
}
