package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class CustDoa {
	
	public static SessionFactory getDBSession()
	{
		SessionFactory sf = null;
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			sf = cfg.buildSessionFactory();
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sf;
	}
	public void saveCustomer(Customer cst)
	{
		Session session = CustDoa.getDBSession().openSession();
		Transaction t = session.beginTransaction();
		session.persist(cst);
		t.commit();
	}
	public List<Customer> getAllCustomers()
	{
		//List<Customer> list = new ArrayList<>();
		Session session = CustDoa.getDBSession().openSession();
		Query<Customer> q = session.createQuery("from Customer");
		List<Customer> list = q.list();
		session.close();
		return list;
	}
	public void updateCustomer(Customer cst)
	{
		Session session = CustDoa.getDBSession().openSession();
		Transaction t = session.beginTransaction();
		Customer obj = session.find(Customer.class, cst.getC_id());
		obj.setC_name(cst.getC_name());
		obj.setC_city(cst.getC_city());
		session.persist(obj);
		t.commit();
		session.close();
	}
	
	public void deleteCustomer(Customer cst)
	{
		Session session = CustDoa.getDBSession().openSession();
		Customer obj = session.find(Customer.class, cst.getC_id()); 
		session.remove(obj);
		session.beginTransaction().commit();
		session.close();
	}
}
