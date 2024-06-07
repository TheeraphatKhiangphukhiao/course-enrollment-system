package com.example.ExampleAPI.student.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ExampleAPI.student.model.StudentIDCard;
 
@Repository
public interface StudentIDCardRepository extends JpaRepository<StudentIDCard, Long>{
	StudentIDCard findById(long id);
	StudentIDCard findByStudentId(long id);
	StudentIDCard findByCardNumberContaining(String number);
	Optional<StudentIDCard> findOptionalById(long id);
}
