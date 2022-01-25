package com.cg.entity;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("unused")
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	
	//@JsonFormat(pattern="dd-MM-yyyy")
	//@Transient[that field will be ignored while serialization]
	//@Temporal(TemporalType.DATE)
	private LocalDate startDate;
	
	//@JsonFormat(pattern="dd-MM-yyyy")
	//@Transient[that field will be ignored while serialization]
	//@Temporal(TemporalType.DATE)
	private LocalDate endDate;
	
	public Payment(int paymentId, LocalDate startDate, LocalDate endDate, MembershipType member, Parent parent) {
		super();
		this.paymentId = paymentId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.member = member;
		this.parent = parent;
	}



	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}



	@ManyToOne(cascade = CascadeType.ALL)
	MembershipType member;
	
	@ManyToOne(cascade = CascadeType.ALL)
	Parent parent;

	

	public int getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}



	public LocalDate getStartDate() {
		return startDate;
	}



	public void setStartDate(LocalDate date) {
		this.startDate = date;
	}



	public LocalDate getEndDate() {
		return endDate;
	}



	public void setEndDate(LocalDate date1) {
		this.endDate = date1;
	}



	public MembershipType getMember() {
		return member;
	}



	public void setMember(MembershipType member) {
		this.member = member;
	}



	public Parent getParent() {
		return parent;
	}



	public void setParent(Parent parent) {
		this.parent = parent;
	}



	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", startDate=" + startDate + ", endDate=" + endDate + ", member="
				+ member + ", parent=" + parent + "]";
	}

	

}