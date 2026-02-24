package com.test;

import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class cstDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		//Customer obj = ctx.getBean("cst1", Customer.class);
		//System.out.println(obj);
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AnnoConfig.class);
		Address obj1 = ctx.getBean(AnnoConfig.getAddress().getClass());
		obj1.setCity("tirumala");
		obj1.setState("AP");
		obj1.setCountry("IN");
		List <Address> list = new ArrayList<>();
		list.add(obj1);
		Customer cst = ctx.getBean(Customer.class);
		cst.setId(134);
		cst.setName("rohit");
		System.out.println(cst);
		Address obj2 = ctx.getBean(AnnoConfig.getAddress1().getClass());
		obj2.setCity("sabarimala");
		obj2.setState("KL");
		obj2.setCountry("IN");
		
		cst = ctx.getBean(Customer.class);
		cst.setId(221);
		cst.setName("SKY");
		list.add(obj2);
		
		cst.setAdr(list);
		System.out.println(cst);
	}

}
