package com.project.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.project.backend.entities.Product;
import com.project.backend.repo.ProductRepo;

public class ProductServiceImpl implements IProductService {
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
	//imp all product img here
	@Override
	public List<Product> findAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product showByName(String name) {
		Product product = productRepo.findByName(name);
		return product;
		//List of all product may be returned
	}

	@Override
	public Product addProductWithImg(Product product, MultipartFile file, String imgName) throws IOException {
		String imageUUID;
        if (!file.isEmpty()) {
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;
        }
        product.setImgName(imageUUID);
		return productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
//		Optional<Product> updatedProduct = productRepo.findById(product.getId());
//		if(updatedProduct.isPresent()) {
//			Product p =new Product();
//			p.setId(product.getId());
//		}
		Optional<Product> p=productRepo.findById(product.getId());
        if(p.get()!=null) {
            Product updated = modelMapper.map(product, Product.class);
            return productRepo.save(updated);
        }
        return null;
		

	}

	@Override
	public Product deleteByName(String name) {
		Product product = productRepo.findByName(name);
		productRepo.delete(product);
		return product; 
	}

}
