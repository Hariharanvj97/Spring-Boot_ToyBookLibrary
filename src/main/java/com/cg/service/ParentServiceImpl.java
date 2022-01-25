package com.cg.service;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Admin;
import com.cg.entity.Parent;
import com.cg.exception.InvalidUserException;
import com.cg.repository.ParentRepository;

@SuppressWarnings("unused")
@Service
public class ParentServiceImpl implements ParentService {
	@Autowired
	ParentRepository repo;
	
	@Override
	public Parent insertParent(Parent parent) {
		repo.save(parent);
		return parent;	
	}
	@Override
	public List<Parent> updateParent(Parent parent) {
		repo.saveAndFlush(parent);
		return  repo.findAll();
	}

	@Override
	public List<Parent> deleteParentById(Integer parentId) {
		repo.deleteById(parentId);
		return  repo.findAll();
	}
	@Override
	public List<Parent> getAllParent() {
		return repo.findAll();
	}

	 @Override public List<Parent> findByparentId(int parentId) {
		  return repo.findByparentId(parentId); 
		   }

	@SuppressWarnings("rawtypes")
	@Override
		public ResponseEntity<Parent> validatePassword(String username, String password) throws InvalidUserException {
		Supplier s1= ()->new InvalidUserException ("Invalid User Name and Password!");
		ResponseEntity<Parent> a= repo.validatePassword(username, password);
		return a;
		}
}