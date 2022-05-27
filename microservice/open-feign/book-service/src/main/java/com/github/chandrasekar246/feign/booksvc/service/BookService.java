package com.github.chandrasekar246.feign.booksvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.feign.booksvc.model.Book;
import com.github.chandrasekar246.feign.booksvc.repo.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo repo;

	public Optional<Book> add(Book user) {
		return repo.create(user);
	}

	public Optional<Book> findById(int id) {
		return repo.findById(id);
	}

	public List<Book> findAll() {
		return repo.findAll();
	}

	public List<Book> borrowBook(Integer userId, Integer bookId) {
		return repo.borrowBook(userId, bookId);
	}
	
	public List<Book> returnBook(Integer userId, Integer bookId) {
		return repo.returnBook(userId, bookId);
	}
}
