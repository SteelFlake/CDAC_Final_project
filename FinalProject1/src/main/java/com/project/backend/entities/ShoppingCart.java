package com.project.backend.entities;

import javax.persistence.*;

import lombok.Data;

import java.util.Collection;
@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "owner")
    private String owner;
  //  @Column(name="product")
    @ElementCollection(targetClass=Product.class)
    Collection<Product> products;
}