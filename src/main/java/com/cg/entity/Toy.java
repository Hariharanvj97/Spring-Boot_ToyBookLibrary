package com.cg.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("unused")
@Entity
@Table(name="toy")

public class Toy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name="toy_id")
	private int toyId;
	@Column(name="name")
	private String name;
	@Column(name="category")
	private String category;
	@Column(name="company")
	private String company;
	@Column(name="price")
	private double price;
	@Column(name="availabletoys")
	private int availabletoys;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "toy")
	@JsonIgnore
	List<LendItems> lenditems;
	
	public List<LendItems> getLenditems() {
		return lenditems;
	}
	public void setLenditems(List<LendItems> lenditems) {
		this.lenditems = lenditems;
	}
	public Toy() {
		super();
	}
	
	public Toy(int toyId, String name, String category, String company, double price, int availabletoys,
			List<LendItems> lenditems) {
		super();
		this.toyId = toyId;
		this.name = name;
		this.category = category;
		this.company = company;
		this.price = price;
		this.availabletoys = availabletoys;
		this.lenditems = lenditems;
	}
	
	public int getToyId() {
		return toyId;
	}
	public void setToyId(int toyId) {
		this.toyId = toyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAvailabletoys() {
		return availabletoys;
	}
	public void setAvailabletoys(int availabletoys) {
		this.availabletoys = availabletoys;
	}
	@Override
	public String toString() {
		return "Toy [toyId=" + toyId + ", name=" + name + ", category=" + category + ", company=" + company + ", price="
				+ price + ", availabletoys=" + availabletoys + ", lenditems=" + lenditems + "]";
	}
	
	
	}