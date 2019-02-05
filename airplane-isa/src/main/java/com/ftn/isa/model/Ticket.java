package com.ftn.isa.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "flight")
public class Ticket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private long id;
	@Column(name = "starting_point")
	private String startingPoint;
	@Column(name = "ending_point")
	private String endingPoint;
	@Column(name = "starting_date")
	private Date startingDate;
	@Column(name = "starting_time")
	private String startingTime;
	@Column(name = "ticket_price")
	private double ticketPrice;
	@Column(name = "discount")
	private double discount;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_flight")
	private Flight flight;
	
	//TODO
	//Seat objekat dodati
}
