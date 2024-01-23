package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Account {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue
	private Integer accountId;

	@Column(unique = false, nullable = false, length = 30)
	private String accountNumber;

	// define the association
	@OneToOne(mappedBy = "account")
	private Employee employee;
}
