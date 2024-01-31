package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Student;
import com.util.HibernateUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AddStudents {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();

			Student s = new Student(1, "Darshit", 1, "Java");
			Student s1 = new Student(2, "Ravi", 2, "PHP");
			Student s2 = new Student(3, "Gaurav", 3, "Pythhon");
			Student s3 = new Student(4, "Anish", 4, "Ruby");
			Student s4 = new Student(5, "kanchan", 5, "HTML");
			Student s5 = new Student(6, "Dushant", 6, "React");
			Student s6 = new Student(7, "Ajay", 7, "Angular");
			Student s7 = new Student(8, "Sudha", 8, "Typescript");
			Student s8 = new Student(9, "Trupti", 9, "Erlang");

			session.save(s);
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			session.save(s5);
			session.save(s6);
			session.save(s7);
			session.save(s8);

			t.commit();
			log.info("Data insert successfully !");
		} catch (Exception e) {
			log.error("Error while insertion");
			e.printStackTrace();
		}
	}

}
