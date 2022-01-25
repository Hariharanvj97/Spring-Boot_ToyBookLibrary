package com.cg.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@SuppressWarnings("unused")
@Entity
public class MembershipType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="membershipType_id")
	private int membershipTypeId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="duration_months")
	private int durationMonths;
	
	@Column(name="price")
	private float price;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "member")
	List<Payment> payment;
	
	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	
	public MembershipType() {
		super();
	}

	public int getMembershipTypeId() {
		return membershipTypeId;
	}

	public void setMembershipTypeId(int membershipTypeId) {
		this.membershipTypeId = membershipTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDurationMonths() {
		return durationMonths;
	}

	public void setDurationMonths(int durationMonths) {
		this.durationMonths = durationMonths;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "MembershipType [membershipTypeId=" + membershipTypeId + ", description=" + description
				+ ", durationMonths=" + durationMonths + ", price=" + price + "]";
	}	

}
