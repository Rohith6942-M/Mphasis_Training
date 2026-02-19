package com.test;

import java.util.List;
import java.util.Scanner;

public class TestDemo2 {

	public static void main(String[] args) {
		
		StudentDao sdao = new StudentDao();
		Student st = new Student();
		Scanner in = new Scanner(System.in);
		
		/*  --- TO INSERT THE VALUES INTO TABLE --- */
		System.out.println("Enter student's name");
		String name = in.nextLine();
		st.setName(name);
		System.out.println("Enter student's Id");
		int id = in.nextInt();
		in.nextLine();
		st.setId(id);
		System.out.println("Enter student's college");
		String company = in.nextLine();
		st.setClg(company);
		System.out.println("Enter student's city");
		String city = in.nextLine();
		st.setCity(city);
		sdao.saveStudent(st);/**/
		
		/*  --- TO UPDATE THE VALUES INTO TABLE ---
		System.out.println("Enter the employee's id to update the data");
		int id1 = in.nextInt();
		in.nextLine();
		st.setId(id1);
		System.out.println("Enter employee's update name");
		String name1 = in.nextLine();
		st.setName(name1);
		System.out.println("Enter employee's company");
		String company1 = in.nextLine();
		st.setClg(company1);
		System.out.println("Enter employee's city");
		String city1 = in.nextLine();
		st.setCity(city1);
		sdao.updateStudent(st);*/
		System.out.println("Saved Student Details");
		List<Student> data = sdao.getAllStudents();
		data.forEach(System.out::println);
		in.close();

	}

}
