package com.example.jbe092023.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbe092023.exception.CategoryNotFoundException;
import com.example.jbe092023.model.Category;
import com.example.jbe092023.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> getAll(){
		return this.categoryRepository.findAll();
	}
	
	public Category saveCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
	public boolean deleteCategory(Integer id) throws CategoryNotFoundException {
		Optional<Category> foundCategory = this.categoryRepository.findById(id);
		if(foundCategory.isEmpty()) {
			throw new CategoryNotFoundException();
		}
		this.categoryRepository.deleteById(id);
		return true;
	}
}
