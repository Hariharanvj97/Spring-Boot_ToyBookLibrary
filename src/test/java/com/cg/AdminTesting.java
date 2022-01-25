package com.cg;

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
import com.cg.repository.AdminRepository;
import com.cg.service.AdminService;

@SpringBootTest
class AdminTesting {
	Admin a1=new Admin();
	Admin a2=new Admin();
	
	@Autowired
	AdminService adminService;
	
	@MockBean
	AdminRepository adminRepo;
	
	@Test
	void testinsertadmin() {
		
		a1.setAdminId(1);
		a1.setUsername("Vrushali");
		a1.setPassword("abc");
		a1.setGender("Female");
		a1.setMobile("1234567");
		a1.setEmail("vvvv@gmail.com");
		a1.setAddress("Pune");
		
	    Mockito.when(adminRepo.save(a1)).thenReturn(a1);		
		assertThat(adminService.insertAdmin(a1)).isEqualTo(a1);
	}
	@Test
	boolean testUpdateAdmin() throws Throwable {
	
		a1.setAdminId(1);
		a1.setUsername("Vrushali");
		a1.setPassword("abc");
		a1.setMobile("1234567");
		a1.setAddress("Pune");
		a1.setGender("Female");
		a1.setEmail("vvvv@gmail.com");
		
		Optional<Admin> a2=Optional.of(a1);
		
		Mockito.when(adminRepo.findById(1)).thenReturn(a2);
		
		Mockito.when(adminRepo.save(a1)).thenReturn(a1);
		a1.setAddress("Neyveli");
		
		assertThat (adminService.updateAdmin(a1)).isEqualTo(a1);
		return true;
	}

	@Test
	void testviewadmin() {
		a1.setAdminId(1);
		a1.setUsername("Vrushali");
		a1.setPassword("abc");
		a1.setGender("Female");
		a1.setMobile("1234567");
		a1.setEmail("vvvv@gmail.com");
		a1.setAddress("Pune");

		a2.setAdminId(2);
		a2.setUsername("Harini");
		a2.setPassword("hhh");
		a2.setGender("Female");
		a2.setMobile("234567");
		a2.setAddress("Mumbai");
		a2.setEmail("hhhh@gmail.com");

		List<Admin> adminList = new ArrayList<>();
		adminList.add(a1);
		adminList.add(a2);
		
		Mockito.when(adminRepo.findAll()).thenReturn(adminList);
		
		assertThat(adminService.getAllAdmin()).isEqualTo(adminList);
	}
	
	@Test
	void testDeleteAdmin() {

		a1.setAdminId(1);
		a1.setUsername("Vrushali");
		a1.setPassword("abc");
		a1.setGender("Female");
		a1.setMobile("1234567");
		a1.setAddress("Pune");
		a1.setEmail("vvvv@gmail.com");
		
		Optional<Admin> a2=Optional.of(a1);
		
		Mockito.when(adminRepo.findById(1)).thenReturn(a2);
		 Mockito.when(adminRepo.existsById(a1.getAdminId())).thenReturn(false);
		   assertFalse(adminRepo.existsById(a1.getAdminId()));
	}


}
