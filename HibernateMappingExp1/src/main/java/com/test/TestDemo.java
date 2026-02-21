package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Address adr = new Address();
		adr.setCity("bengaluru");
		adr.setState("KA");
		
		Employee emp = new Employee();
		emp.setE_name("rohit");
		emp.setE_cmp("Mphasis");
		
		emp.setAddress(adr);
		adr.setEmployee(emp);
		session.persist(emp);
		t.commit();
		session.close();
		
	}

}
