package com.project.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.backend.entities.ShoppingCart;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer>{

}
