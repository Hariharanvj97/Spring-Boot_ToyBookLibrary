package com.cg.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Payment;
import com.cg.exception.PaymentNotFoundException;
import com.cg.repository.PaymentRepository;
@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentRepository repo;
	@Override
	public Payment insertPayment(Payment payment) {
		repo.save(payment);
		return payment;
	}

	@Override
	public List<Payment> getAllPayment() {
		return repo.findAll();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Payment> findBypaymentId(int paymentId) throws PaymentNotFoundException  {
		@SuppressWarnings("unused")
		Supplier s1= ()->new PaymentNotFoundException ("paymentId Does not exist in the database");
		List<Payment> a=repo.findBypaymentId(paymentId);
		return a;
	}
	@Override
	public List<Payment> deletePaymentById(Integer paymentId) {
		repo.deleteById(paymentId);
		return  repo.findAll();
	}

	@Override
	public List<Payment> updatePayment(Payment payment) {
		repo.saveAndFlush(payment);
		return  repo.findAll();
	}

	@Override
	public List<Payment> findpaymentByParentId(int parentId) {
		List<Payment> p=repo.findpaymentByParentId(parentId);
		return p;
	}

}
