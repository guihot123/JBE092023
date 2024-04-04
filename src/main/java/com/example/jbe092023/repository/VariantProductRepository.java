package com.example.jbe092023.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jbe092023.model.VariantProduct;

@Repository
public interface VariantProductRepository extends JpaRepository<VariantProduct, Integer> {
	@Query(nativeQuery = true, value ="SELECT * FROM jbe092023.jbe092023.table_variant_products where product_id like %?1%")
	List<VariantProduct> findAllByProductId(Integer id);
	
}
