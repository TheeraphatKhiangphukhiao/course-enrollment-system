package com.example.ExampleAPI.student.json;
import java.util.ArrayList;
import java.util.List;
import com.example.ExampleAPI.student.model.Student;
import com.example.ExampleAPI.student.model.StudentIDCard;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StudentIDCardListJson {
	private long id;
	private Student student;
	private String cardNumber;
	
	public static StudentIDCardListJson packJson(StudentIDCard studentIdCard) {
		StudentIDCardListJson sIdlj = new StudentIDCardListJson();
		sIdlj.setId(studentIdCard.getId());
		sIdlj.setStudent(studentIdCard.getStudent());
		sIdlj.setCardNumber(studentIdCard.getCardNumber());
		
		return sIdlj;
	}
	
	public static List<StudentIDCardListJson> packJsons(List<StudentIDCard> studentIdCards) {
		List<StudentIDCardListJson> studentIdCardListJson = new ArrayList<StudentIDCardListJson>();
		for (StudentIDCard studentIdCard : studentIdCards) {
			studentIdCardListJson.add(packJson(studentIdCard));
		}
		return studentIdCardListJson;
	}
}
