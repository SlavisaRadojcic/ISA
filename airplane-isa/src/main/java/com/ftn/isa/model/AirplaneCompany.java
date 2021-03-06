package com.ftn.isa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "airplane_company")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class AirplaneCompany {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "promo_description")
	private String promoDescription;
	
	@Column(name = "luggage_type")
	private String luggageType;
	
	@Column(name = "luggage_price")
	private int luggagePrice;
	
	@Column(name = "avrage_rate")
	private double avrageRate;
	
	@JsonBackReference
	@OneToMany(mappedBy = "airplaneCompany")
	private List<Destination> destinations = new ArrayList<Destination>();
	
}
