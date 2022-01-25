package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Book;
import com.cg.exception.BookNotFoundException;



@Service
public interface BookService {
	public Book insertBook(Book book);

	public List<Book> updateBook(Book book);

	public List<Book> deleteBookById(Integer bookId);

	public List<Book> getAllBook();

    public List<Book> findBybookId(int bookId) throws BookNotFoundException;

    public List<Book> findBybooktitle(String title) throws BookNotFoundException;

    public List<Book> findBybookauthor(String author) throws BookNotFoundException;
	
	
}
