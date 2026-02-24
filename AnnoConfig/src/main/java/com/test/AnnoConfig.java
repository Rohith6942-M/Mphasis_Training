package com.test;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configurable
public class AnnoConfig {
	
	@Bean
	@Qualifier("bdobj")
	@Scope(value="singleton", proxyMode = ScopedProxyMode.DEFAULT)
	public BookDetails getBookDt()
	{
		return new BookDetails();
	}
	@Bean
	public Book getBook()
	{
		return new Book();
	}
}
