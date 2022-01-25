package com.cg.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private float price;
	
	@Column(name="author")
	private String author;
	
	@Column(name="category")
	private String category;
	
	@Column(name="publication")
	private String publication;
	
	@Column(name="availablebooks")
	private int availablebooks;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
	@JsonIgnore
	List<LendItems> lenditems;
	
	public List<LendItems> getLenditems() {
		return lenditems;
	}
	public void setLenditems(List<LendItems> lenditems) {
		this.lenditems = lenditems;
	}
	
	public Book() {
		super();
	}
	

	public Book(int bookId, String title, float price, String author, String category, String publication,
			int availablebooks, List<LendItems> lenditems) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.price = price;
		this.author = author;
		this.category = category;
		this.publication = publication;
		this.availablebooks = availablebooks;
		this.lenditems = lenditems;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", author=" + author + ", category="
				+ category + ", publication=" + publication + ", availablebooks=" + availablebooks + ", lenditems="
				+ lenditems + "]";
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public int getAvailablebooks() {
		return availablebooks;
	}
	public void setAvailablebooks(int availablebooks) {
		this.availablebooks = availablebooks;
	}

	
}
