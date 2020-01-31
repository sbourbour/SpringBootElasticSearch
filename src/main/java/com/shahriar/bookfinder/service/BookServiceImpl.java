package com.shahriar.bookfinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shahriar.bookfinder.model.Book;
import com.shahriar.bookfinder.repository.BookRepository;


@Service
public class BookServiceImpl {

	@Autowired
	private BookRepository bookRepository;
	
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    public List<Book> findByTitle(String title) {
    	List<Book> bookList = bookRepository.findByTitle(title); 
        return bookList;
    }
    
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

  
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void delete(Book book) {
        bookRepository.delete(book);
    }

    public Book findById(String id) {
         Optional<Book> optionalBook = bookRepository.findById(id);
         if(optionalBook.isPresent()) {
        	 return optionalBook.get();
         }
         return null;
    }

    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
    	
}
