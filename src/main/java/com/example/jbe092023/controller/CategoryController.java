package com.example.jbe092023.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbe092023.exception.CategoryNotFoundException;
import com.example.jbe092023.model.Category;
import com.example.jbe092023.service.CategoryService;
import com.example.jbe092023.utils.ResponseCode;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(path="/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	private List<Category> gategories = new ArrayList<Category>();
	
	@GetMapping(path = "/hello")
	public String hello() {
		return "Hello, World!";
	}
	
	@GetMapping(path = "")
	public List<Category> getAll(){
		return this.categoryService.getAll();
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<?> getByPathVariable(@PathVariable(name = "id")int id) {
		for (Category category :  categoryService.getAll()) {
			if(category.getCategoryId()==id)
				return ResponseEntity.ok(category);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/findById")
	public ResponseEntity<?> getByRequestParam(@RequestParam(name = "id")int id) {
		for (Category category :  categoryService.getAll()) {
			if(category.getCategoryId()==id)
				return ResponseEntity.ok(category);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("")
	public ResponseEntity<?> addCategory(@RequestBody Category category) {
		Category addedCategory = this.categoryService.saveCategory(category);
		if(addedCategory==null)
		{
			return BaseResponseController.fail(null, "fail adding");
		}
		return BaseResponseController.success(addedCategory);
	}
	
	@PutMapping(path="")
	public ResponseEntity <?> updateCaretory(@RequestBody Category newcategory) {
		for (Category category :  categoryService.getAll()) {
			if(category.getCategoryId()==newcategory.getCategoryId()) {
				category.setCategoryname(newcategory.getCategoryname());
				category.setDescription(newcategory.getDescription());
				return ResponseEntity.ok(category);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteCaretory(@PathVariable(name = "id")int id){
		try {
			return BaseResponseController.success(this.categoryService.deleteCategory(id));
		}catch(CategoryNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
