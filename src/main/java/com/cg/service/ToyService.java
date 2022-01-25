package com.cg.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.cg.exception.ToyNotFoundException;
import com.cg.entity.Toy;

@Service
public interface ToyService {
	public Toy insertToy(Toy toy);

	public List<Toy> getAllToy();

	public List<Toy> findBytoycompany(String company)throws ToyNotFoundException;

	public List<Toy> deleteToyById(Integer toyId);

	public List<Toy> updateToy(Toy toy);

	public List<Toy> findBytoyId(int toyId)throws ToyNotFoundException;

}