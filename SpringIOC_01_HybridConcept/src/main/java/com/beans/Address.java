package com.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
	
	public Address() {
		System.out.println("Address class constructor called !");
	}
	
	String landmark;
}
