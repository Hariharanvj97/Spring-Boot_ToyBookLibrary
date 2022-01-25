package com.cg;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entity.Book;
import com.cg.repository.BookRepository;
import com.cg.service.BookService;

@SpringBootTest
class BookTesting {
	@Autowired
	BookService bookService;
	@MockBean
	BookRepository bookRepo;

	@Test
	void testinsertBook() { 
		Book b1=new Book();
		
		b1.setBookId(1);
		b1.setTitle("The Knight");
		b1.setPrice((float) 999.50);
		b1.setAuthor("ChetanBhagat");
		b1.setCategory("Thriller");
		b1.setPublication("ABC Publication");
		b1.setAvailablebooks(1);
		
		
	    Mockito.when(bookRepo.save(b1)).thenReturn(b1);		
		assertThat(bookService.insertBook(b1)).isEqualTo(b1);
	}
	
	//getallbooks
	@Test
	void testviewbooks() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setTitle("The Knight");
		b1.setPrice((float) 999.50);
		b1.setAuthor("ChetanBhagat");
		b1.setCategory("Thriller");
		b1.setPublication("ABC Publication");
		b1.setAvailablebooks(1);
		
		Book b2=new Book();
		
		b2.setBookId(2);
		b2.setTitle("Women Empowerment");
		b2.setPrice((float) 898.50);
		b2.setAuthor("Malala");
		b2.setCategory("Novel");
		b2.setPublication("XYZ Publication");
		b2.setAvailablebooks(1);
	
		List<Book> bookList = new ArrayList<>();
		bookList.add(b1);
		bookList.add(b2);
		
		Mockito.when(bookRepo.findAll()).thenReturn(bookList);
		
		assertThat(bookService.getAllBook()).isEqualTo(bookList);
	}
	
	//update
	@Test
	boolean testbooks() throws Throwable {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setTitle("The Knight");
		b1.setPrice((float) 999.50);
		b1.setAuthor("ChetanBhagat");
		b1.setCategory("Thriller");
		b1.setPublication("ABC Publication");
		b1.setAvailablebooks(1);
		
		
		Optional<Book> b2=Optional.of(b1);
		
		Mockito.when(bookRepo.findById(1)).thenReturn(b2);
		
		Mockito.when(bookRepo.save(b1)).thenReturn(b1);
		b1.setTitle("Wings of Fire");
		b1.setAuthor("Ayesha");
		
		assertThat(bookService.updateBook(b1)).isEqualTo(b1);
		return true;
	}

	//delete
	@Test
	void testdeletebook() {
		Book b1=new Book();
		b1.setBookId(1);
		b1.setTitle("The Knight");
		b1.setPrice((float) 999.50);
		b1.setAuthor("ChetanBhagat");
		b1.setCategory("Thriller");
		b1.setPublication("ABC Publication");
		b1.setAvailablebooks(1);
		
		
		Optional<Book> b2=Optional.of(b1);
		
		Mockito.when(bookRepo.findById(1)).thenReturn(b2);
		 Mockito.when(bookRepo.existsById(b1.getBookId())).thenReturn(false);
		   assertFalse(bookRepo.existsById(b1.getBookId()));
	}


}


	


