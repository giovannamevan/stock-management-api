package com.management.stock.API.DTOs;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.stock.API.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private String productName;
	private String productCode;
	private BigDecimal productPrice;
	private String productCategory;
	private String productWeight;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar productExpirationDate;
	private int productQuantity;
	
	public ProductDTO (Product entity) {
		 this.productName = entity.getProductName();
		 this.productCode = entity.getProductCode();
		 this.productPrice = entity.getProductPrice();
		 this.productCategory = entity.getProductCategory();
		 this.productWeight = entity.getProductWeight();
		 this.productExpirationDate = entity.getProductExpirationDate();
		 this.productQuantity = entity.getProductQuantity();
	}
}
