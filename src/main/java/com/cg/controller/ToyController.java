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
import com.cg.exception.ToyNotFoundException;
import com.cg.entity.Toy;
import com.cg.service.ToyService;

@SuppressWarnings("unused")
@RestController
@CrossOrigin
@RequestMapping(value = "/toy")
public class ToyController {
	@Autowired
	ToyService toyservice;
	@PostMapping(value = "/insertToy",consumes = "application/json",produces = "application/json")
	ResponseEntity<Toy> insertToy(@RequestBody Toy t)
	{
	Toy id= toyservice.insertToy(t);
	System.out.println("toy has been created");
	return ResponseEntity.ok(t);

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewtoys")
	public ResponseEntity<List<Toy>> getAllToy(){
		List<Toy> toy= toyservice.getAllToy();
		if(toy.isEmpty()) {
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Toy>>(toy, HttpStatus.OK);
}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewtoyById/{toyId}")
	public ResponseEntity<List<Toy>> getAllBytoyId(@PathVariable("toyId")int toyId)throws ToyNotFoundException{
		List<Toy> t= toyservice.findBytoyId(toyId);
		if(t.isEmpty()) {
			return new ResponseEntity("Sorry! toy not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Toy>>(t, HttpStatus.OK);
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewToysByCompany/{company}")
	public ResponseEntity<List<Toy>> getAllBycompany(@PathVariable("company")String company)throws ToyNotFoundException
	{
		List<Toy> toy= toyservice.findBytoycompany(company);
		if(toy.isEmpty()) {
			return new ResponseEntity("Sorry! Toys not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Toy>>(toy, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/deletetoy/{toyId}")
	public ResponseEntity<List<Toy>> deleteToyById(@PathVariable("toyId")Integer toyId){
		List<Toy> toy= toyservice.deleteToyById(toyId);
		if(toy.isEmpty() || toy==null) {
			return new ResponseEntity("Sorry! ProductsId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Toy>>(toy, HttpStatus.OK);
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/updateToy")
	public ResponseEntity<List<Toy>> updateToy(@RequestBody Toy toy){
		System.out.println(toy);
		List<Toy>c= toyservice.updateToy(toy);
		if(c.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Toy>>(c, HttpStatus.OK);
	}
}
