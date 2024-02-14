package com.sb.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.constants.GlobalConstants;
import com.sb.pojo.Student;
import com.sb.services.StudentService;

@RestController
@RequestMapping(GlobalConstants.STUDENT_CONTROLLER_MAPPING)
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudent() {
		return studentService.getAllStudent();
	}

	
	@GetMapping(path = "/getStudentById/{studentId}")
	public Integer getStudentById(@PathVariable Integer studentId) {
		System.out.println(studentId);
		return studentId;
	}

	@PostMapping(path = "/addStudent")
	public Student addStudent(@RequestBody Student student) {
		System.out.println("Student comes from UI >>>>>" + student);
		return student;
	}
	
	//@PutMapping
	@PostMapping(path = "/updateStudent")
	public Student updateStudent(@RequestBody Student student) {
		System.out.println("Student comes from UI >>>>>" + student);
		return student;
	}

	@DeleteMapping(path = "/deleteStudentById")
	public Student deleteStudentById(@RequestBody Student student) {
		System.out.println("Student comes from UI >>>>>" + student);
		return student;
	}
	

}
