package com.github.chandrasekar246.feign.booksvc.repo;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.feign.booksvc.model.Book;

@Repository
public class BookRepo {
	private static final List<Book> libraryBooks = new ArrayList<>();

	private static final Random random = new SecureRandom();

	private static final int BOUND = 100;

	private static final Map<Integer, List<Book>> usersWithBooks = new HashMap<>();

	static {
		libraryBooks.addAll(Arrays.asList(new Book(random.nextInt(BOUND), "Let us C", "ISBN-001", true),
				new Book(random.nextInt(BOUND), "Introduction to C++", "ISBN-002", true)));
	}

	public Optional<Book> create(Book user) {
		user.setId(random.nextInt(BOUND));
		boolean status = libraryBooks.add(user);
		if (status) {
			return Optional.of(user);
		}
		return Optional.empty();
	}

	public Optional<Book> findById(int id) {
		return libraryBooks.stream().filter(p -> p.getId() == id).findFirst();
	}

	public List<Book> findAll() {
		return libraryBooks;
	}

	public List<Book> borrowBook(Integer userId, Integer bookId) {
		Optional<Book> optional = libraryBooks.stream().filter(p -> p.getId().equals(bookId)).findFirst();

		if (optional.isPresent() && optional.get().isAvailable()) {
			Iterator<Book> iterator = libraryBooks.iterator();

			while (iterator.hasNext()) {
				Book book = iterator.next();
				
				if (book.getId().equals(bookId)) {
					book.setAvailable(false);
					break;
				}
			}

			List<Book> booksTaken = usersWithBooks.get(userId);
			
			if (Objects.isNull(booksTaken)) {
				booksTaken = new ArrayList<>();
			}
			
			booksTaken.add(optional.get());
			usersWithBooks.put(userId, booksTaken);
		}

		return usersWithBooks.get(userId);
	}
	
	public List<Book> returnBook(Integer userId, Integer bookId) {
		Optional<Book> optional = libraryBooks.stream().filter(p -> p.getId().equals(bookId)).findFirst();

		if (optional.isPresent() && !optional.get().isAvailable()) {
			Iterator<Book> iterator = libraryBooks.iterator();

			while (iterator.hasNext()) {
				Book book = iterator.next();
				
				if (book.getId().equals(bookId)) {
					book.setAvailable(true);
					break;
				}
			}

			List<Book> booksTaken = usersWithBooks.get(userId);
			booksTaken.remove(optional.get());
			usersWithBooks.put(userId, booksTaken);
		}

		return usersWithBooks.get(userId);
	}

}