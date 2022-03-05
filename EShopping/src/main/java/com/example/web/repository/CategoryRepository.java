package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.web.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{

}