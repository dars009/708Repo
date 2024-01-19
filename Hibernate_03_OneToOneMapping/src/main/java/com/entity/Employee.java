package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Employee {

	@Id
	@Column(unique = true, length = 10, nullable = false)
	@GeneratedValue
	private Integer employeeId;

	@Column(unique = false, length = 100, nullable = false)
	private String firstName;

	@Column(unique = false, length = 100, nullable = false)
	private String lastName;

	@OneToOne
	private Account account;
}
