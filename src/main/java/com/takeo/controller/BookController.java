package com.takeo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.takeo.entity.Book;
import com.takeo.exception.RecordNotFoundException;
import com.takeo.service.impl.BookServiceImpl;

@Controller
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	@RequestMapping("/")
	public String home(Book book, Model model)
	{
		List<Book> allBooks	= bookService.getAllBooks();
		
		model.addAttribute("allBooks", allBooks);
		
		return "index.html";
		
		
	}
	
	@RequestMapping("/add")
	public String showAddForm(Book book,Model model)
	{
		return "add-book.html";
	}
	
	@PostMapping("/insert")
	public String handleForm(@ModelAttribute  Book book, Model model)
	{
		Book addBook = bookService.addBook(book);
		
		return "redirect:/";
	}
	
	@RequestMapping(path = {"/delete/{id}"})
	public String delete(Model model,@PathVariable Integer id)
	{
		bookService.deleteBook(id);
		
		return"redirect:/";
		
	}
	
	@RequestMapping(path= {"/update/{id}"})
	public String update(Model model,@PathVariable("id")Integer id) throws RecordNotFoundException
	{
		Book book = bookService.getBookById(id);
		
		model.addAttribute("book", book);
		return "edit-book.html";
	}

}
