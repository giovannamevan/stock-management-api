package com.management.stock.API.services;


import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.management.stock.API.DTOs.ProductDTO;
import com.management.stock.API.entities.Product;
import com.management.stock.API.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	public void saveNewProduct (ProductDTO productDTO) {
		 productRepository.save(new Product(productDTO));
	}
	
	public List<ProductDTO> findAllProducts (){
		   List<Product> result = productRepository.findAll();
		   return result.stream().map(x -> new ProductDTO(x)).toList();
	}
	
	public List<ProductDTO> findProductsByName(String name) {
		   List<Product> result = productRepository.findProductByName(name);
		   return result.stream().map(x -> new ProductDTO(x)).toList();
	}

	public List<ProductDTO> allProductsOrderedByExDate(){
		   List<Product> result = productRepository.AllProductsOrderedByExDate();
		   return result.stream().map(x -> new ProductDTO(x)).toList();
	}
}
