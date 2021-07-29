package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productservice;

	// @RequestBody : read data UI to controller
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productservice.saveProduct(product);
	}

	@GetMapping
	public List<Product> retriveProducts() {
		return productservice.fetchAllProduct();
	}

	@PutMapping("/{productId}")
	public Product updateProduct(@PathVariable("productId") Integer id, @RequestBody Product product) {
		return productservice.updateProduct(id, product);
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") Integer id) {
		productservice.deleteProduct(id);
	}
}
