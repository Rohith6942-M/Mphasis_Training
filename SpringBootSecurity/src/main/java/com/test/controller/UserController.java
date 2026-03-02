package com.test.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableMethodSecurity
public class UserController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping("/read")
	//@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_HR','ROLE_EMPLOYEE')")
	public String userPage() {
		return "read";
	}

	@GetMapping("/delete")
	//@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String adminPage() {
		return "delete";
	}

	@GetMapping("/update")
	//@ResponseBody
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_HR')")
	public String updateUsers() {
		return "update";
	}

}
