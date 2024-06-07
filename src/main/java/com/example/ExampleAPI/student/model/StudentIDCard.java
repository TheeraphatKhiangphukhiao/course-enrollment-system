package com.example.ExampleAPI.student.model;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "StudentIDCard")
@Table(
		name = "student_id_cart",
		uniqueConstraints = {
				@UniqueConstraint(name = "student_card_number_unique", columnNames = "card_number")
		}
)

public class StudentIDCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Student student;
	
	@Column(name = "card_number", nullable = false, unique = true)
	private String cardNumber;

	public StudentIDCard() {
		;
	}
	
	public StudentIDCard(Student student, String cardNumber) {
		super();
		this.student = student;
		this.cardNumber = cardNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudentID() {
		return student;
	}

	public void setStudentID(Student student) {
		this.student = student;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cartNumber) {
		this.cardNumber = cartNumber;
	}
}

