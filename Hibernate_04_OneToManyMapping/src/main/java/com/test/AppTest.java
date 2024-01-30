package com.test;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Account;
import com.entity.Employee;
import com.util.HibernateUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppTest {


	public static void main(String[] args) {

		log.debug("Debugging log");
		log.info("Info log");
		log.warn("Hey, This is a warning!");
		log.error("Oops! We have an Error. OK");
		log.fatal("Damn! Fatal error. Please fix me.");

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();

			Account ac1 = new Account();
			ac1.setAccountNumber("123456789012");

			Account ac2 = new Account();
			ac2.setAccountNumber("987654321014");

			// backing a set to be pass while create an Employee
			Set<Account> accOfFirstEmp = new HashSet<>();
			accOfFirstEmp.add(ac1);
			accOfFirstEmp.add(ac2);

			Employee FirstEmp = new Employee();
			FirstEmp.setFirstName("Sita");
			FirstEmp.setLastName("Ram");
			FirstEmp.setEmail("SitaRam@gmail.com");
			FirstEmp.setAccounts(accOfFirstEmp);

			session.persist(FirstEmp);

			t.commit();
			log.info("Data insert successfully !");
		} catch (Exception e) {
			log.error("Error while insertion");
			e.printStackTrace();
		}
	}

}
