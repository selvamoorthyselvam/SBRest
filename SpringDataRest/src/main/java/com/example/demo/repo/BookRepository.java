package com.example.demo.repo;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

	List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop, String bookType);

	String rawQuery="Select * from book where year_of_publication IN :yop";

	@Query(nativeQuery = true, value = rawQuery)
	List<Book> findAllByYearOfPublicationIn(@Param("yop") Set<Integer> yop);
}
