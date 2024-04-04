package com.example.jbe092023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jbe092023.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
		

}
