package com.github.chandrasekar246.feign.usersvc.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.chandrasekar246.feign.usersvc.model.Book;

@FeignClient(name = "book-service", url = "http://localhost:8081/book-service/books")
public interface BookServiceClient {

	@GetMapping("/take")
	public List<Book> take(@RequestParam Integer userId, @RequestParam Integer bookId);

}
