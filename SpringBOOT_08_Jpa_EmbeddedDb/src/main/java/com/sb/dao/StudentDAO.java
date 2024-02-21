package com.sb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sb.pojo.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

	@Query(value = "from Student where course like '%java' ")
	public List<Student> getStudentWhereCourceJava();
}
