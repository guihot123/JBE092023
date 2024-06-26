package com.example.jbe092023.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jbe092023.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
