package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		Product saveProduct = productservice.saveProduct(product);
		// return new ResponseEntity<Product>(HttpStatus.OK); //only show status code
		return new ResponseEntity<Product>(saveProduct, HttpStatus.OK); // status code with return josn object
	}

	@GetMapping
	public List<Product> retriveProducts() {
		return productservice.fetchAllProduct();
	}

	@PutMapping("/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") Integer id, @RequestBody Product product) {
		productservice.updateProduct(id, product);

		return new ResponseEntity<String>("Record update", HttpStatus.OK); // string message with status code
	}

	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") Integer id) {
		productservice.deleteProduct(id);
	}

	// fetch single record using id
	@GetMapping("/{productId}")
	public ResponseEntity<Object> getProduct(@PathVariable("productId") Integer id) {
		Product fetchProductInformation = productservice.fetchProductInformation(id);

		if (id <= 0) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		} else {

			if (fetchProductInformation != null) {
				return new ResponseEntity<Object>(fetchProductInformation, HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>("Product not exist in our database", HttpStatus.NO_CONTENT);
			}
		}

	}
}
