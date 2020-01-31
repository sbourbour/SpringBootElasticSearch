package com.shahriar.bookfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shahriar.bookfinder.model.Book;
import com.shahriar.bookfinder.service.BookServiceImpl;

@RestController
public class BookFinderController {
	
	@Autowired
	BookServiceImpl bookService;

	@GetMapping("/title")
	public List<Book> findByTitle(@RequestParam String title) {
		 return bookService.findByTitle(title);
	}
	
	@GetMapping("/author")
	public List<Book> findByAuthor(@RequestParam String author) {
		 return bookService.findByAuthor(author);
	}
	
	@PostMapping("/books/save")
	public Book saveBook(@RequestBody Book book) {
		return bookService.save(book);
	}
	
	@PostMapping("/books/delete")
	public void deleteBook(@RequestBody Book book) {
		bookService.delete(book);
	}
}
