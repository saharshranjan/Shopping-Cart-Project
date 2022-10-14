package com.deloitte.myntraproduct.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.myntraproduct.entity.Product;
import com.deloitte.myntraproduct.repo.ProductRepo;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Product>> getProduct(){
		return new ResponseEntity<List<Product>>(productRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{productId}")
	public ResponseEntity<List<Product>> getProductsById(@PathVariable int productId) {
		return new ResponseEntity<List<Product>>(productRepo.getAllProductsBasedOnProductId(productId), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productRepo.save(product), HttpStatus.OK);
	}
}
