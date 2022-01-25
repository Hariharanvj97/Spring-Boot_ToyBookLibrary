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
import com.cg.entity.MembershipType;
import com.cg.service.MembershipTypeService;

@RestController
@CrossOrigin
@RequestMapping(value = "/membershipType")
public class MembershipTypeController {
	
	@Autowired
	MembershipTypeService membershiptypeservice;
	
	@SuppressWarnings("unused")
	@PostMapping(value = "/insertmembershipType",consumes = "application/json",produces = "application/json")
	 ResponseEntity<MembershipType> insertMembershipType(@RequestBody MembershipType m)
	{
		MembershipType id= membershiptypeservice.insertMembershipType(m);
		System.out.println("Membership Type has been created");
		return ResponseEntity.ok(m);
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewmembershipType")
	public ResponseEntity<List<MembershipType>> getAllMembershipType(){
		List<MembershipType> membership= membershiptypeservice.getAllMembershipType();
		if(membership.isEmpty()) {
			return new ResponseEntity("Sorry! Membership Type not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MembershipType>>(membership, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/deletemembership/{membershipId}")
	public ResponseEntity<List<MembershipType>> deleteAdmin(@PathVariable("membershipId")Integer membershipId){
		List<MembershipType> membership= membershiptypeservice.deleteMembershipTypeById(membershipId);
		if(membership.isEmpty() || membership==null) {
			return new ResponseEntity("Sorry! AdminId not available!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MembershipType>>(membership, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/updatemembership")
	public ResponseEntity<List<MembershipType>> updateMembershipType(@RequestBody MembershipType membership){
		System.out.println(membership);
		List<MembershipType>m= membershiptypeservice.updateMembershipType(membership);
		if(m.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<MembershipType>>(m, HttpStatus.OK);
	}
	

}
