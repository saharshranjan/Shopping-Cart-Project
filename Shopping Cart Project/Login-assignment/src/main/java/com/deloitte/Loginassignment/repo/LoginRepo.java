package com.deloitte.Loginassignment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.Loginassignment.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long>{
	Boolean existsByEmail(String email);
	Optional<Login> findByEmail(String email);
}
