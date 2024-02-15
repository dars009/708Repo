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
	
	
	// AddStudent Task Done By Aanis Pathan
	@PostMapping(path = "/addStudent")
	public Student addStudent(@RequestBody Student student) {
    
		System.out.println(student);
		return studentService.addStudent(student);
	}

	// @PutMapping
	@PutMapping("/updateStudent/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable Integer studentId, @RequestBody Student updatedStudent) {
        Student result = studentService.updateStudent(studentId, updatedStudent);

        if (result != null) {
            return new ResponseEntity<>("Student record updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Student record not found", HttpStatus.NOT_FOUND);
        }
    }
	/// another way to get track status of function
	
//	 if (addedStudent != null) {
//	        String successMessage = "Student record added successfully";
//	        return new ResponseEntity<>(successMessage, HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>("Failed to add student record", HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	}

	 @DeleteMapping("/deleteStudent")
	    public ResponseEntity<String> deleteStudent(@RequestBody Map<String, Integer> requestBody) {
	        Integer studentId = requestBody.get("id");
	        Map<String, Boolean> response = studentService.deleteStudentById(studentId);

	        if (response != null && response.get("deleted")) {
	            return new ResponseEntity<>("Student record deleted successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Student record not found", HttpStatus.NOT_FOUND);
	        }
	    }

	}
