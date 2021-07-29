package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repositry.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	// save product
	public Product saveProduct(Product product) {
		Product dbproduct = productRepo.save(product);
		return dbproduct;
	}

	// fetch all record
	public List<Product> fetchAllProduct() {
		return (List<Product>) productRepo.findAll();
	}

	// fetch product using id
	public Product fetchProductInformation(Integer id) {
		Optional<Product> optinal = productRepo.findById(id);

		if (optinal.isPresent()) {
			Product dbproduct = optinal.get();
			return dbproduct;

		} else {
			System.out.println("Product not available");
		}
		return null;
	}

	// updating specific record using pk
	public Product updateProduct(Integer id, Product product) {

		// here reused above method check record found or not
		Product dbproduct = fetchProductInformation(id);

		if (dbproduct != null) {
			dbproduct.setProductName(product.getProductName());
			dbproduct.setProductDescription(product.getProductName());
			dbproduct.setPrice(product.getPrice());

			return productRepo.save(dbproduct);
			
		} else {
			System.out.println("Product is not available");
		}
		return null;
	}
	
	
	//delete record using pk
      public void deleteProduct(Integer id)
      {
    	  Product dbproduct=fetchProductInformation(id);
    	  
    	  if (dbproduct!=null) {
				productRepo.delete(dbproduct);
		}
      }
}
