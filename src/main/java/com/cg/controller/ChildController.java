package com.cg.controller;
import java.time.LocalDate;
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
import com.cg.entity.Child;
import com.cg.exception.InvalidUserException;
import com.cg.service.ChildService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin

@RequestMapping(value="/child")
public class ChildController {
	
	@Autowired
	ChildService childservice;
	
	
	@PostMapping(value = "/insertchild",consumes = "application/json",produces = "application/json")
	ResponseEntity<Child> insertChild(@RequestBody Child c)
	{
	
	Child id= childservice.insertChild(c);
	System.out.println("Child has been created");
	return ResponseEntity.ok(c);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/deletechild/{childId}")
	public ResponseEntity<List<Child>> deleteChild(@PathVariable("childId")Integer childId){
		List<Child> c= childservice.deleteChildById(childId);
		if(c.isEmpty() || c ==null) {
			return new ResponseEntity("Sorry! Data is not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Child>>(c , HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/childs")
	public ResponseEntity<List<Child>> updateChild(
			@RequestBody Child child){
		System.out.println(child);
		List<Child> cu= childservice.updateChild(child);
		if(cu.isEmpty())
		{
			return new ResponseEntity("Sorry!  not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Child>>(cu, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewchild")
	public ResponseEntity<List<Child>> getAllChild(){
		List<Child> cv= childservice.getAllChild();
		if(cv .isEmpty()) {
			return new ResponseEntity("Sorry!Child info not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Child>>(cv , HttpStatus.OK);
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewchildById/{childId}")
    public ResponseEntity<List<Child>> getAllByChildId(@PathVariable("childId")int childId){
        List<Child> cvid= childservice.findByChildId(childId);
        if(cvid.isEmpty()) {
            return new ResponseEntity("Sorry! Child info not available!",
                    HttpStatus.NOT_FOUND);
        }
       
        return new ResponseEntity<List<Child>>(cvid, HttpStatus.OK);
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/validatePassword")
	public ResponseEntity<Child> validatePassword(@RequestBody Child validate)throws InvalidUserException
	{
		String username = validate.getUsername();
		String password = validate.getPassword();
		ResponseEntity<Child> obj =null;
		if(username != null && password != null) {
			obj=childservice.validatePassword(username, password );
		}
		if(obj == null) {
			return new ResponseEntity("Invalid User Name and Password!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(obj, HttpStatus.OK);
	}

}

