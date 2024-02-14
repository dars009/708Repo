package com.sb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sb.constants.GlobalConstants;
import com.sb.pojo.Student;

@RestController
@RequestMapping(GlobalConstants.STUDENT_CONTROLLER_MAPPING)
public class StudentController {

	@GetMapping(value = "/getAllStudent")
	public List<Student> getAllStudent() {
		List<Student> listOfStudent = new ArrayList<>();
		Student student = new Student();
		student.setId(1);
		student.setName("Ram");
		student.setCourse("Java");
		listOfStudent.add(student);
		return listOfStudent;
	}

	@GetMapping("/getListOfNames")
	public List<String> getListOfNames() {
		return Arrays.asList("Dushant", "Shubham", "Sudha", "Swapnil", "Trupti");
	}

	@PostMapping(path = "/addStudent")
	public Student addStudent(@RequestBody Student student) {
		System.out.println("Student comes from UI >>>>>" + student);
		return student;
	}

	@PostMapping(path = "/getStudentById/{studentId}")
	public Integer getStudentById(@PathVariable Integer studentId) {
		System.out.println(studentId);
		return studentId;
	}

	// 3rd way to get data from user / (postman) using @RequestParam
	@PostMapping(path = "/getStudentByIdRP")
	public Integer getStudentByIdRP(@RequestParam(name = "studentId") Integer studentId,
			@RequestParam(name = "studentName", required = false, defaultValue = "stud") String studentName) {
		System.out.println(studentId);
		System.out.println(studentName);
		return 1111;
	}

	@PostMapping(path = "/getStudentByIdRH")
	public Integer getStudentByIdRH(@RequestHeader(name = "version", required = false) String clientId) {
		System.out.println(clientId);
		return 1111;
	}

}
