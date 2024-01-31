package com.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.entity.Student;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getMySqlSession() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// configuration.configure();
				Properties setting = new Properties();
				setting.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				setting.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_07?useSSL=false");
				setting.put(Environment.USER, "root");
				setting.put(Environment.PASS, "root");
				setting.put(Environment.SHOW_SQL, "true");
				setting.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(setting);
				
				// add pojo class mapping
				configuration.addAnnotatedClass(Student.class);
				
				StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				return configuration.buildSessionFactory(serviceRegistry);
			} catch (Exception e) {
				System.out.println("Connection Failed !");
				e.printStackTrace();
			}
		}
		return null;
		//return sessionFactory;
	}
	
	
	public static void main(String[] args) {
		
		HibernateUtil.getMySqlSession();
	}
}
