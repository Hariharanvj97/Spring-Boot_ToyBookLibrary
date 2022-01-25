package com.cg.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Book;
import com.cg.exception.BookNotFoundException;
import com.cg.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookRepository repo;
	@Override
	public Book insertBook(Book book) {
		repo.save(book);
		return book;	
	}
	@Override
	public List<Book> updateBook(Book book) {
		repo.saveAndFlush(book);
		return  repo.findAll();
	}
	@Override
	public List<Book> deleteBookById(Integer bookId) {
		repo.deleteById(bookId);
		return  repo.findAll();	
	}
	@Override
	public List<Book> getAllBook() {
		return repo.findAll();
	}

	@SuppressWarnings("unused")
	@Override
	public List<Book> findBybookId(int bookId) throws BookNotFoundException {
		@SuppressWarnings("rawtypes")
		Supplier s1= ()->new BookNotFoundException ("bookId Does not exist in the database");
		List<Book> b=repo.findBybookId(bookId);//custom methods of repository
		return b;
	}
    @SuppressWarnings("unused")
	@Override
	public List<Book> findBybooktitle(String title) throws BookNotFoundException {
		@SuppressWarnings("rawtypes")
		Supplier s1= ()->new BookNotFoundException ("book Does not exist in the database");
		List<Book> b=repo.findBybooktitle(title);//custom methods of repository
		return b;
	}
	@SuppressWarnings("unused")
	@Override
	public List<Book> findBybookauthor(String author) throws BookNotFoundException {
		@SuppressWarnings("rawtypes")
		Supplier s1= ()->new BookNotFoundException ("book Does not exist in the database");
		List<Book> c=repo.findBybookauthor(author);//custom methods of repository
		return c;
	}
}
