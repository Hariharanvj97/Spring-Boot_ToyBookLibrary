package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.repository.LendItemRepository;
import com.cg.entity.LendItems;
@SuppressWarnings("unused")
@Service
public class LendItemServiceImpl implements LendItemService {
@Autowired
LendItemRepository repo;
	public LendItems insertLendItems(LendItems item) {
		 return repo.save(item);
		//return item;
	}

	public List<LendItems> updateLendItems(LendItems items) {
		// TODO Auto-generated method stub
		repo.saveAndFlush(items);
		return (List<LendItems>) repo.findAll();
	}

	public List<LendItems> deleteLendItems(Integer lendId) {
		repo.deleteById(lendId);
		return repo.findAll();
	}

	public List<LendItems> viewAllLendings() {
		
		return repo.findAll();
	}

	@Override
	public List<LendItems> findBylendId(int lendId) {
		List<LendItems> b=repo.findBylendId(lendId);//custom methods of repository
		return b;

	}
	
}
