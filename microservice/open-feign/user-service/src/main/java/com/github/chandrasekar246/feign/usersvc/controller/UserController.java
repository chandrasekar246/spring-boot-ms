package com.github.chandrasekar246.feign.usersvc.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.feign.usersvc.client.BookServiceClient;
import com.github.chandrasekar246.feign.usersvc.model.Book;
import com.github.chandrasekar246.feign.usersvc.model.User;
import com.github.chandrasekar246.feign.usersvc.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private BookServiceClient bookServiceClient;

	@PostMapping
	public ResponseEntity<User> add(@RequestBody User user) {
		Optional<User> optional = service.add(user);

		return optional.isPresent() ? new ResponseEntity<>(optional.get(), HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Integer id) {
		Optional<User> optional = service.findById(id);

		return optional.isPresent() ? new ResponseEntity<>(optional.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping
	public Set<User> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/library/port")
	public String port() {
		return bookServiceClient.port();
	}

	@GetMapping("/{userId}/library")
	public ResponseEntity<List<Book>> findAllBooks(@PathVariable Integer userId) {
		Optional<User> optional = service.findById(userId);

		if (optional.isPresent()) {
			return new ResponseEntity<>(bookServiceClient.findAll(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{userId}/library/{bookId}/borrow")
	public ResponseEntity<User> borrowBook(@PathVariable Integer userId, @PathVariable Integer bookId) {
		Optional<User> optional = service.findById(userId);

		if (optional.isPresent()) {
			User user = optional.get();

			List<Book> booksTaken = bookServiceClient.borrowBook(userId, bookId);

			user.setBooksTaken(booksTaken);

			return new ResponseEntity<>(user, HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{userId}/library/{bookId}/return")
	public ResponseEntity<User> returnBook(@PathVariable Integer userId, @PathVariable Integer bookId) {
		Optional<User> optional = service.findById(userId);

		if (optional.isPresent()) {
			User user = optional.get();

			List<Book> booksTaken = user.getBooksTaken();

			if (Objects.nonNull(booksTaken)) {
				Iterator<Book> iterator = booksTaken.iterator();

				while (iterator.hasNext()) {
					Book book = iterator.next();

					if (book.getId().equals(bookId)) {
						booksTaken = bookServiceClient.returnBook(userId, bookId);

						user.setBooksTaken(booksTaken);

						return new ResponseEntity<>(user, HttpStatus.OK);
					}
				}
			}
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
