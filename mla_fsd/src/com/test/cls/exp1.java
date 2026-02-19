package com.test.cls;

import java.util.ArrayList;
import java.util.ListIterator;
//import java.util.List;
//import java.util.Collection;

public class exp1 {
	
	public static void main(String args[])
	{
		ArrayList data = new ArrayList();
		data.add(200);
		data.add('a');
		data.add("java");
		data.add(false);
		data.add(33.33f);
		data.add(345l);
		ListIterator ltr = data.listIterator();
		while(ltr.hasNext())
		{
			System.out.println(ltr.next());
		}
		System.out.println();
		while(ltr.hasPrevious())
		{
			System.out.println(ltr.previous());
		}
		/*for(String d: data)
		*{
		*	System.out.println(d);
		*/}
	}
