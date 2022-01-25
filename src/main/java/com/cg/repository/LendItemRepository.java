package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cg.entity.LendItems;


@SuppressWarnings("unused")
public interface LendItemRepository extends JpaRepository <LendItems,Integer>{

	List<LendItems> findBylendId(int lendId);
	 

}
