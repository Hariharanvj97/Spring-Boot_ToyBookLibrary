package com.cg;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.entity.Payment;
import com.cg.repository.PaymentRepository;
import com.cg.service.PaymentService;

@SuppressWarnings("unused")
@SpringBootTest
class PaymentTesting {

	@Autowired
	PaymentService PaymentService;
	@MockBean
	PaymentRepository paymentRepo;
	@Test
	void testinsertpayment() {
		Payment d1=new Payment();
	
	d1.setPaymentId(1);

	
	String startDate = " 2011-01-18 00:00:00.0"; 
	SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
	java.util.Date date = null;
	try {
		date = dt.parse(startDate);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
		System.out.println(dt1.format(date));

	
		String endDate = " 2011-02-18 00:00:00.0"; 
		SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		@SuppressWarnings("unused")
		java.util.Date date1 = null;
		try {
			date1 = dt2.parse(endDate);
	}
	catch (ParseException e) {
		e.printStackTrace();
	}
		

		List<Payment> paymentList = new ArrayList<>();
		paymentList.add(d1);
		
		
		Mockito.when(paymentRepo.findAll()).thenReturn(paymentList);
		
		assertThat(PaymentService.getAllPayment()).isEqualTo(paymentList);
	}
	
	@Test
	void testdeletepayment() {
		Payment d1=new Payment();
		
		String startDate = " 2011-01-18 00:00:00.0"; 
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
		Date date = null;
		try {
			date = dt.parse(startDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
			SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-mm-dd");
			System.out.println(dt1.format(date));

		
			String endDate = " 2011-02-18 00:00:00.0"; 
			SimpleDateFormat dt2 = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
			@SuppressWarnings("unused")
			java.util.Date date1 = null;
			try {
				date1 = dt2.parse(endDate);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
			
		Optional<Payment> d2=Optional.of(d1);
		
		Mockito.when(paymentRepo.findById(1)).thenReturn(d2);
		 Mockito.when(paymentRepo.existsById(d1.getPaymentId())).thenReturn(false);
		   assertFalse(paymentRepo.existsById(d1.getPaymentId()));
	}


}