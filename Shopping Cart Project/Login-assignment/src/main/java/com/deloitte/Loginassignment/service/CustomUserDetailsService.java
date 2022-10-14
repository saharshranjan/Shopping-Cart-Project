package com.deloitte.Loginassignment.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deloitte.Loginassignment.model.Login;
import com.deloitte.Loginassignment.repo.LoginRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private LoginRepo loginRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Login existingUser = loginRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		
		return new org.springframework.security.core.userdetails.User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
	}
}
