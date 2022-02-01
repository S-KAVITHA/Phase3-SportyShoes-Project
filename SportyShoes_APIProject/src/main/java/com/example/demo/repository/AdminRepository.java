package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;


//@author Kavitha S

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

		
	
}
