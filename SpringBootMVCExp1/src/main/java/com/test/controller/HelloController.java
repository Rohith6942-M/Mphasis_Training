package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.model.user;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloController {
	
	@RequestMapping
	public String homepage()
	{
		return "welcome";
	}
	
	@RequestMapping("/user")
	public String userForm()
	{
		return "userform";
	}
	
	@RequestMapping("/submit")
	public String submitUserData(HttpServletRequest request, user uobj, Model model)
	{
		String user = request.getParameter("username");
		String pas = request.getParameter("password");
		uobj.setUsername(user);
		uobj.setPassword(pas);
		model.addAttribute("info",uobj);
		if(user.equals("admin") && pas.equals("java"))
		{
			return "success";
		}
		else {
			return "userform";
		}
	}
}
