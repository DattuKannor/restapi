package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	private String productName;
	private String productDescription;

	private Double price;

	@CreationTimestamp
	private Date createdDate;

	@UpdateTimestamp
	private Date updatetime;

	public Product() {
		super();
	}

	public Product(String productName, String productDescription, Double price, Date createdDate, Date updatetime) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.createdDate = createdDate;
		this.updatetime = updatetime;
	}

	public Product(Integer productId, String productName, String productDescription, Double price, Date createdDate,
			Date updatetime) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.price = price;
		this.createdDate = createdDate;
		this.updatetime = updatetime;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	

}
