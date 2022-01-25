package com.cg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Payment;
import com.cg.exception.PaymentNotFoundException;
import com.cg.service.PaymentService;

@RestController
@CrossOrigin
@RequestMapping(value = "/payment")
public class PaymentController {
	@Autowired
	PaymentService paymentservice;
	
	@PostMapping(value = "/insertpayment",consumes = "application/json",produces = "application/json")
	 ResponseEntity<Payment> insertPayment(@RequestBody Payment a)
	{	
		@SuppressWarnings("unused")
		Payment id= paymentservice.insertPayment(a);
		System.out.println("Payment has been created");
		return ResponseEntity.ok(a);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/viewpayment")
	public ResponseEntity<List<Payment>> getAllPayment(){
		List<Payment> payment= paymentservice.getAllPayment();
		if(payment.isEmpty()) {
			return new ResponseEntity("Sorry! Payment not found!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewpaymentById/{paymentId}")
	public ResponseEntity<List<Payment>> getAllBypaymentId(@PathVariable("paymentId")int paymentId)throws PaymentNotFoundException{
		List<Payment> payment= paymentservice.findBypaymentId(paymentId);
		if(payment.isEmpty()) {
			return new ResponseEntity("Sorry! Payment not found!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewpaymentByParentId/{parentId}")
	public ResponseEntity<List<Payment>> getpaymentByParentId(@PathVariable("parentId")int parentId)throws PaymentNotFoundException{
		List<Payment> payment= paymentservice.findpaymentByParentId(parentId);
		if(payment.isEmpty()) {
			return new ResponseEntity("Sorry! Payment not found!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@DeleteMapping("/deletepayment/{paymentId}")
	public ResponseEntity<List<Payment>> deletePayment(@PathVariable("paymentId")Integer paymentId){
		List<Payment> payment= paymentservice.deletePaymentById(paymentId);
		if(payment.isEmpty() || payment==null) {
			return new ResponseEntity("Sorry! PaymentId not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Payment>>(payment, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/updatepayment")
	public ResponseEntity<List<Payment>> updatePayment(@RequestBody Payment payment){
		System.out.println(payment);
		List<Payment>a= paymentservice.updatePayment(payment);
		if(a.isEmpty())
		{
			return new ResponseEntity("Sorry! Products not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Payment>>(a, HttpStatus.OK);
	}
}
