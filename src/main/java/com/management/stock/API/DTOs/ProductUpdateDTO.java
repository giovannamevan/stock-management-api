package com.management.stock.API.DTOs;

import java.math.BigDecimal;
import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDTO {
	
	@NonNull
	private String productCode;
	private BigDecimal productPrice;
	private int productQuantity;
	
	
}
