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
import com.cg.entity.Toy;
import com.cg.repository.ToyRepository;
import com.cg.service.ToyService;

@SpringBootTest
class ToyTesting {

	@Autowired
	ToyService toyService;
	
	@MockBean
	ToyRepository toyRepo;
	
	@Test
	void testinsertToy() {
		Toy d1=new Toy();
		
		d1.setToyId(1);
		d1.setName("Deepa");
		d1.setCategory("soft toys");
		d1.setCompany("abs");
		d1.setPrice(100);
		d1.setAvailabletoys(1);
		
		
	    Mockito.when(toyRepo.save(d1)).thenReturn(d1);		
		assertThat(toyService.insertToy(d1)).isEqualTo(d1);
	}
	@Test
	boolean testUpdateToy() throws Throwable {
		Toy  d1=new Toy();
		
		d1.setToyId(1);
		d1.setName("Deepa");
		d1.setCategory("soft toys");
		d1.setCompany("abs");
		d1.setPrice(100.0);
		d1.setAvailabletoys(1);
		
		Optional<Toy> d2=Optional.of(d1);
		
		Mockito.when(toyRepo.findById(1)).thenReturn(d2);
		
		Mockito.when(toyRepo.save(d1)).thenReturn(d1);
		d1.setName("likitha");
		d1.setCompany("lmn");
		d1.setToyId(1);
		
		assertThat (toyService.updateToy(d1)).isEqualTo(d1);
		return true;
	}

	@Test
	void testviewtoys() {
		Toy d1=new Toy();
		d1.setToyId(1);
		d1.setName("Deepa");
		d1.setCategory("soft toys");
		d1.setCompany("abs");
		d1.setPrice(100);
		d1.setAvailabletoys(1);
		
		Toy d2=new Toy();
		d2.setToyId(1);
		d2.setName("Harini");
		d2.setCategory("hard toys");
		d2.setCompany("jkl");
		d2.setPrice(200);
		d2.setAvailabletoys(1);

		List<Toy> toyList = new ArrayList<>();
		toyList.add(d1);
		toyList.add(d2);
		
		Mockito.when(toyRepo.findAll()).thenReturn(toyList);
		
		assertThat(toyService.getAllToy()).isEqualTo(toyList);
	}
	
	@Test
	void testDeleteToy() {
		Toy d1=new Toy();
		d1.setToyId(1);
		d1.setName("Deepa");
		d1.setCategory("soft toys");
		d1.setCompany("abs");
		d1.setPrice(100);
		d1.setAvailabletoys(1);
		
		Optional<Toy> d2=Optional.of(d1);
		
		Mockito.when(toyRepo.findById(1)).thenReturn(d2);
		 Mockito.when(toyRepo.existsById(d1.getToyId())).thenReturn(false);
		   assertFalse(toyRepo.existsById(d1.getToyId()));
	}


}

