package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.MembershipType;
import com.cg.repository.MembershipTypeRepository;

@Service
public class MembershipTypeServiceImpl implements MembershipTypeService {
	@Autowired
	MembershipTypeRepository repo;

	@Override
	public MembershipType insertMembershipType(MembershipType membershipType) {
		repo.save(membershipType);
		return membershipType;
	}

	@Override
	public List<MembershipType> getAllMembershipType() {
		return repo.findAll();
	}
	@Override
	public List<MembershipType> deleteMembershipTypeById(Integer membershipId) {
		repo.deleteById(membershipId);
		return  repo.findAll();
	}

	@Override
	public List<MembershipType> updateMembershipType(MembershipType membership) {
		repo.saveAndFlush(membership);
		return  repo.findAll();
	}

}
