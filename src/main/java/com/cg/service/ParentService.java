package com.cg.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cg.entity.Admin;
import com.cg.entity.Parent;
import com.cg.exception.InvalidUserException;

@SuppressWarnings("unused")
@Service
public interface ParentService {
	public Parent insertParent(Parent parent);

	public List<Parent> updateParent(Parent parent);

	public List<Parent> deleteParentById(Integer parentId);

	public List<Parent> getAllParent();

public List<Parent> findByparentId(int parentId);

public ResponseEntity<Parent> validatePassword(String username, String password)throws InvalidUserException;
}
