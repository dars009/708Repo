package com.sb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.StudentDAO;
import com.sb.exceptions.StudentNotFoundException;
import com.sb.pojo.Student;

@Service
public class StudentService {

	@Autowired
	StudentDAO studentDao;

	public List<Student> getAllStudent() {
		return studentDao.findAll();
	}

	public Student addStudent(Student student) {
		return studentDao.save(student);
	}

	public Optional<Student> getStudentById(Integer studentId) {
		Optional<Student> student = studentDao.findById(studentId);
		if (student.isPresent()) {
			return student;
		} else {
			throw new StudentNotFoundException("Student not found in database : " + studentId);
		}
	}

	public Student updateStudent(Student student) {
		return studentDao.save(student);
	}

	public void deleteStudentById(Integer studentId) {
		studentDao.deleteById(studentId);
	}

}
