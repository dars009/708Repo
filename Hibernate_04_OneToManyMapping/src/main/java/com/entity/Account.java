package com.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = "accountId") })
public class Account {

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Integer accountId;

	@Column(unique = true, nullable = false, length = 100)
	private String accountNumber;

	@ManyToOne
	private Employee employee;

}