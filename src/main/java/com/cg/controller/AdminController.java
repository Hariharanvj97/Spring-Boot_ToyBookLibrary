package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.entity.Admin;
import com.cg.entity.MembershipType;
import com.cg.exception.InvalidUserException;
import com.cg.service.AdminService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@PostMapping(value = "/insertadmin",consumes = "application/json",produces = "application/json")
	 ResponseEntity<Admin> insertAdmin(@RequestBody Admin a)
	{	
		Admin id= adminservice.insertAdmin(a);
		System.out.println("Admin has been created");
		return ResponseEntity.ok(a);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewadmin")
	public ResponseEntity<List<Admin>> getAllAdmin(){
		List<Admin> admin= adminservice.getAllAdmin();
		if(admin.isEmpty()) {
			return new ResponseEntity("Sorry! Admin not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewadminById/{adminId}")
	public ResponseEntity<List<Admin>> getAllByadminId(@PathVariable("adminId")int adminId){
		List<Admin> admin= adminservice.findByadminId(adminId);
		if(admin.isEmpty()) {
			return new ResponseEntity("Sorry! Admin not found!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/deleteadmin/{adminId}")
	public ResponseEntity<List<Admin>> deleteAdmin(@PathVariable("adminId")Integer adminId){
		List<Admin> admin= adminservice.deleteAdminById(adminId);
		if(admin.isEmpty() || admin==null) {
			return new ResponseEntity("Sorry! AdminId not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Admin>>(admin, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/updatadmin")
	public ResponseEntity<List<Admin>> updateAdmin(@RequestBody Admin admin){
		System.out.println(admin);
		List<Admin>a= adminservice.updateAdmin(admin);
		if(a.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Admin>>(a, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/validatePassword")
	public ResponseEntity<Admin> validatePassword(@RequestBody Admin validate)throws InvalidUserException
	{
		String username = validate.getUsername();
		String password = validate.getPassword();
		ResponseEntity<Admin> obj =null;
		if(username != null && password != null) {
			obj=adminservice.validatePassword(username, password );
		}
		if(obj == null) {
			return new ResponseEntity("Invalid User Name and Password!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(obj, HttpStatus.OK);
	}

}
	


