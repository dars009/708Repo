package com.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "employeeId"), @UniqueConstraint(columnNames = "email") })
public class Employee {

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Integer employeeId;

	@Column(unique = true, nullable = false, length = 100)
	private String email;

	@Column(unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(unique = false, nullable = false, length = 100)
	private String lastName;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private Set<Account> accounts;

}