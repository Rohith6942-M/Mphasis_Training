package com.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class StoreData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Book obj = new Book();
		obj.setB_name("Java");
		obj.setB_author("Sun MicroSystems");
		obj.setB_price(500);
		session.persist(obj);
		t.commit();
		Query<Book> q = session.createQuery("from Book");
		List<Book> list = q.list();
		for(Book b : list)
		{
			System.out.println(b.getId()+" "+b.getB_name()+" "+b.getB_author()+" "+b.getB_price());
		}
		// -- To retrive the specific data and insertion of data --
		/*Book dt = session.get(Book.class, 1);
		System.out.println(dt.getId()+" "+dt.getB_name()+" "+dt.getB_author()+" "+dt.getB_price());
		session.remove(dt);
		dt.setB_name("Land of spice");
		dt.setB_author("robert");
		dt.setB_price(230);
		t.commit();*/
		System.out.println("Done.");
		
	}

}
