package com.takeo.service;

import java.util.List;

import com.takeo.entity.Book;
import com.takeo.exception.RecordNotFoundException;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public Book addBook(Book book);
	
	public Book saveOrUpdateShop(Book book);
	
	public boolean deleteBook(Integer id);
	
	Book getBookById(Integer id)throws RecordNotFoundException;
	

}
