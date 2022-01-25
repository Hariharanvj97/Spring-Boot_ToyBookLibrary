package com.cg.service;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.controller.ToyController;
import com.cg.exception.ToyNotFoundException;
import com.cg.entity.Toy;
import com.cg.repository.ToyRepository;

@SuppressWarnings("unused")
@Service
public class ToyServiceImpl implements ToyService {

	@Autowired
	ToyRepository repo;

	@Override
	public Toy insertToy(Toy toy) {
		repo.save(toy);
    	return toy;
	}
	public List<Toy> getAllToy() {
		return repo.findAll();
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List<Toy> findBytoycompany(String company)throws ToyNotFoundException {
		Supplier s1= ()->new ToyNotFoundException ("toy_id Does not exist in the database");
		List<Toy> t=repo.findBytoycompany(company);
		return t;
	}
	public List<Toy> deleteToyById(Integer toyId) {
		repo.deleteById(toyId);
		return  repo.findAll();
	}
	public List<Toy> updateToy(Toy toy) {
		repo.saveAndFlush(toy);
		return  repo.findAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Toy> findBytoyId(int toyId) throws ToyNotFoundException {
		Supplier s1= ()->new ToyNotFoundException ("toy_id Does not exist in the database");
		List<Toy> t=repo.findBytoyId(toyId);
		return t;
	}
}

