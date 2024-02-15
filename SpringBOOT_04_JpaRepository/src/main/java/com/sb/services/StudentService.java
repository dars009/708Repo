package com.sb.services;

import java.util.List;

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
		Student newStudent = new Student();
		newStudent.setName("Aanis Pathan");
		newStudent.setCourse("Computer Science");
		return studentDao.save(student);
	}

	public Student updateStudent(Integer studentId, Student updatedStudent) {
		Student existingStudent = studentDao.findById(studentId).orElse(null);

		if (existingStudent != null) {
			existingStudent.setName(updatedStudent.getName());
			existingStudent.setCourse(updatedStudent.getCourse());

			return studentDao.save(existingStudent);
		} else {

			return null;
		}
	}

	public Map<String, Boolean> deleteStudentById(Integer studentId) {
		Optional<Student> optionalStudent = studentDao.findById(studentId);

		if (optionalStudent.isPresent()) {
			studentDao.deleteById(studentId);

			Map<String, Boolean> result = new HashMap<>();
			result.put("Student Deleted", Boolean.TRUE);
			return result;
		} else
			return null;
	}
}
