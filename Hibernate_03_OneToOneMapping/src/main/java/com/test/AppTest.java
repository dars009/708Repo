package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Account;
import com.entity.Employee;
import com.util.HibernateUtil;

public class AppTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();

			Employee employee = new Employee();
			employee.setFirstName("ABC");
			employee.setLastName("PQR");

			Account account = new Account();
			account.setAccountNumber("123456666");

			employee.setAccount(account);

			session.save(employee);
			session.save(account);

			t.commit();
		} catch (Exception e) {
			System.out.println("Error while insertion");
			System.err.println(e);
		}
	}

}
