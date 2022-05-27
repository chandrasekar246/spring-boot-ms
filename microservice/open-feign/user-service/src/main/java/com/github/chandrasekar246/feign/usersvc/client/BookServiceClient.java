package com.github.chandrasekar246.feign.usersvc.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.chandrasekar246.feign.usersvc.model.Book;

//@FeignClient(name = "BOOK-SERVICE", url = "http://localhost:8081/book-service/books")
@FeignClient(name = "http://BOOK-SERVICE/book-service/books")
public interface BookServiceClient {
	
	@GetMapping("/port")
	public String port();
	
	@GetMapping
	public List<Book> findAll();

	@GetMapping("/borrow")
	public List<Book> borrowBook(@RequestParam Integer userId, @RequestParam Integer bookId);
	
	@GetMapping("/return")
	public List<Book> returnBook(@RequestParam Integer userId, @RequestParam Integer bookId);
}
