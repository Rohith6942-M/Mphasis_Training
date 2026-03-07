package com.test.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.test.entity.Products;
import com.test.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/")
	public String login()
	{
		return "login";
	}
	
	@GetMapping("/index") // GetMapping
	public String viewHomePage(Model model, Products product) {

		List<Products> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		double totalCost = service.adder(); // adjust if adder needs parameters
	    model.addAttribute("totalCost", totalCost);
	    Products highest = listProducts.stream()
                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .orElse(null);

	    Products lowest = listProducts.stream()
               .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
               .orElse(null);

	    model.addAttribute("highestProduct", highest);
	    model.addAttribute("lowestProduct", lowest);
		return "index";

	}
	
//	@GetMapping("/login")
//	public String loginPage(@RequestParam(required = false) String error, Model model) {
//	    if (error != null) {
//	        model.addAttribute("errorMessage", "Invalid username or password");
//	    }
//	    return "login";
//	}

	@GetMapping("/new")
	public String showNewProductForm(Model model) {

		Products product = new Products();
		model.addAttribute("product", product);
		return "new_product";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Products product) {

		service.save(product);
		return "redirect:/index";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable Integer id) {

		ModelAndView mav = new ModelAndView("edit_product");
		Products product = service.get(id);
		mav.addObject("product", product);
		return mav;
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {

		service.delete(id);
		return "redirect:/index";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam String username,
	                           @RequestParam String password,
	                           Model model) {
		
	    if (service.Validate(username, password)) {
	        List<Products> listProducts = service.listAll();
	        model.addAttribute("listProducts", listProducts);
	        double totalCost = service.adder(); // adjust if adder needs parameters
		    model.addAttribute("totalCost", totalCost);
		    Products highest = listProducts.stream()
	                .max((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
	                .orElse(null);

		    Products lowest = listProducts.stream()
	               .min((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
	               .orElse(null);

		    model.addAttribute("highestProduct", highest);
		    model.addAttribute("lowestProduct", lowest);
	        return "index";
	    } else {
	    	//return "redirect:/login?error";
	    	model.addAttribute("errorMessage", "Invalid username or password");
	    	return "login";
	    }
	}
	
	@GetMapping("/error")
	public String error()
	{
		return "error";
	}
	
	@PostMapping("/logout")
	public String logout()
	{
		return "/login";
	}

}
