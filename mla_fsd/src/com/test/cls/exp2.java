package com.test.cls;

import java.util.LinkedHashMap;

//import java.util.;

public class exp2 {
	
	public static void main(String args[])
	{
		LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
		data.put("sony", 500);
		data.put("panasonic", 400);
		data.put("LG", 450);
		data.put("Samsung", 550);
		data.put("dell", 100);
		data.put(null, 11);
		
		data.forEach((k,v) -> System.out.println(k+" : "+v));
		System.out.println(data.get("sony"));
	}

}
