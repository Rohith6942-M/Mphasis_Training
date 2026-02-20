package com.test;

import java.util.List;

public class CustDemo {
	
	public static void main(String[] args) {
		
		CustDoa cdao = new CustDoa();
		Customer cst = new Customer();
		cst.setC_id(2);
		cst.setC_name("SKY");
		cst.setC_city("mumbai");
		cdao.deleteCustomer(cst);
		//cdao.updateCustomer(cst);
		//cdao.saveCustomer(cst);
		//List<Customer> list = cdao.getAllCustomers();
		//list.forEach(System.out::println);
	}

}
