package com.ftn.isa.payload;

import java.util.Date;

public class SearchDTO {

	private String from;
	private String to;
	private Date depart;
	private Date arrival;
	private String flightType;
	private String flightClass;
	private int distanceOfFlight;
	private double ticketPrice;

	public SearchDTO(String from, String to, Date depart, Date arrival, String flightType, String flightClass,
			int distanceOfFlight, double ticketPrice) {
		super();
		this.from = from;
		this.to = to;
		this.depart = depart;
		this.arrival = arrival;
		this.flightType = flightType;
		this.flightClass = flightClass;
		this.distanceOfFlight = distanceOfFlight;
		this.ticketPrice = ticketPrice;
	}

	public SearchDTO() {
		super();
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDepart() {
		return depart;
	}

	public void setDepart(Date depart) {
		this.depart = depart;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String getFlightClass() {
		return flightClass;
	}

	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}

	public int getDistanceOfFlight() {
		return distanceOfFlight;
	}

	public void setDistanceOfFlight(int distanceOfFlight) {
		this.distanceOfFlight = distanceOfFlight;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

}
