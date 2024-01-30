package com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.CustomCollectionType;

import com.entity.Customer;
import com.entity.Vendor;
import com.util.HibernateUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();

			Vendor vendor = new Vendor();
			vendor.setVenorName("D-Mart");

			Customer customerOne = new Customer();
			customerOne.setCustomerName("Gaurav");
			customerOne.setVendor(vendor);

			Customer customerTwo = new Customer();
			customerTwo.setCustomerName("Anish");
			customerTwo.setVendor(vendor);

			session.persist(customerOne);
			session.persist(customerTwo);

			t.commit();
			log.info("Data insert successfully !");
		} catch (Exception e) {
			log.error("Error while insertion");
			e.printStackTrace();
		}
	}

}
