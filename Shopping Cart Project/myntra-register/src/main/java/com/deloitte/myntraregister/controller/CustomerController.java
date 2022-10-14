package com.deloitte.myntraregister.controller;

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

import com.deloitte.myntraregister.entity.Customer;
import com.deloitte.myntraregister.repo.CustomerRepo;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepo customerRepo;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Customer>> getCustomer(){
		return new ResponseEntity<List<Customer>>(customerRepo.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/get/{username}")
	public ResponseEntity<List<Customer>> getEmployees(@PathVariable String username) {
		return new ResponseEntity<List<Customer>>(customerRepo.getAllCustomersBasedOnUsername(username), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Customer> addEmployee(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerRepo.save(customer), HttpStatus.OK);
	}

}
