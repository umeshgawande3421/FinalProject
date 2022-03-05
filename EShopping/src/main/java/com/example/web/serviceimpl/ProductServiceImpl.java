package com.example.web.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.model.Product;
import com.example.web.repository.ProductRepository;
import com.example.web.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> viewAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getByIdProduct(Long productId) {
		// TODO Auto-generated method stub
		return productRepository.findById(productId);
	}

//	@Override
//	public Product viewProductByCategory(String name) {
//		// TODO Auto-generated method stub
//		return productRepository.getOne(name);
//	}

	@Override
	public String removeProduct(Long productId) {
		// TODO Auto-generated method stub
		productRepository.deleteById(productId);
		;
		return "Deleted";
	}
	
	public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return productRepository.search(keyword);
        }
        return productRepository.findAll();
    }

}
