package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class TestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		Student std = ctx.getBean("std", Student.class);
		System.out.println(std);
		ExpressionParser exp = new SpelExpressionParser();
		Expression ex = exp.parseExpression("'CODERS'");
		String dt = ex.getValue(String.class);
		System.out.println(dt+" literals ");
		Expression ex1 = exp.parseExpression("'Spring'".toUpperCase());
		String su = ex1.getValue(String.class);
		System.out.println(su+" whatuppppp!!!! yooo");
		Expression ex3 = exp.parseExpression("100*5");
		Integer v1 = ex3.getValue(Integer.class);
		System.out.println(v1);
	}

}
