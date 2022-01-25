package com.cg.controller;
import java.util.List;
import java.util.Optional;

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
import com.cg.entity.LendItems;
import com.cg.service.LendItemService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin
@RequestMapping(value = "/lenditem")
public class LendItemcontroller {

	@Autowired
	LendItemService lenditemservice;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/insertLend")
	public ResponseEntity<LendItems> insertLendItems(@RequestBody LendItems a)
	{
		LendItems a1= lenditemservice.insertLendItems(a);
		ResponseEntity re=new ResponseEntity<LendItems>(a1,HttpStatus.OK);
		return re;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/lendput")
	public ResponseEntity<List<LendItems>> updateLendItems(@RequestBody LendItems b){
	System.out.println(b);
	List<LendItems> c = lenditemservice.updateLendItems(b);
	if(c.isEmpty())
	{
		return new ResponseEntity("sorry",HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<List<LendItems>>(c,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/lenddel/{lendId}")
	public ResponseEntity<List<LendItems>> deleteLendItems(@PathVariable("lendId")Integer lendId){
		List<LendItems> c= lenditemservice.deleteLendItems(lendId);
		if(c.isEmpty())
		{
			return new ResponseEntity("sorry",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<LendItems>>(c,HttpStatus.OK);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/lendlist/viewall")
	public ResponseEntity<List<LendItems>> viewAllLendings(){
		List<LendItems> c = lenditemservice.viewAllLendings();
		if(c.isEmpty())
		{
			return new ResponseEntity("sorry",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<LendItems>>(c,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewlendById/{lendId}")
	public ResponseEntity<List<LendItems>> getAllBylendId(@PathVariable("lendId")int lendId) {
		List<LendItems> lend= lenditemservice.findBylendId(lendId);
		if(lend.isEmpty()) {
			return new ResponseEntity("Sorry! Books not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<LendItems>>(lend, HttpStatus.OK);
	}


	
}
