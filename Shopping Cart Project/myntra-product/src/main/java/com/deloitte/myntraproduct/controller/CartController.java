package com.deloitte.myntraproduct.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.myntraproduct.entity.Cart;
import com.deloitte.myntraproduct.entity.Product;
import com.deloitte.myntraproduct.repo.CartRepo;
import com.deloitte.myntraproduct.repo.ProductRepo;


@RestController
@RequestMapping("/Cart")
public class CartController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CartRepo cartRepo;
	
	@Autowired
	ProductRepo productRepo;
	
	@PostMapping("/add/{username}/{productId}")
    public ResponseEntity<Product> addCart(@PathVariable String username, @PathVariable int productId){
		Product prod = cartRepo.getProductDetails(productId);
		String productName = prod.getProductName();
		int productPrice = prod.getProductPrice();
		Cart cart = new Cart(username, productId, productName, productPrice);
        cartRepo.save(cart);
        return new ResponseEntity<Product>(cartRepo.getProductDetails(productId), HttpStatus.OK);
    }
	
	@GetMapping("/get/{username}")
	public ResponseEntity<List<Cart>> getProductsByUsername(@PathVariable String username) {
		return new ResponseEntity<List<Cart>>(cartRepo.getAllProductsBasedOnUsername(username), HttpStatus.OK);
	}


	
	//Cart(String username, int productId, String productName, int productPrice)

	@Configuration
	class config {

		@Bean
		@LoadBalanced
		public RestTemplate restTemplate() {
			return new RestTemplate();
		}
	}

}
