package com.sb.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sb.pojo.Student;
import com.sb.util.HibernateUtil;

import jakarta.websocket.server.PathParam;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/student")
public class StudentController {

	// @RequestMapping(method = RequestMethod.GET)
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

	// 1st way to get data from user / (postman) using @RequestBody
	@PostMapping(path = "/addStudent")
	public Student addStudent(@RequestBody Student student) {
		System.out.println("Student comes from UI >>>>>" + student);
		// hibernate code to add student
		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();
			// student.setId(student.getId());
			student.setName(student.getName());
			student.setCourse(student.getCourse());
			session.save(student);
			t.commit();
		} catch (Exception e) {
			System.out.println("Error while insertion");
			System.err.println(e);
		}
		return student;
	}

	// 2nd way to get data from user / (postman) using @PathVariable
	@PostMapping(path = "/getStudentById/{studentId}")
	public Integer getStudentById(@PathVariable Integer studentId) {
		System.out.println(studentId);
		// hibernate code to add student
		return studentId;
	}

	// 3rd way to get data from user / (postman) using @RequestParam
	@PostMapping(path = "/getStudentByIdRP")
	public Integer getStudentByIdRP(@RequestParam(name = "studentId") Integer studentId,
			@RequestParam(name = "studentName", required = false, defaultValue = "stud") String studentName) {
		System.out.println(studentId);
		System.out.println(studentName);
		// hibernate code to add student

		return 1111;

	}

	// 4th wat t ofetch data from user using @RequestHeader - mostly used in api
	// versioning
	@PostMapping(path = "/getStudentByIdRH")
	public Integer getStudentByIdRH(@RequestHeader(name = "version", required = false) String clientId) {
		System.out.println(clientId);
		return 1111;
	}

}
