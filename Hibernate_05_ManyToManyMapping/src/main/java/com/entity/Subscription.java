package com.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Subscription {

	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Integer subscriptionId;

	@Column(unique = true, nullable = false)
	private String subscriptionName;
	
	@ManyToMany(mappedBy = "subscriptions")
	private Set<Reader> readers;

}
