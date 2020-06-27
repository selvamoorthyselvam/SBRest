package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public List<Book> getBooks(
			@RequestParam(value= "yearOfPublications", required = false) Set<Integer> yop,
			@RequestParam(value= "bookType", required = false) String bookType) {
		return bookService.getBooks(yop,bookType);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

	@RequestMapping(value = "/book/{id}")
	public Optional<Book> getBookById(@PathVariable("id") Integer bookId) {
		return bookService.getBookById(bookId);
	}
	
	@RequestMapping(value = "/books",method = RequestMethod.PUT)
	public Book saveAndUpdateBookDeatiles(@RequestBody Book book) {
		return bookService.saveAndUpdateBookDeatiles(book);
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable("id") Integer bookId) {
		return bookService.deleteBookById(bookId);
	}
	
	@GetMapping("/raw/books")
	public List<Book> getBookByRawQuery(@RequestParam("yop") Set<Integer> yop){
		return bookService.getBooksByRawQuery(yop);
	}
}
