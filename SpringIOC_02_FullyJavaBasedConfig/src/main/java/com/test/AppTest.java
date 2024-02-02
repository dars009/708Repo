package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beans.Student;
import com.beans.StudentConfig;

public class AppTest {
	public static void main(String[] args) {
		
		// normal java object creation
		Student s = new Student();
		s.setAge(15);
		System.out.println(s.getAge());
		System.out.println("Address of s object >>"+s.hashCode());
		Student s1 = new Student();
		System.out.println(s1.getAge());
		System.out.println("Address of s1 object >>"+s1.hashCode());
		
		System.out.println("=============================================");
		
		
		//spring object creation
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		Student stu1 = (Student)ctx.getBean("stu");
		System.out.println(stu1.getAge());
		System.out.println("Address of stu1 object >>"+stu1.hashCode());
		
		Student stu2 = (Student)ctx.getBean("stu");
		System.out.println("Address of stu2 object >>"+stu2.hashCode());
		System.out.println(stu2.getAge());
	
		Student stu3 = (Student)ctx.getBean("stu");
		System.out.println("Address of stu3 object >>"+stu3.hashCode());
		System.out.println(stu3.getAge());
		System.out.println(stu3.getAddress().getLandmark());
	
	}
}
