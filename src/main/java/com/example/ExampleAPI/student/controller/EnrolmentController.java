package com.example.ExampleAPI.student.controller;
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
import com.example.ExampleAPI.student.business.EnrolmentBusiness;
import com.example.ExampleAPI.student.exception.BaseException;
import com.example.ExampleAPI.student.json.EnrolmentListJson;
import com.example.ExampleAPI.student.model.Enrolment;
import com.example.ExampleAPI.student.payload.EnrolmentPayload;
import com.example.ExampleAPI.student.service.EnrolmentService;

@RestController
@RequestMapping("/api")
public class EnrolmentController {
	
	@Autowired
	EnrolmentService enrolmentService;
	
	@Autowired
	EnrolmentBusiness enrolmentBusiness;
	
	public EnrolmentController(EnrolmentService enrolmentService) {
		this.enrolmentService = enrolmentService;
	}
	
	@PostMapping(value = "/enrolment")
	public ResponseEntity<Void> saveEnrolment(@RequestBody EnrolmentPayload enrolmentPayload) throws BaseException {
		enrolmentBusiness.saveEnrolment(enrolmentPayload);
		return new ResponseEntity<>(HttpStatus.CREATED); 
	}
	
	@PutMapping(value = "/enrolment/{id}")
	public ResponseEntity<EnrolmentListJson> updateEnrolment(@PathVariable("id") long id, @RequestBody EnrolmentPayload enrolmentPayload) {
		Optional<Enrolment> enrolment = enrolmentService.findOptionalById(id);
		if(enrolment.isPresent()) {
			enrolmentBusiness.updateEnrolment(enrolment.get().getId(), enrolmentPayload);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(value = "/enrolment/{id}")
	public ResponseEntity<HttpStatus> deleteEnrolment(@PathVariable("id") long id) {
		try {
			enrolmentBusiness.deleteEnrolment(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
