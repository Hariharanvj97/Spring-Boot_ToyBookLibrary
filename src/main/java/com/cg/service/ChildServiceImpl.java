package com.cg.service;
import java.util.List;
import java.util.function.Supplier;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Admin;
import com.cg.entity.Child;
import com.cg.exception.InvalidUserException;
import com.cg.repository.ChildRepository;

@SuppressWarnings("unused")
@Service

public class ChildServiceImpl implements ChildService {

	@Autowired
	ChildRepository rep;
	@Override
	public Child insertChild(Child child) {
	rep.save(child);
		 return(child);
	}
	@Override
	public List<Child> deleteChildById(Integer childId) {
		rep.deleteById(childId);
		return  rep.findAll();
	}
	
	@Override
	public List<Child> updateChild(Child child) {
		rep.saveAndFlush(child);
	return  rep.findAll();
	}
	@Override
	public List<Child> getAllChild() {
		return rep.findAll();
	}
	@Override
	@Transactional
	public List<Child> findByChildId(int childId) {
		 return rep.findByChildId(childId);
		
	}
	@SuppressWarnings("rawtypes")
	@Override
	public ResponseEntity<Child> validatePassword(String username, String password) throws InvalidUserException {
		Supplier s1= ()->new InvalidUserException ("Invalid User Name and Password!");
		ResponseEntity<Child> a= rep.validatePassword(username, password);
		return a;
	}
	
}

