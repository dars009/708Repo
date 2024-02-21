package com.sb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.dao.StudentDAO;
import com.sb.exceptions.StudentNotFoundException;
import com.sb.pojo.Student;

import jakarta.persistence.EntityManager;

@Service
public class StudentService {

	@Autowired
	StudentDAO studentDao;

	@Autowired
	EntityManager em;

	public List<Student> getAllStudent() {
		return studentDao.findAll();
	}

	public Student addStudent(Student student) {
		Student s1= new Student();
		s1.setName("Darshit");
		s1.setCourse("erlang");
		studentDao.save(s1);
		
		Student s2= new Student();
		s2.setName("Leena");
		s2.setCourse("java");
		studentDao.save(s2);
		
		Student s3= new Student();
		s3.setName("Swapnil");
		s3.setCourse("erlang");
		studentDao.save(s3);
		
		Student s4= new Student();
		s4.setName("Shriyog");
		s4.setCourse("python");
		studentDao.save(s4);
		
		Student s5= new Student();
		s5.setName("Shubham");
		s5.setCourse("Node");
		studentDao.save(s5);
		
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

	//*************************** Using Entity Manager******************************
	
	// find student by id using entity manager 
	public Student findByStudentID(Long stuId) {
		return em.find(Student.class, stuId);
	}
	
	//for insert or update 
	public Student saveStudentEM(Student stu) {
		if(stu.getId()== null) {
			em.persist(stu);
		}else {
			em.merge(stu);
		}
		return stu;
	}
	
	// custom queries task to perfom > use of @Query 
	public List<Student> jpql_where(){
		return em.createQuery("from Student where course like '%erlang' ",Student.class).getResultList();
	}
	
	public List<Student> native_where(){
		return em.createNativeQuery("select * from student where course like '%erlang' ",Student.class).getResultList();
	}
	
	public List<Student> usingQueryAnnotation(){
		return studentDao.getStudentWhereCourceJava();
	}
}
