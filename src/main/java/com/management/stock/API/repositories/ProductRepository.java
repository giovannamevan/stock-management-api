package com.management.stock.API.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.stock.API.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
	
	@Query(nativeQuery = true, value = """
			SELECT * FROM TB_PRODUCTS WHERE PRODUCT_NAME = :NAME;
			""")
	  		List<Product> findProductByName (String NAME);
}
