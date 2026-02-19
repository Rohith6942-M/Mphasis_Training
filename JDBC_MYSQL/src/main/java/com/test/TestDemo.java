package com.test;

import java.util.List;
import java.util.Scanner;

public class TestDemo {

	public static void main(String[] args) {
		
		EmpDao edao = new EmpDao();
		Employee emp1 = new Employee();
		Scanner in = new Scanner(System.in);
		
		/*  --- TO INSERT THE VALUES INTO TABLE ---
		System.out.println("Enter employee's name");
		String name = in.nextLine();
		emp1.setName(name);
		System.out.println("Enter employee's Id");
		int id = in.nextInt();
		in.nextLine();
		emp1.setId(id);
		System.out.println("Enter employee's company");
		String company = in.nextLine();
		emp1.setCmp(company);
		System.out.println("Enter employee's city");
		String city = in.nextLine();
		emp1.setCity(city);
		edao.saveEmployee(emp1);*/
		
		//  --- TO UPDATE THE VALUES INTO TABLE ---
		System.out.println("Enter the employee's id to update the data");
		int id1 = in.nextInt();
		in.nextLine();
		emp1.setId(id1);
		System.out.println("Enter employee's update name");
		String name1 = in.nextLine();
		emp1.setName(name1);
		System.out.println("Enter employee's company");
		String company1 = in.nextLine();
		emp1.setCmp(company1);
		System.out.println("Enter employee's city");
		String city1 = in.nextLine();
		emp1.setCity(city1);
		edao.updateEmployee(emp1);
		System.out.println("Saved Employee Details");
		List<Employee> data = edao.getAllEmployees();
		data.forEach(System.out::println);
		in.close();

	}

}
