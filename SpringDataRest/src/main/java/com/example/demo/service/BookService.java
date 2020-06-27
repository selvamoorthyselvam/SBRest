package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	
	BookRepository bookRepo;
	
	//get all records and based on the year of publication
	public List<Book> getBooks(Set<Integer> yop,String bookType) {
		List<Book> bookList=new ArrayList<>();
		if(yop == null) {
			bookRepo.findAll().forEach(book->bookList.add(book));
		}else {
			return bookRepo.findAllByYearOfPublicationInAndBookType(yop,bookType);
		}
		return bookList;
	}
	
	//Create single book
	public Book createBook(Book book) {
		return bookRepo.save(book);	
	}
	
	//findById
	public Optional<Book> getBookById(Integer bookId) {
		return bookRepo.findById(bookId);
	}

	//save and update
	public Book saveAndUpdateBookDeatiles(Book book) {
		return bookRepo.save(book);
	}

	//Delete book by Id
	public String deleteBookById(Integer bookId) {
		bookRepo.deleteById(bookId);
		return "Deleted Successfully";
	}

	public List<Book> getBooksByRawQuery(Set<Integer> yop) {
		List<Book> bookList=bookRepo.findAllByYearOfPublicationIn(yop);
		return bookList;
	}
}
