package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.model.Employee;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {
	
	@GetMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@GetMapping("/login")
	public String userForm(Model model, Employee user)
	{
		model.addAttribute("info", user);
		return "login";
	}
	
	@PostMapping("/submituser")
	public String submitUserForm(
			@Valid
			@ModelAttribute("info") Employee user,
			BindingResult result)
	{
		if(result.hasErrors())
		{
			return "login";
		}
		else
		{
			return "success";
		}
	}
}
