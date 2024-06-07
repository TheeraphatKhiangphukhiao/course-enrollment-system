package com.example.ExampleAPI.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity(name = "Student")
@Table(
		name = "student",
		uniqueConstraints = {
				@UniqueConstraint(name = "student_email_unique", columnNames = "email")
		}
)

public class Student {
	
	// Attribute ของ class
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	// ข้อมูลชนิด Long คือ primary key
	private Long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	// Constructor ของ class ที่ไม่กำหนด parameters (เผื่อได้ใช้)
	public Student() {
		;
	}
	
	// Constructor ของ class ที่กำหนด parameters ให้กับ class
	public Student(String firstName, String lastName, String email, Integer age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
	}

	// Methods getters และ setters ต่างๆ
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
}

