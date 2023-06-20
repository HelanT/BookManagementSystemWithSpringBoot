package com.takeo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.takeo.entity.Book;
import com.takeo.exception.RecordNotFoundException;
import com.takeo.repo.BookRepository;
import com.takeo.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepo;

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> viewBookInfo = (List<Book>) bookRepo.findAll();
		
		return viewBookInfo;
	}

	@Override
	public Book saveOrUpdateShop(Book book) {
		// TODO Auto-generated method stub
Optional<Book> findById = bookRepo.findById(book.getBookId());
		
		Book b = findById.get();
		
		b=bookRepo.save(b);
		return b;
	}

	@Override
	public boolean deleteBook(Integer id) {
		// TODO Auto-generated method stub
Optional<Book> findById = bookRepo.findById(id);
		boolean flag=false;
		Book b = findById.get();
		if(b!=null)
		{
		bookRepo.delete(b);
		flag=true;
		}
		return flag;
	}

	@Override
	public Book getBookById(Integer id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		Optional<Book> findById = bookRepo.findById(id);
		
		Book b = findById.get();
		
		if(b!=null)
		return b;
		
		else
			throw new RecordNotFoundException("Not Found");
	}

	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		Book saveEnt = bookRepo.save(book);
		if(saveEnt!=null)
			return saveEnt;
		else
			return null;
	}

}
