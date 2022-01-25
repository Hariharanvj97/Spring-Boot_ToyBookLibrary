package com.cg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Parent;
import com.cg.repository.ParentRepository;
import com.cg.service.ParentService;
@SpringBootTest
class ParentTesting {
	@Autowired
	ParentService parentService;
	 @MockBean
	    ParentRepository parentRepo;
	 

	    @Test
	    void testinsertparent() { 
	        Parent p1=new Parent();
	        
	        p1.setParentId(1);
	        p1.setUsername("Hari");
	        p1.setPassword("HA");
	        p1.setGender("male");
	        p1.setMobile("12233455");
	        p1.setEmail("hari@gmail.com");
	        p1.setAddress("chennai");
	        p1.setCardNo("12453876");
	        p1.setUpiNo("arjun1@upi");
	  
	        
	        Mockito.when(parentRepo.save(p1)).thenReturn(p1);        
	        assertThat(parentService.insertParent(p1)).isEqualTo(p1);
	    }
	    
	    @Test
	    void testviewparents() {
	        Parent p1=new  Parent();
	        p1.setParentId(1);
	        p1.setUsername("Hari");
	        p1.setPassword("HA");
	        p1.setGender("male");
	        p1.setMobile("12233455");
	        p1.setEmail("hari@gmail.com");
	        p1.setAddress("chennai");
	        p1.setCardNo("12453876");
	        p1.setUpiNo("arjun1@upi");
	  
	        
	        Parent p2=new Parent();
	        p2.setParentId(2);
	        p2.setUsername("Harish");
	        p2.setPassword("HAR");
	        p2.setGender("male");
	        p2.setMobile("1223366");
	        p2.setEmail("harish@gmail.com");
	        p2.setAddress("chennai");
	        p2.setCardNo("1245387698");
	        p2.setUpiNo("arjun12@upi");
	  

	        List<Parent> parentList = new ArrayList<>();
	        parentList.add(p1);
	        parentList.add(p2);
	        
	        Mockito.when(parentRepo.findAll()).thenReturn(parentList);
	        
	        assertThat(parentService.getAllParent()).isEqualTo(parentList);
	    }
	    
	    @Test
	    boolean testparents() throws Throwable {
	    	   Parent p1=new  Parent();
	    	    p1.setParentId(1);
		        p1.setUsername("Hari");
		        p1.setPassword("HA");
		        p1.setGender("male");
		        p1.setMobile("12233455");
		        p1.setEmail("hari@gmail.com");
		        p1.setAddress("chennai");
		        p1.setCardNo("12453876");
		        p1.setUpiNo("arjun1@upi");
		  
	        Optional<Parent> p2=Optional.of(p1);
	        
	        Mockito.when(parentRepo.findById(1)).thenReturn(p2);
	        
	        Mockito.when(parentRepo.save(p1)).thenReturn(p1);
	        p1.setUpiNo("Raja123@upi");
	        
	        assertThat(parentService.updateParent(p1)).isEqualTo(p1);
	        return true;
	    }
	    
	    
	    @Test
	    void testdeleteparent() {
	    	 Parent p1=new  Parent();
	    	 p1.setParentId(1);
		        p1.setUsername("Hari");
		        p1.setPassword("HA");
		        p1.setGender("male");
		        p1.setMobile("12233455");
		        p1.setEmail("hari@gmail.com");
		        p1.setAddress("chennai");
		        p1.setCardNo("12453876");
		        p1.setUpiNo("arjun1@upi");
	        Optional<Parent> p2=Optional.of(p1);
	        
	        Mockito.when(parentRepo.findById(1)).thenReturn(p2);
	         Mockito.when(parentRepo.existsById(p1.getParentId())).thenReturn(false);
	           assertFalse(parentRepo.existsById(p1.getParentId()));
	    }


}

