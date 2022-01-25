package com.cg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Parent {
	@Id
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="parent_id")
private int parentId;
	 @Column(name="user_name")
	 private String username;
	 @Column(name="password")
	 private String password;
	@Column(name="gender")
  	private String gender;
  @Column(name="mobile_number")
  	private String mobile;
  	@Column(name="email_id")
  	private String email;
	@Column(name="address")
  	private String address;
	@Column(name="card_no")
private String cardNo;
	@Column(name="upi_no")
private String upiNo;
	

	@OneToOne(cascade = CascadeType.ALL)
	Child child;

 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "parent")
	    List<Payment> payment;


	public Parent() {
		super();
	}


	public Parent(int parentId, String username, String password, String gender, String mobile, String email,
			String address, String cardNo, String upiNo, Child child, List<Payment> payment) {
		super();
		this.parentId = parentId;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
		this.cardNo = cardNo;
		this.upiNo = upiNo;
		this.child = child;
		this.payment = payment;
	}


	public int getParentId() {
		return parentId;
	}


	public void setParentId(int parentId) {
		this.parentId = parentId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCardNo() {
		return cardNo;
	}


	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	public String getUpiNo() {
		return upiNo;
	}


	public void setUpiNo(String upiNo) {
		this.upiNo = upiNo;
	}


	public Child getChild() {
		return child;
	}


	public void setChild(Child child) {
		this.child = child;
	}


	public List<Payment> getPayment() {
		return payment;
	}


	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}


	@Override
	public String toString() {
		return "Parent [parentId=" + parentId + ", username=" + username + ", password=" + password + ", gender="
				+ gender + ", mobile=" + mobile + ", email=" + email + ", address=" + address + ", cardNo=" + cardNo
				+ ", upiNo=" + upiNo + "]";
	}

	
	
	
	}
	
	
	
	



