package com.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		BookDetails b1 = ctx.getBean(BookDetails.class);
		System.out.println(b1);
		Book b2 = ctx.getBean(Book.class);
		b1.setPages(2200);
		b1.setPublisher("MLA");
		b1.setP_year(2026);
		
		List<BookDetails> list = new ArrayList<>();
		list.add(b1);
		
		b2.setId(201);
		b2.setName("Spring notes");
		b2.setAuthor("Arjun");
		b2.setPrice(5);
		b2.setBd(list);
		System.out.println(b2);
	}

}
