package com.chitra.kmt.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String month;
	private String year;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "payment_date", nullable = false)
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate paymentDate;

	private double amount;
	private double discount;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "APP_PAYMENT_DETAILS", joinColumns = { @JoinColumn(name = "payment_id") }, inverseJoinColumns = {
			@JoinColumn(name = "student_id") })
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	

}
