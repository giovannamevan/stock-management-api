package com.management.stock.API.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.management.stock.API.DTOs.ProductDTO;
import com.management.stock.API.DTOs.ProductUpdateDTO;
import com.management.stock.API.entities.Product;
import com.management.stock.API.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Transactional
	public void saveNewProduct (ProductDTO productDTO) {
		 productRepository.save(new Product(productDTO));
	}
	@Transactional
	public void updateProduct(ProductUpdateDTO dto) {
		 var product = productRepository.getReferenceById(dto.getProductCode());
		 product.updateProduct(dto);
	}
	@Transactional
	public void deleteProduct(String code) {
		  productRepository.deleteById(code);
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
	public List<ProductDTO> findProductsByCategory (String cat){
		   List<Product> result = productRepository.findProductsByCategory(cat);
		   return result.stream().map(x -> new ProductDTO(x)).toList();
	}
}
