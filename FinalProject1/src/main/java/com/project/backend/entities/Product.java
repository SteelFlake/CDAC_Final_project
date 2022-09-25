package com.project.backend.entities;

import javax.persistence.*;

import lombok.Data;
@Data
@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
   
    private String name;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private Integer price;

    @Column(name="type")
    private String type;

    @Column(name="details")
    private String details;
    
    
    private String imgName;

    
}