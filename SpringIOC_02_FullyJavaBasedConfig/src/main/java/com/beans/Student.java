package com.beans;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

	@Value("10")
	Integer age;

	ArrayList<String> mobile;

	@Autowired
	Address address;

	public Student() {
		System.out.println("Student class constructor called !");
	}
}
