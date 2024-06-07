package com.example.ExampleAPI.student.controller;
import com.example.ExampleAPI.student.model.Book;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ExampleAPI.student.business.BookBusiness;
import com.example.ExampleAPI.student.exception.BaseException;
import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	BookBusiness bookBusiness;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping(value = "/book")
	public ResponseEntity<Void> saveBook(@RequestBody BookPayload bookPayload) throws BaseException {
		bookBusiness.saveBook(bookPayload);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
	@PutMapping(value = "/book/{id}")
	public ResponseEntity<BookListJson> updateBook(@PathVariable("id") long id, @RequestBody BookPayload bookPayload) {
		Optional<Book> book = bookService.findOptionalById(id);
		if(book.isPresent()) {
			bookBusiness.updateBook(book.get().getId(), bookPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/book/{id}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
		try {
			bookBusiness.deleteBook(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
