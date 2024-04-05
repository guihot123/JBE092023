package com.example.jbe092023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbe092023.exception.UserAlreadyExitException;
import com.example.jbe092023.exception.UserNotFoundException;
import com.example.jbe092023.exception.ValidateException;
import com.example.jbe092023.model.User;
import com.example.jbe092023.request.UserRequestDTO;
import com.example.jbe092023.response.UserReponseDTO;
import com.example.jbe092023.service.UserService;
import com.example.jbe092023.utils.ResponseCode;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping(path="/Users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path="")
	public ResponseEntity<?> getAll() {
		return BaseResponseController.success(userService.getAll());
	}
	
	@PostMapping(path="")
	public ResponseEntity addUser(@RequestBody UserRequestDTO user) {
		try {
			User addUser = this.userService.addUser(user);
			return BaseResponseController.success(new UserReponseDTO(addUser));
		} catch (UserAlreadyExitException e) {
			return BaseResponseController.fail(ResponseCode.USER_ALREADY_EXISTS.getCode(), 
					ResponseCode.USER_ALREADY_EXISTS.getMessage());
		}catch (ValidateException e) {
			return BaseResponseController.fail(ResponseCode.VALIDATION_EXCEPTION.getCode(),
					ResponseCode.VALIDATION_EXCEPTION.getMessage());
		}

	}
	
	@GetMapping(path="/findById")
	public ResponseEntity<?> getByRequestParm(@RequestParam(name="id",required = false,defaultValue = "0")Integer id) {
		try {
			User findUser = this.userService.findById(id);
			return BaseResponseController.success(findUser);
		}catch(UserNotFoundException e) {
			return BaseResponseController.fail(ResponseCode.USER_NOT_FOUND.getCode(), 
					ResponseCode.USER_NOT_FOUND.getMessage());
		}catch(ValidateException e) {
			return BaseResponseController.fail(ResponseCode.VALIDATION_EXCEPTION.getCode(),
					ResponseCode.VALIDATION_EXCEPTION.getMessage());
		}

	}
	
	@PutMapping(path="")
	public ResponseEntity<?> updateUser(@RequestBody User newUser) {
		try {
			User updateUser = this.userService.updateUser(newUser);
			return BaseResponseController.success(updateUser);
		} catch (UserNotFoundException e) {
			return BaseResponseController.fail(ResponseCode.USER_NOT_FOUND.getCode(), 
					ResponseCode.USER_NOT_FOUND.getMessage());
		}catch (ValidateException e) {
			return BaseResponseController.fail(ResponseCode.VALIDATION_EXCEPTION.getCode(),
					ResponseCode.VALIDATION_EXCEPTION.getMessage());
		}catch (UserAlreadyExitException e) {
			return BaseResponseController.fail(ResponseCode.USER_ALREADY_EXISTS.getCode(),
					ResponseCode.USER_ALREADY_EXISTS.getMessage());
		}
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(name="id")Integer id){
		try {
			return BaseResponseController.success(userService.deleteUser(id));
		}catch(UserNotFoundException e) {
			return BaseResponseController.fail(ResponseCode.USER_NOT_FOUND.getCode(),
					ResponseCode.USER_NOT_FOUND.getMessage());
		}
		
	}
}
