package com.project.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.backend.entities.Product;
import com.project.backend.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	// private ProductDAO productDAO;
	private IProductService productService;

	@GetMapping("/")
	// Enable CORS on port 3000
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<Product>> showAll() {

		return new ResponseEntity<>(productService.findAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<Product> showByName(@PathVariable String name) {
		Product product = productService.showByName(name);

		if (product == null)
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> add(@RequestBody Product product, 			@RequestParam("productImage") MultipartFile file,
			@RequestParam("imgName") String imgName) throws IOException {
		Product productAdded= productService.addProductWithImg(product,file,imgName);

		return new ResponseEntity<>("Successfully added " + productAdded.getName(), HttpStatus.OK);
	}

	@PostMapping("/update")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> update(@RequestBody Product product) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Item is being edited by" + userDetails.getUsername());
		Product updatedProduct = productService.updateProduct(product);
		return new ResponseEntity<>("Successfully added " + updatedProduct.getName(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{name}")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<String> delete(@PathVariable String name) {
		//Product product = productDAO.findByName(name);
		Product product =  productService.deleteByName(name);
		if (product == null)
			return new ResponseEntity<>("No user found to delete", HttpStatus.NOT_FOUND);		
		return new ResponseEntity<>("Sucessfully deleted " + name, HttpStatus.OK);
	}

}
