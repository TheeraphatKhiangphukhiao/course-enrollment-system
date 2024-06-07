package com.example.ExampleAPI.student.business;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ExampleAPI.student.json.EnrolmentListJson;
import com.example.ExampleAPI.student.model.Enrolment;
import com.example.ExampleAPI.student.payload.EnrolmentPayload;
import com.example.ExampleAPI.student.service.EnrolmentService;

@Service
public class EnrolmentBusiness {
	@Autowired
	EnrolmentService enrolmentService;
	
	public List<EnrolmentListJson> getEnrolmentByStudentId(long id) {
		return EnrolmentListJson.packJsons(enrolmentService.findByStudentId(id));
	}
	public void saveEnrolment(EnrolmentPayload enrolmentPayload) {
		Enrolment enrolment = new Enrolment(
				enrolmentPayload.getStudentId(), 
				enrolmentPayload.getCourseId()
				);
		enrolmentService.save(enrolment);
	}
	public void updateEnrolment(long id, EnrolmentPayload enrolmentPayload) {
		Enrolment enrolment = enrolmentService.findById(id);
		enrolment.setStudent(enrolmentPayload.getStudentId());
		enrolment.setCourse(enrolmentPayload.getCourseId());
		
		enrolmentService.save(enrolment);
	}
	public void deleteEnrolment(long id) {
		enrolmentService.deleteById(id);
	}
}
