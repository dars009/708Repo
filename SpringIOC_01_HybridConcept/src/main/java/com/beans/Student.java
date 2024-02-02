package com.beans;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {

	Integer age;

	ArrayList<String> mobile;

	@Autowired
	@Qualifier("add2")
	Address address;

	public Student() {
		System.out.println("Student class constructor called !");
	}
}
