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

}
