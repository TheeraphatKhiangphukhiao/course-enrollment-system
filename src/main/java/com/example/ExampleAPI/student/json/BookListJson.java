package com.example.ExampleAPI.student.json;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.example.ExampleAPI.student.model.Book;
import com.example.ExampleAPI.student.model.Student;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString; 

@Setter
@Getter
@ToString
public class BookListJson {
	private long id;
	private Student student;
	private String bookName;
	private LocalDateTime createdAt;
	
	public static BookListJson packJson(Book book) {
		BookListJson blj = new BookListJson();
		blj.setId(book.getId());
		blj.setStudent(book.getStudent());
		blj.setBookName(book.getBookName());
		blj.setCreatedAt(book.getCreatedAt());
		
		return blj;
	}
	
	public static List<BookListJson> packJsons(List<Book> books) {
		List<BookListJson> blj = new ArrayList<BookListJson>();
		for (Book book : books) {
			blj.add(packJson(book));
		}
		return blj;
	}
}
