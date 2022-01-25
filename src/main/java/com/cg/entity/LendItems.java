package com.cg.entity;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("unused")
@Entity

@Table(name="LendItems")
public class LendItems {
	
	@Id
	@Column(name="lend_id")
	private int lendId;
	
	@Column(name= "lend_date")
	private LocalDate lendDate;
	
	@Column(name= "return_date")
	private LocalDate returnDate;
	
	@Column (name= "fine")
	private int fine;
	
	@ManyToOne
	Book book;

	@ManyToOne
	Child child;

	@ManyToOne
	Toy toy;
	
public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}

	public Toy getToy() {
		return toy;
	}

	public void setToy(Toy toy) {
		this.toy = toy;
	}

public LendItems(int lendId, LocalDate lendDate, LocalDate returnDate, int fine, Book book, Child child, Toy toy) {
		super();
		this.lendId = lendId;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.fine = fine;
		this.book = book;
		this.child = child;
		this.toy = toy;
	}

public LendItems() {
	super();
}

public int getLendId() {
	return lendId;
}

public void setLendId(int lendId) {
	this.lendId = lendId;
}

public int getFine() {
	return fine;
}

public LocalDate getLendDate() {
	return lendDate;
}

public void setLendDate(LocalDate lendDate) {
	this.lendDate = lendDate;
}

public LocalDate getReturnDate() {
	return returnDate;
}

public void setReturnDate(LocalDate returnDate) {
	this.returnDate = returnDate;
}

public void setFine(int fine) {
	this.fine = fine;
}

@Override
public String toString() {
	return "LendItems [lendId=" + lendId + ", lendDate=" + lendDate + ", returnDate=" + returnDate + ", fine=" + fine
			+ ", book=" + book + ", child=" + child + ", toy=" + toy + "]";
}

}
