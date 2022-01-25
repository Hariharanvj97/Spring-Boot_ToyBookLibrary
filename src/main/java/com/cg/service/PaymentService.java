package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Payment;
import com.cg.exception.PaymentNotFoundException;
@Service
public interface PaymentService {

	Payment insertPayment(Payment a);

	List<Payment> getAllPayment();

	List<Payment> findBypaymentId(int paymentId) throws PaymentNotFoundException;

	List<Payment> deletePaymentById(Integer paymentId);

	List<Payment> updatePayment(Payment payment);

	List<Payment> findpaymentByParentId(int parentId);

}
