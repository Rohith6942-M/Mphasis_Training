package com.test.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.test.entity.Product;
import com.test.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/") // GetMapping
	public String viewHomePage(Model model) {

		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		return "index";

	}

	@GetMapping("/login")
	public String loginPage()
	{
		return "login";
	}

	@GetMapping("/new")
	public String showNewProductForm(Model model) {

		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product) {

		service.save(product);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable Integer id) {

		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {

		service.delete(id);
		return "redirect:/";
	}
}
