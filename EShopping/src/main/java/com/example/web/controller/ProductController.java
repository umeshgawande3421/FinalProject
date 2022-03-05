package com.example.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.web.model.Product;
import com.example.web.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repository;

	@GetMapping("/allProducts")
	public String viewHomePage(Model model) {
		try {
		List<Product> listProducts = repository.findAll();
		model.addAttribute("listProducts", listProducts);
		return "admin_AllProducts";
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@GetMapping("/new")
	public String showNew(Model model) {
		try {
		Product product = new Product();
		model.addAttribute("product", product);
		return "admin_new_product";
		}catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		try {
		repository.save(product);
		return "redirect:/allProducts";
		}catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

	@GetMapping("/editProducts/{id}")
	public String showEditProductPage(@PathVariable("id") Long id, Model model) {
		Product product = repository.getById(id);
		model.addAttribute("product", product);
		return "admin_editProduct";
	}

	@PostMapping("/updateProducts/{id}")
	public String updateProducts(@PathVariable("id") Long id, @Valid Product product, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			product.setProductId(id);
			return "admin_editProduct";
		}

		repository.save(product);
		model.addAttribute("students", repository.findAll());
		return "redirect:/allProducts";
	}

	@GetMapping("/deleteProducts/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		try {
		repository.deleteById(id);
		return "redirect:/allProducts";
		}catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
			 return "Something went wrong";
		}
	}

//	@GetMapping("/")
//    public String viewHomePage(Model model, @Param("keyword") String keyword) {
//        List<Product> listProducts = serviceImpl.listAll(keyword);
//        model.addAttribute("listProducts", listProducts);
//        model.addAttribute("keyword", keyword);
//        return "redirect:/usersback";
//    }

}

//@GetMapping("/editProducts/{id}")
//public ModelAndView showEditProductPage(@PathVariable("id") String id) {
//	ModelAndView mav = new ModelAndView("edit_product");
//	Product product = repository.getById(id);
//	mav.addObject("product", product);
//	return mav;
//}

//
//@PostMapping("newProduct")
//  public String addStudent(@Valid Product product, BindingResult result, Model model) {
//      if (result.hasErrors()) {
//          return "AdminProductEditForm";
//      }
//
//      serviceImpl.addProduct(product);
//      return "redirect:adminProducts";
//  }