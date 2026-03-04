package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product2")
public class Product2Controller {
	
	@GetMapping("/service2")
	public String productService2()
	{
		return "This is product2 page";
	}
}
