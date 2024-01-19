package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.util.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();
			
			

			
			t.commit();
		} catch (Exception e) {
			System.out.println("Error while insertion");
			System.err.println(e);
		}
	}

}
