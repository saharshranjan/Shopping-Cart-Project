package com.deloitte.myntraproduct.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cart")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cart {
	@Id
	@Column(name="unameAndId")
	private String unameAndId;
	@Column(name="username")
	private String username;
    @Column(name = "productId")
    private int productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productPrice")
    private int productPrice;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String username, int productId, String productName, int productPrice) {
		super();
		this.unameAndId = username + productId;
		this.username = username;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getUnameAndId() {
		return unameAndId;
	}
}
    