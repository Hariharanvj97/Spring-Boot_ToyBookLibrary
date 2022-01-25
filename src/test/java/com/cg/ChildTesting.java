package com.cg;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Child;
import com.cg.repository.ChildRepository;
import com.cg.service.ChildService;


@SpringBootTest
class ChildTesting {

	@Autowired
	ChildService childService;
	
	@MockBean
	ChildRepository childRep;
	
	@Test
	void testinsertchild()  {
		Child d1=new Child();
		
		d1.setChildId(1);
		d1.setUsername("Hari");
        d1.setPassword("HA");
		String startDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
        d1.setGender("male");
        d1.setMobile("12233455");
        d1.setEmail("hari@gmail.com");
        d1.setAddress("chennai");
       
	    Mockito.when(childRep.save(d1)).thenReturn(d1);		
		assertThat(childService.insertChild(d1)).isEqualTo(d1);
	}
	@Test
	boolean testchild() throws Throwable {
		Child  d1=new Child();
		
         d1.setChildId(1);
         d1.setUsername("Hari");
         d1.setPassword("HA");
		String startDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));
        d1.setGender("male");
        d1.setMobile("12233455");
        d1.setEmail("hari@gmail.com");
        d1.setAddress("chennai");
		
		Optional<Child> d2=Optional.of(d1);
		
		Mockito.when(childRep.findById(1)).thenReturn(d2);
		
		Mockito.when(childRep.save(d1)).thenReturn(d1);
		d1.setChildId(2);
		
		
		assertThat (childService.updateChild(d1)).isEqualTo(d1);
		return true;
	}

	@SuppressWarnings("unused")
	@Test
	void testviewchild() {
		Child d1=new Child();
		
		    d1.setChildId(1);
		    d1.setUsername("Hari");
	        d1.setPassword("HA");
			String startDate = " 2011-01-18 00:00:00.0";
	        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
	        java.util.Date date = null;
			try {
				date = dt.parse(startDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
	        System.out.println(dt1.format(date));
	        d1.setGender("male");
	        d1.setMobile("12233455");
	        d1.setEmail("hari@gmail.com");
	        d1.setAddress("chennai");
	       
		
		Child d2=new Child();
		 d2.setChildId(3);
		 d2.setUsername("Harish");
	     d2.setPassword("HAR");
			String startDate1 = " 2011-01-18 00:00:00.0";
	        SimpleDateFormat dt2 = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
	        java.util.Date date1 = null;
			try {
				date = dt.parse(startDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        SimpleDateFormat dt3 = new SimpleDateFormat("yyyy-mm-dd");
	        System.out.println(dt3.format(date));
	        d2.setGender("male");
	        d2.setMobile("1223345599");
	        d2.setEmail("hari@gmail.com");
	        d2.setAddress("chennai");
		List<Child> childList = new ArrayList<>();
		childList.add(d1);
		childList.add(d2);
		
		Mockito.when(childRep.findAll()).thenReturn(childList);
		
		assertThat(childService.getAllChild()).isEqualTo(childList);
	}
	
	@Test
	void testDeleteToy() {
		Child d1=new Child();
		
		d1.setChildId(1);
		d1.setUsername("Hari");
        d1.setPassword("HA");
		String startDate = " 2011-01-18 00:00:00.0";
        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
        java.util.Date date = null;
		try {
			date = dt.parse(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
        System.out.println(dt1.format(date));	
        d1.setGender("male");
        d1.setMobile("12233455");
        d1.setEmail("hari@gmail.com");
        d1.setAddress("chennai");
		
		Optional<Child> d2=Optional.of(d1);
		
		Mockito.when(childRep.findById(1)).thenReturn(d2);
		 Mockito.when(childRep.existsById(d1.getChildId())).thenReturn(false);
		   assertFalse(childRep.existsById(d1.getChildId()));
	}


}
