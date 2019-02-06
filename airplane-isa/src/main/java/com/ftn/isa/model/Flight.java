package com.ftn.isa.model;

import java.util.ArrayList;
import java.util.Date;
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
@Table(name = "flight")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Flight {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	
	@Column(name = "date_of_take_off")
	private Date dateOfTakeOff;
	
	@Column(name = "date_of_landing")
	private Date dateOfLanding;
	
	@Column(name = "time_of_flight")
	private double timeOfFlight;
	
	@Column(name = "number_of_transfer")
	private int numberOfTransfers;
	
	@Column(name = "location_of_transfer")
	private String locationOfTransfer;
	
	@Column(name = "ticket_price")
	private double ticketPrice;
	
	@Column(name = "avrage_rate")
	private double avrageRate;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_destination")
	private Destination destination;
	
	@OneToMany(mappedBy = "flight")
	private List<Ticket> tickets = new ArrayList<Ticket>();
	
	
}
