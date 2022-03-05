package com.example.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.model.Category;
import com.example.web.serviceimpl.CategoryServiceImpl;


@RestController
@RequestMapping("/category")
public class CategoryRestController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping("/")
	public List<Category> displayDataCategory()
	{
		return categoryServiceImpl.viewAllCategory();
	}
	
	@PostMapping("/")
	public Category addDataCategory(@RequestBody Category category)
	{
		return categoryServiceImpl.addCategory(category);
	}
	
	@PutMapping("/")
	public Category updateDataCategory(@RequestBody Category category)
	{
		return categoryServiceImpl.updtateCategory(category);
    }
	
	@DeleteMapping("/")
	public String removeDataCategory(@RequestBody Category category)
	{
		categoryServiceImpl.removeCategory(category);
		return "deleted Successfully";
	}

}
