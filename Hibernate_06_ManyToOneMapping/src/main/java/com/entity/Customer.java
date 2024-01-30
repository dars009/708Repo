package com.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Customer {

	@Id
	@GeneratedValue
	private Integer customerId;

	@Column
	private String customerName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendorId", referencedColumnName = "vendorId")
	private Vendor vendor;

}
