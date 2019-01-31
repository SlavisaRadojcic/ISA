package com.ftn.isa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "flight")
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
	
}
