package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.web.model.User;

public interface AdminRepository extends JpaRepository<User, Long>{

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
}
