package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Toy;

public interface ToyRepository extends JpaRepository<Toy, Integer>
{

	@Query("SELECT t FROM Toy t  WHERE t.company=?1") 
	List<Toy> findBytoycompany(String company);

	List<Toy> findBytoyId(int toyId);
	
	




}
