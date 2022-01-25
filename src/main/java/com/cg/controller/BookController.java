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
import com.cg.entity.Book;
import com.cg.exception.BookNotFoundException;
import com.cg.service.BookService;

@RestController
@CrossOrigin
@RequestMapping(value = "/book")

public class BookController {

	@Autowired
	 BookService bookservice;
	
	@PostMapping(value = "/insertBook",consumes = "application/json",produces = "application/json")
	ResponseEntity<Book> insertBook(@RequestBody Book b)
	{
	
	@SuppressWarnings("unused")
	Book id= bookservice.insertBook(b);
	System.out.println("book has been created");
	return ResponseEntity.ok(b);
}
	
	@PutMapping("/books")
	 @SuppressWarnings({ "unchecked", "rawtypes" }) 
	
	public ResponseEntity<List<Book>> updateBook(
			@RequestBody Book book){
		System.out.println(book);
		List<Book> books= bookservice.updateBook(book);
		if(books.isEmpty())
		{
			return new ResponseEntity("Sorry! Books not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/deletebook/{bookId}")
	public ResponseEntity<List<Book>> deleteBookById(@PathVariable("bookId")Integer bookId){
		List<Book> book= bookservice.deleteBookById(bookId);
		if(book.isEmpty() || book==null) {
			return new ResponseEntity("Sorry! BookId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewbooks")
	public ResponseEntity<List<Book>> getAllBook(){
		List<Book> book= bookservice.getAllBook();
		if(book.isEmpty()) {
			return new ResponseEntity("Sorry! Books not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewbooksById/{bookId}")
	public ResponseEntity<List<Book>> getAllBybookId(@PathVariable("bookId")int bookId) throws BookNotFoundException {
		List<Book> book= bookservice.findBybookId(bookId);
		if(book.isEmpty()) {
			return new ResponseEntity("Sorry! Books not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}
	
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewBooksByTitle/{title}")
	public ResponseEntity<List<Book>> getAllBytitle(@PathVariable("title")String title) throws BookNotFoundException {
		List<Book> book= bookservice.findBybooktitle(title);
		if(book.isEmpty()) {
			return new ResponseEntity("Sorry! Books not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/viewBooksByAuthor/{author}")
	public ResponseEntity<List<Book>> getAllByauthor(@PathVariable("author")String author) throws BookNotFoundException {
		List<Book> book= bookservice.findBybookauthor(author);
		if(book.isEmpty()) {
			return new ResponseEntity("Sorry! Books not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
	}
	
}
