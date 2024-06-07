package com.example.ExampleAPI.student.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ExampleAPI.student.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Book findById(long id);
	List<Book> findByStudentId(long id);
	Book findByBookNameContaining(String bookName);
	Optional<Book> findOptionalById(long id);
}
