package com.example.jbe092023.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbe092023.exception.UserAlreadyExitException;
import com.example.jbe092023.exception.UserNotFoundException;
import com.example.jbe092023.exception.ValidateException;
import com.example.jbe092023.model.User;
import com.example.jbe092023.repository.UserRepository;
import com.example.jbe092023.request.UserRequestDTO;
import com.example.jbe092023.response.UserReponseDTO;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<UserReponseDTO> getAll() {
		return userRepository.findAll().stream().map(UserReponseDTO::new).toList();
	}
	
	private void validateUser(User user) throws ValidateException {
		if (Objects.isNull(user)) {
			throw new ValidateException("user is null");
		}

		if (Objects.isNull(user.getFullName()) || user.getFullName().isBlank()) {
			throw new ValidateException("user.fullName cannot be blank");
		}

		if (Objects.isNull(user.getUsername()) || user.getUsername().isBlank()) {
			throw new ValidateException("user.userName cannot be blank");
		}
	}
	private void validateUser(UserRequestDTO user)throws ValidateException{
		if (Objects.isNull(user)) {
			throw new ValidateException("user is null");
		}
		if (Objects.isNull(user.getFullName()) || user.getFullName().isBlank()) {
			throw new ValidateException("user.name cannot be blank");
		}

		if (Objects.isNull(user.getUserName()) || user.getUserName().isBlank()) {
			throw new ValidateException("user.userName cannot be blank");
		}

		if (Objects.isNull(user.getPassWord()) || user.getPassWord().isBlank()) {
			throw new ValidateException("user.passWord cannot be blank");
		}
	}
	
	public User addUser(UserRequestDTO user) throws UserAlreadyExitException,ValidateException{
		this.validateUser(user);
		
		Optional<User>foundUser = userRepository.findByUserName(user.getUserName());
		if(foundUser.isPresent()) {
			throw new UserAlreadyExitException();
		}
		
		return this.userRepository.save(user.toUser());
	}
	public User findById(Integer id) throws ValidateException, UserNotFoundException{
		if(Objects.isNull(id)||id<=0) {
			throw new ValidateException("user.id must be positive");
		}
		Optional<User> foundUser = this.userRepository.findById(id);
		if(foundUser.isEmpty()) {
			throw new UserNotFoundException();
		}
		return foundUser.get();
	}
	public User updateUser(User newUser) throws UserNotFoundException, ValidateException, UserAlreadyExitException {
		validateUser(newUser);
		
		Optional<User>foundUser = userRepository.findById(newUser.getUserId());
		if(foundUser.isEmpty()) {
			throw new UserNotFoundException();
		}
		foundUser=userRepository.findByUserName(newUser.getUsername());
		if(foundUser.isPresent() && newUser.getUserId()!=foundUser.get().getUserId()) {
			throw new UserAlreadyExitException();
		}
		return userRepository.save(newUser);
	}
	
	public Boolean deleteUser(Integer id) throws UserNotFoundException {
		Optional<User> foundUser = this.userRepository.findById(id);
		if(foundUser.isEmpty()) {
			throw new UserNotFoundException();
		}
		this.userRepository.deleteById(id);
		return true;
	}
}
