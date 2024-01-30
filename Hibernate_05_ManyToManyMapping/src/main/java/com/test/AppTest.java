package com.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Reader;
import com.entity.Subscription;
import com.util.HibernateUtil;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AppTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getMySqlSession().openSession()) {
			Transaction t = session.beginTransaction();

			// Create Subscription Entity
			Subscription subOne = new Subscription();
			subOne.setSubscriptionName("HotStar");

			Subscription subTwo = new Subscription();
			subTwo.setSubscriptionName("AmazonPrime");

			Subscription subThree = new Subscription();
			subThree.setSubscriptionName("SonyLiv");
			// add Subscribers in to hashSet
			Set<Subscription> subs = new HashSet<>();
			subs.add(subOne);
			subs.add(subTwo);
			subs.add(subThree);

			// create reader entity
			Reader readerOne = new Reader();
			readerOne.setEmail("one@gmail.com");
			readerOne.setFirstName("one");
			readerOne.setLastName("one last name");

			Reader readerTwo = new Reader();
			readerTwo.setEmail("two@gmail.com");
			readerTwo.setFirstName("two");
			readerTwo.setLastName("two last name");
			// add readers in to hashSet
			Set<Reader> readers = new HashSet<>();
			readers.add(readerOne);
			readers.add(readerTwo);

			// adding subscriptions to readers
			readerOne.setSubscriptions(subs);
			readerTwo.setSubscriptions(subs);

			session.save(readerOne);
			session.save(readerTwo);

			t.commit();
			log.info("Data insert successfully !");
		} catch (Exception e) {
			log.error("Error while insertion");
			e.printStackTrace();
		}
	}

}
