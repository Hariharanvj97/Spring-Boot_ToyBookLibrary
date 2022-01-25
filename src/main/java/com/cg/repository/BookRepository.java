package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findBybookId(int bookId);

	@Query("SELECT b FROM Book b  WHERE b.title=?1") 
	List<Book> findBybooktitle(String title);

	@Query("SELECT c FROM Book c  WHERE c.author=?1") 
	List<Book> findBybookauthor(String author);
   
	
	 

	
}
