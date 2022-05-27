package com.github.chandrasekar246.feign.booksvc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.feign.booksvc.model.Book;
import com.github.chandrasekar246.feign.booksvc.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping
	public ResponseEntity<Book> add(@RequestBody Book book) {
		Optional<Book> optional = service.add(book);
		
		return optional.isPresent() ? new ResponseEntity<>(optional.get(), HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Integer id) {
		Optional<Book> optional = service.findById(id);
		
		return optional.isPresent() ? new ResponseEntity<>(optional.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public List<Book> findAll() {
		return service.findAll();
	}

	@GetMapping("/borrow")
	public List<Book> borrowBook(@RequestParam Integer userId, @RequestParam Integer bookId) {
		return service.borrowBook(userId, bookId);
	}
	
	@GetMapping("/return")
	public List<Book> returnBook(@RequestParam Integer userId, @RequestParam Integer bookId) {
		return service.returnBook(userId, bookId);
	}
}
