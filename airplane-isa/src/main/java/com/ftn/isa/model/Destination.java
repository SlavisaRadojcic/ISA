package com.ftn.isa.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
