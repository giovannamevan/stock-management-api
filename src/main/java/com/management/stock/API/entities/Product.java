package com.management.stock.API.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.stock.API.DTOs.ProductDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_products")
public class Product {
		private String productName;
		@Id
		private String productCode;
		private BigDecimal productPrice;
		private String productCategory;
		private String productWeight;
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		@JsonFormat(pattern="dd/MM/yyyy")
		private Calendar productExpirationDate;
		
		public Product (ProductDTO dto) {
			this.productName = dto.getProductName();
			this.productCode = dto.getProductCode();
			this.productPrice = dto.getProductPrice();
			this.productCategory = dto.getProductCategory();
			this.productWeight = dto.getProductWeight();
			this.productExpirationDate = dto.getProductExpirationDate();
		}
}
