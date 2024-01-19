package com.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static Session getMySqlSession() {
		return new Configuration().configure().buildSessionFactory().openSession();
	}

}
