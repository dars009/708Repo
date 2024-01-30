package com.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Reader {
	
	@Id
	@GeneratedValue
	@Column(unique = true, nullable = false)
	private Integer readerId;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(unique = false, nullable = false)
	private String firstName;
	
	@Column(unique = false, nullable = false)
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="reader_subscription",
	joinColumns = {@JoinColumn(referencedColumnName = "readerId")},
	inverseJoinColumns = {@JoinColumn(referencedColumnName = "subscriptionId")})
	private Set<Subscription> subscriptions;
}
