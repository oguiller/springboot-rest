package com.oguiller.springboot;

import com.oguiller.springboot.config.MyExceptionHandler;
import com.oguiller.springboot.domain.Book;
import com.oguiller.springboot.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerExceptionResolver;

@SpringBootApplication
public class SpringbootApplication {

//	@Bean
//	HandlerExceptionResolver customExceptionResolver() {
//		return new MyExceptionHandler();
//	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService) {
		return args -> {
			bookService.create(
					new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(
					new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(
					new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}

}

