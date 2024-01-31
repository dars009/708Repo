package com.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.entity.Student;
import com.util.HibernateUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();

			// get Data from student table where studentName = darshit
			log.info("============ get Data from student table where studentName = darshit ============");
			Criteria criteria = session.createCriteria(Student.class);
			criteria.add(Restrictions.eq("studentName", "Darshit"));
			List<Student> studentList = criteria.list();
			for (Student student : studentList) {
				log.info(student);
			}

			log.info("============ get Data from student table where studentName notEqual darshit ============");
			Criteria criteria1 = session.createCriteria(Student.class);
			criteria1.add(Restrictions.ne("studentName", "Darshit"));

			List<Student> studentList1 = criteria1.list();
			for (Student student : studentList1) {
				log.info(student);
			}

			log.info("============ get Data from student table where roll number between 2 to 7 ============");
			Criteria criteria2 = session.createCriteria(Student.class);
			criteria2.add(Restrictions.between("rollNumber", 2, 7));
			List<Student> studnetList2 = criteria2.list();
			for (Student student : studnetList2) {
				log.info(student);
			}

			log.info("============ get Data from student is have max rollmumber ============");
			// create creteria
			Criteria criteria3 = session.createCriteria(Student.class);

			// create projections
			Projection projection = Projections.max("rollNumber");

			// adding projections in to creteria
			criteria3.setProjection(projection);

			// get list
			List<Student> studentList3 = criteria3.list();

			Iterator itr = studentList3.iterator();
			while (itr.hasNext()) {
				Object object = (Object) itr.next();
				log.info(object);
			}

			// execute native query using hibernate

			List<Student> ss = session.createNativeQuery("select * from student", Student.class).list();
			log.info(ss);

			t.commit();
			log.info("Data Retrive Successfully !");
		} catch (Exception e) {
			log.error("Error while Retrive");
			e.printStackTrace();
		}
	}

}
