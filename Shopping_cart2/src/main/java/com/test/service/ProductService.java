package com.test.service;
 
//import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.test.entity.Products;
import com.test.repository.ProductRepository;
import com.test.repository.UserRepository;
 
@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private UserRepository repo;
	public void save(Products product)
	{
		repository.save(product);
	}
	public List<Products> listAll()
	{
		return repository.findAll();
	}
	public Products get(int id)
	{
		return repository.findById(id).get();
	}
	public void delete(int id)
	{
		repository.deleteById(id);
	}
	public boolean Validate(String username, String password) {
		
		return repo.existsByUsernameAndPassword(username, password);
	}
	public double adder() {
	    return listAll().stream()
	                    .mapToDouble(Products::getPrice)
	                    .sum();
	}
}