package com.example.web.service;

import java.util.List;

import com.example.web.model.Category;

public interface CategoryService {
	
	public List<Category> viewAllCategory();
	public Category addCategory(Category category);
	public Category updtateCategory(Category category);
	public String removeCategory(Category category);

}