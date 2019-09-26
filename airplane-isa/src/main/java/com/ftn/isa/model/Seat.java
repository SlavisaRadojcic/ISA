package com.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "seat")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Seat {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "discounted")
	private boolean discounted;
	
	@Column(name = "available")
	private boolean available;
	
	@JsonBackReference(value = "flight_reference")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_flight")
	private Flight flight;
	
	@Version
	@JsonBackReference(value = "user_reference")
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user")
	private User user;

}
