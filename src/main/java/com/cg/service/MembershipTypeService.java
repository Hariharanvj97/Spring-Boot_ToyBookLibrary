package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.MembershipType;


@Service
public interface MembershipTypeService {
	
	public MembershipType insertMembershipType(MembershipType membershipType);

	public List<MembershipType> getAllMembershipType();

	public List<MembershipType> deleteMembershipTypeById(Integer membershipId);

	public List<MembershipType> updateMembershipType(MembershipType membership);
}
