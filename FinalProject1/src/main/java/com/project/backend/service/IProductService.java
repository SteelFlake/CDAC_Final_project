package com.project.backend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.backend.entities.Product;

public interface IProductService {

	List<Product> findAllProduct();

	Product showByName(String name);

	Product addProductWithImg(Product product, MultipartFile file, String imgName) throws IOException;

	Product updateProduct(Product product);

	Product deleteByName(String name);

}
