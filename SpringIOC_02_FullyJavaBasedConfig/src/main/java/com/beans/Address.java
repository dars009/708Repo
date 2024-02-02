package com.beans;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
	
	public Address() {
		System.out.println("Address class constructor called !");
	}
	
	@Value("FC Road")
	String landmark;
}
