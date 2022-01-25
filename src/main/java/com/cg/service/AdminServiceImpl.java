package com.cg.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.entity.Admin;
import com.cg.entity.MembershipType;
import com.cg.exception.InvalidUserException;
import com.cg.repository.AdminRepository;

@SuppressWarnings("unused")
@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminRepository repo;
	
	@Override
	public Admin insertAdmin(Admin admin) {

		repo.save(admin);
		return admin;
	}

	@Override
	public List<Admin> findByadminId(int adminId) {
		List<Admin> a=repo.findByadminId(adminId);//custom methods of repository
		return a;
	}

	@Override
	public List<Admin> deleteAdminById(Integer adminId) {
		repo.deleteById(adminId);
		return  repo.findAll();
	}

	@Override
	public List<Admin> getAllAdmin() {
		return repo.findAll();
	}

	@Override
	public List<Admin> updateAdmin(Admin admin) {
		repo.saveAndFlush(admin);
		return  repo.findAll();

	}

	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<Admin> validatePassword(String username, String password) throws InvalidUserException {
		Supplier s1= ()->new InvalidUserException ("Invalid User Name and Password!");
		ResponseEntity<Admin> a= repo.validatePassword(username, password);
		return a;
	}

}

