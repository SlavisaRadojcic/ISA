package com.ftn.isa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "destination")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Destination {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_airplane_company")
	private AirplaneCompany airplaneCompany;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "destination")
	private List<Flight> flights = new ArrayList<Flight>();
}
