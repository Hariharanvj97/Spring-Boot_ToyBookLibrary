package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.Child;
import com.cg.exception.InvalidUserException;

@SuppressWarnings("unused")
@Service
public interface ChildService {
	
	public Child insertChild(Child child);

	public List<Child> deleteChildById(Integer childId);

	public List<Child> updateChild(Child child);

	public List<Child> getAllChild();

	public List<Child> findByChildId(int childId);
	
	public ResponseEntity<Child> validatePassword(String username, String password)throws InvalidUserException;
}
