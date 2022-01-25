package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

	List<Payment> findBypaymentId(int paymentId);

	@Query("SELECT p FROM Parent p WHERE p.parentId=?1")
	List<Payment> findpaymentByParentId(int parentId); 
	

}
