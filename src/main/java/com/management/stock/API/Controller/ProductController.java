package com.management.stock.API.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.management.stock.API.DTOs.ProductDTO;
import com.management.stock.API.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
		@Autowired
		ProductService productService;
		
		@PostMapping
		public void saveNewProduct (@RequestBody ProductDTO productDTO) {
			productService.saveNewProduct(productDTO);
		}
		
		@GetMapping(value = "/all") 
		public List<ProductDTO> findAllProducts (){
			List<ProductDTO> result = productService.findAllProducts();
			return result;
		}
		@GetMapping(value = "find/{name}") 
		public List<ProductDTO> findProductByName (@PathVariable String name){
			 List<ProductDTO> result = productService.findProductsByName(name);
			 return result;
		}
}
