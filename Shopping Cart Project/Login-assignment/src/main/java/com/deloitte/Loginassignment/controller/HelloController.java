package com.deloitte.Loginassignment.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/*public class HelloController {

	@GetMapping("/welcome")
	public String hello() {
		return "Welcome!";
	}
}*/
@RestController
public class HelloController{
	
@Autowired
RestTemplate restTemplate;



@GetMapping(value = "/getProducts")
public List<Object> getProducts() {
    Object objects = restTemplate.getForObject("http://product-service/product/getAll", Object.class);
    return Arrays.asList(objects);

}

@GetMapping(value = "/getcart/{username}")
public List<Object> getCart(@PathVariable String username) {
    Object objects = restTemplate.getForObject("http://product-service/Cart/get/"+username, Object.class);
    return Arrays.asList(objects);

}


@Configuration
class config{

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
}
    