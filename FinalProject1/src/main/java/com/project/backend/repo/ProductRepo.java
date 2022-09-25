 package com.project.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
