package com.sb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sb.constants.GlobalConstants;
import com.sb.pojo.Student;
import com.sb.services.StudentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(GlobalConstants.STUDENT_CONTROLLER_MAPPING)
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(path=GlobalConstants.STUDENT_GET_ALL)
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	@PostMapping(path=GlobalConstants.STUDENT_ADD)
	public Student addStudent(@RequestBody Student student) {
		log.info("Student comes from UI >>>>>" + student);
		return studentService.addStudent(student);
	}

	@GetMapping(path = "/getStudentById/{studentId}")
	public Optional<Student> getStudentById(@PathVariable Integer studentId) {
		log.info("id from uri"+studentId);
		return studentService.getStudentById(studentId);
	}

	@PutMapping(path = "/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		log.info("Student comes from UI >>>>>" + student);
		return studentService.updateStudent(student);
	}

	@DeleteMapping(path = "/deleteStudentById/{studentId}")
	public void deleteStudentById(@PathVariable Integer studentId) {
		log.info("Student comes from UI >>>>>" + studentId);
		studentService.deleteStudentById(studentId);
	}

}
