package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import com.cg.entity.Admin;
import com.cg.exception.InvalidUserException;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{

	//@Query("SELECT t FROM Admin a  WHERE t.company=?1")
	List<Admin> findByadminId(int adminId);

	@Query("SELECT a FROM Admin a WHERE a.username=?1")
	List<Admin> validateUsername(String username); 
	
	@Query("SELECT a FROM Admin a WHERE a.password=?1")
	List<Admin> validatePassword(String password); 

	@Query("SELECT a FROM Admin a WHERE a.username=?1 AND a.password=?1")
	ResponseEntity<Admin> validatePassword(String username, String password)throws InvalidUserException;

}
