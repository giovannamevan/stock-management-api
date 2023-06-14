package com.management.stock.API.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.management.stock.API.DTOs.ProductDTO;
import com.management.stock.API.DTOs.ProductUpdateDTO;
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
		
		@PutMapping
		public void updateProduct (@RequestBody @Validated ProductUpdateDTO product) {
			  productService.updateProduct(product);
		}
		
		@GetMapping(value = "/all") 
		public List<ProductDTO> findAllProducts (){
			   return productService.findAllProducts();
			   
		}
		@GetMapping(value = "find/{name}") 
		public List<ProductDTO> findProductByName (@PathVariable String name){
			   return productService.findProductsByName(name);
			   
		}
		@GetMapping(value = "date")
		public List<ProductDTO> allProductsOrderedByExDate () {
			return productService.allProductsOrderedByExDate();
		}
		@GetMapping(value = "category/{name}")
		public List<ProductDTO> findProductsByCategory (@PathVariable String name){
			   return productService.findProductsByCategory(name);
		}
}
