package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.entity.Admin;
import com.cg.entity.MembershipType;
import com.cg.exception.InvalidUserException;

@SuppressWarnings("unused")
@Service
public interface AdminService {
	
	public Admin insertAdmin(Admin user);

	public List<Admin> findByadminId(int adminId);

	public List<Admin> deleteAdminById(Integer adminId);

	public List<Admin> getAllAdmin();

	public List<Admin> updateAdmin(Admin admin);

	public ResponseEntity<Admin> validatePassword(String username, String password)throws InvalidUserException;

	

}
