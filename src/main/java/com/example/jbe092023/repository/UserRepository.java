package com.example.jbe092023.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jbe092023.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
	
	@Query(nativeQuery = true , value = "SELECT * FROM jbe092023.table_users where col_username like %?1%")
	List<User> findByNameExisted(String name);
	
	
}
