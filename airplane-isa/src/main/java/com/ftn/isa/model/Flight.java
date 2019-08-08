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

	@Column(name = "starting_point")
	private String startingPoint;

	@Column(name = "ending_point")
	private String endingPoint;

	@Column(name = "date_of_take_off")
	private Date dateOfTakeOff;

	@Column(name = "date_of_landing")
	private Date dateOfLanding;

	@Column(name = "time_of_flight")
	private int timeOfFlight;

	@Column(name = "distance_of_flight")
	private int distanceOfFlight;

	@Column(name = "number_of_transfer")
	private int numberOfTransfers;

	@Column(name = "location_of_transfer")
	private String locationOfTransfer;

	@Column(name = "ticket_price")
	private double ticketPrice;

	@Column(name = "discount")
	private int discount;

	@Column(name = "avrage_rate")
	private double avrageRate;

	@Column(name = "flight_type")
	private String flightType;

	@Column(name = "flight_class")
	private String flightClass;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_destination")
	private Destination destination;

	@OneToMany(mappedBy = "flight")
	private List<Seat> seats = new ArrayList<Seat>();

	public Flight(long id, String startingPoint, String endingPoint, Date dateOfTakeOff, Date dateOfLanding,
			int timeOfFlight, int distanceOfFlight, int numberOfTransfers, String locationOfTransfer,
			double ticketPrice, int discount, double avrageRate, Destination destination, List<Seat> seats,
			String flightType, String flightClass) {
		super();
		this.id = id;
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.dateOfTakeOff = dateOfTakeOff;
		this.dateOfLanding = dateOfLanding;
		this.timeOfFlight = timeOfFlight;
		this.distanceOfFlight = distanceOfFlight;
		this.numberOfTransfers = numberOfTransfers;
		this.locationOfTransfer = locationOfTransfer;
		this.ticketPrice = ticketPrice;
		this.discount = discount;
		this.avrageRate = avrageRate;
		this.destination = destination;
		this.seats = seats;
		this.flightType = flightType;
		this.flightClass = flightClass;
	}

	public Flight(String startingPoint, String endingPoint, Date dateOfTakeOff, Date dateOfLanding, int timeOfFlight,
			int distanceOfFlight, int numberOfTransfers, String locationOfTransfer, double ticketPrice, int discount,
			double avrageRate, Destination destination, List<Seat> seats, String flightType, String flightClass) {
		super();
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.dateOfTakeOff = dateOfTakeOff;
		this.dateOfLanding = dateOfLanding;
		this.timeOfFlight = timeOfFlight;
		this.distanceOfFlight = distanceOfFlight;
		this.numberOfTransfers = numberOfTransfers;
		this.locationOfTransfer = locationOfTransfer;
		this.ticketPrice = ticketPrice;
		this.discount = discount;
		this.avrageRate = avrageRate;
		this.destination = destination;
		this.seats = seats;
		this.flightType = flightType;
		this.flightClass = flightClass;
	}

	public Flight() {
	}

}
