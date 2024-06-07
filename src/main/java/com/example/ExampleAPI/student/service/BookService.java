package com.example.ExampleAPI.student.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.repository.BookRepository;
import com.example.ExampleAPI.student.service.impl.IBook;

@Service
public class BookService implements IBook{
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> findAllBooks() {
		// TODO Auto-generated method stub
		return bookRepository.findAll();
	}

	@Override
	public Book findById(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> findByStudentId(long id) {
		// TODO Auto-generated method stub
		return bookRepository.findByStudentId(id);
	}

	@Override
	public Book findByBookNameContaining(String bookName) {
		// TODO Auto-generated method stub
		return bookRepository.findByBookNameContaining(bookName);
	}

	@Override
	public Book save(Book std) {
		// TODO Auto-generated method stub
		return bookRepository.save(std);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(id);  
	}
	public Optional<Book> findOptionalById(long id) {
		return bookRepository.findOptionalById(id);
	}
}
