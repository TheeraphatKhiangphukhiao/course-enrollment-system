package com.example.ExampleAPI.student.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.json.BookListJson;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.payload.BookPayload;
import com.example.ExampleAPI.student.service.BookService;
 
@Service
public class BookBusiness {
	@Autowired
	BookService bookService;
	
	public List<BookListJson> getBookByStudentId(long id) {
		return BookListJson.packJsons(bookService.findByStudentId(id)); 
	}
	public void saveBook(BookPayload bookPayload) {
		Book book = new Book(
				bookPayload.getStudentId(),
				bookPayload.getBookName()
				);
		bookService.save(book);
	}
	public void updateBook(long id, BookPayload bookPayload) {
		Book book = bookService.findById(id);
		book.setStudent(bookPayload.getStudentId());
		book.setBookName(bookPayload.getBookName());
		
		bookService.save(book);
	}
	public void deleteBook(long id) {
		bookService.deleteById(id); 
	}
}
