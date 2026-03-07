package com.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Integer> {

}
