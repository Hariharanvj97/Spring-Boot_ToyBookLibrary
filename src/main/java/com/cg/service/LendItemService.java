package com.cg.service;

import org.springframework.stereotype.Service;

import com.cg.entity.LendItems;

import java.util.List;
import java.util.Optional;
@SuppressWarnings("unused")
@Service
public interface LendItemService {

	public LendItems insertLendItems(LendItems item);
	public List<LendItems> updateLendItems(LendItems items);
	public List<LendItems> deleteLendItems(Integer lendId);
	public List<LendItems> viewAllLendings();
	public List<LendItems> findBylendId(int lendId);


}
