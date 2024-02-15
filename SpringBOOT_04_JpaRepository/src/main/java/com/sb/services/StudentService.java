package com.sb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.StudentDAO;
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
		return studentDao.findById(studentId);
	}

	public Student updateStudent(Student student) {
		return studentDao.save(student);
	}

	public void deleteStudentById(Integer studentId) {
		studentDao.deleteById(studentId);
	}

}
