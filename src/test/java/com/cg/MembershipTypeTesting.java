package com.cg;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Admin;
import com.cg.entity.MembershipType;
import com.cg.repository.AdminRepository;
import com.cg.repository.MembershipTypeRepository;
import com.cg.service.MembershipTypeService;

@SuppressWarnings("unused")
@SpringBootTest
class MembershipTypeTesting {
	
	MembershipType m1=new MembershipType();
	MembershipType m2=new MembershipType();
	
	@Autowired
	MembershipTypeService membershipTypeService;
	
	@MockBean
	MembershipTypeRepository membershipTypeRepo;
	
	@Test
	void testinsertmembershipType() {
		
		m1.setMembershipTypeId(1);
		m1.setDescription("Basic Plan");
		m1.setDurationMonths(3);
		m1.setPrice(500);
		
	    Mockito.when(membershipTypeRepo.save(m1)).thenReturn(m1);		
		assertThat(membershipTypeService.insertMembershipType(m1)).isEqualTo(m1);
	}
	@Test
	boolean testUpdatemembershipType() throws Throwable {
		
		m1.setMembershipTypeId(1);
		m1.setDescription("Basic Plan");
		m1.setDurationMonths(3);
		m1.setPrice(500);
		
		Optional<MembershipType> m2=Optional.of(m1);
		
		Mockito.when(membershipTypeRepo.findById(1)).thenReturn(m2);
		
		Mockito.when(membershipTypeRepo.save(m1)).thenReturn(m1);
		m1.setDescription("Intermediate Plan");
		
		assertThat (membershipTypeService.updateMembershipType(m1)).isEqualTo(m1);
		return true;
	}

	@Test
	void testviewmembershipType() {
	
		m1.setMembershipTypeId(1);
		m1.setDescription("Basic Plan");
		m1.setDurationMonths(3);
		m1.setPrice(500);
		
		m2.setMembershipTypeId(2);
		m2.setDescription("Intermediate Plan");
		m2.setDurationMonths(6);
		m2.setPrice(1000);
		

		List<MembershipType> membershipTypeList = new ArrayList<>();
		membershipTypeList.add(m1);
		membershipTypeList.add(m2);
		
		Mockito.when(membershipTypeRepo.findAll()).thenReturn(membershipTypeList);
		
		assertThat(membershipTypeService.getAllMembershipType()).isEqualTo(membershipTypeList);
	}
	
	@Test
	void testDeleteAdmin() {
		
		m1.setMembershipTypeId(2);
		m1.setDescription("Intermediate Plan");
		m1.setDurationMonths(6);
		m1.setPrice(1000);
		
		Optional<MembershipType> m2=Optional.of(m1);
		
		Mockito.when(membershipTypeRepo.findById(1)).thenReturn(m2);
		 Mockito.when(membershipTypeRepo.existsById(m1.getMembershipTypeId())).thenReturn(false);
		   assertFalse(membershipTypeRepo.existsById(m1.getMembershipTypeId()));
	}

}
