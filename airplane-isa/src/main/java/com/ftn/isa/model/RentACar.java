package com.ftn.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "rent_a_car")
public class RentACar {

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
	
	@Column(name = "avrage_rate")
	private double avrageRate;
	
	//TODO
	//Informacije o vozilima koja su dostupna unutar servisa
	//Informacije o filijalama koje su dostupne unutar servisa
}
