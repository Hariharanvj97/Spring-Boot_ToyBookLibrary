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
import com.cg.entity.Parent;
import com.cg.exception.InvalidUserException;
import com.cg.service.ParentService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin
@RequestMapping(value = "/parent")

public class ParentController {

	@Autowired
	 ParentService parentservice;
	
	@PostMapping(value = "/insertparent",consumes = "application/json",produces = "application/json")
	ResponseEntity<Parent> insertparent(@RequestBody Parent p)
	{

   Parent id= parentservice.insertParent(p);
	System.out.println("Parent has been created");
	return ResponseEntity.ok(p);
}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/parents")
	public ResponseEntity<List<Parent>> updateParent(
			@RequestBody Parent parent){
		System.out.println(parent);
		List<Parent> parents= parentservice.updateParent(parent);
		if(parents.isEmpty())
		{
			return new ResponseEntity("Sorry! parent not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Parent>>(parents, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/deleteparent/{parentId}")
	public ResponseEntity<List<Parent>> deleteParentById(@PathVariable("parentId")Integer parentId){
		List<Parent> parent= parentservice.deleteParentById(parentId);
		if(parent.isEmpty() || parent==null) {
			return new ResponseEntity("Sorry! ParentId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Parent>>(parent, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewparents")
	public ResponseEntity<List<Parent>> getAllParent(){
		List<Parent> parent= parentservice.getAllParent();
		if(parent.isEmpty()) {
			return new ResponseEntity("Sorry! Parents not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Parent>>(parent, HttpStatus.OK);
}


  @SuppressWarnings({ "rawtypes", "unchecked" })
@GetMapping("/viewparentsById/{parentId}") public
  ResponseEntity<List<Parent>> getAllByparentId(@PathVariable("parentId")int
  parentId){ List<Parent> p= parentservice.findByparentId(parentId);
  if(p.isEmpty()) { return new ResponseEntity("Sorry! parent not available!",
  HttpStatus.NOT_FOUND); }
  
  return new ResponseEntity<List<Parent>>(p, HttpStatus.OK); }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/validatePassword")
	public ResponseEntity<Parent> validatePassword(@RequestBody Parent validate)throws InvalidUserException
	{
		String username = validate.getUsername();
		String password = validate.getPassword();
		ResponseEntity<Parent> obj =null;
		if(username != null && password != null) {
			obj=parentservice.validatePassword(username, password );
		}
		if(obj == null) {
			return new ResponseEntity("Invalid User Name and Password!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(obj, HttpStatus.OK);
	}

}
