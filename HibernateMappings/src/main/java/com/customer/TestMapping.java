package com.customer;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMapping {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Order o1 = new Order();
		o1.setO_name("charger");
		o1.setO_price(10);
		
		Order o2 = new Order();
		o2.setO_name("dongle");
		o2.setO_price(4);
		
		List<Order> listOrder = Arrays.asList(o1, o2);
		User uobj = new User();
		
		uobj.setU_name("Rohit");
		uobj.setOrders(listOrder);
		
		session.persist(uobj);
		t.commit();
		session.close();

	}

}
