package com.example.jbe092023.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jbe092023.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	 @Query(nativeQuery = true,value ="SELECT * FROM jbe092023.table_products WHERE category_id like %?1%")
	List<Product> findByCategoryId(Integer id, Pageable pageable);
}
