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

	public Optional<Book> read(int id) {
		return repo.read(id);
	}

	public List<Book> readAll() {
		return repo.readAll();
	}

	public List<Book> takeBook(Integer userId, Integer bookId) {
		return repo.takeBook(userId, bookId);
	}
}
