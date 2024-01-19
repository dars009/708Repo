package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession()) {
			Transaction t = session.beginTransaction();
			Student student = new Student();
			//student.setId(4);
			student.setFirstName("Abc3");
			student.setLastName("Pbc");
			student.setEmail("Abc@gmail.com");
			session.persist(student);
			t.commit();
			session.evict(student);
		} catch (Exception e) {
			System.out.println("Error while insertion");
			System.err.println(e);
		}
	}

}
