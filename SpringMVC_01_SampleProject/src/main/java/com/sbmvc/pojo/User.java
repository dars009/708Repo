package com.sbmvc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	private String fullName;
	private String email;
	private String password;
}	
