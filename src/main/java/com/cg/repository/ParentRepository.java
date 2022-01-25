	
package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.cg.entity.Admin;
import com.cg.entity.Parent;
import com.cg.exception.InvalidUserException;
@SuppressWarnings("unused")
@Repository
public interface ParentRepository extends JpaRepository<Parent, Integer> {
@Query

List<Parent> findByparentId(int parentId);

@Query("SELECT a FROM Admin a WHERE a.username=?1 AND a.password=?1")
ResponseEntity<Parent> validatePassword(String username, String password)throws InvalidUserException;
	
	}
