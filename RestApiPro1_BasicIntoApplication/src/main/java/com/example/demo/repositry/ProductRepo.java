package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
