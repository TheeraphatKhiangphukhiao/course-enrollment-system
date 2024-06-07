package com.example.ExampleAPI.student.service.impl;
import java.util.List;
import com.example.ExampleAPI.student.model.Book;

public interface IBook {
	List<Book> findAllBooks();
	Book findById(long id);
	List<Book> findByStudentId(long id);
	Book findByBookNameContaining(String bookName);
	Book save(Book std);
	void deleteById(long id);
	 
}
