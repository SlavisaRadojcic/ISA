package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ftn.isa.model.Destination;
import com.ftn.isa.model.Seat;

public class FlightResponse {

	private long id;
	private String startingPoint;
	private String endingPoint;
	private Date dateOfTakeOff;
	private Date dateOfLanding;
	private int timeOfFlight;
	private int distanceOfFlight;
	private int numberOfTransfers;
	private List<String> locationOfTransfer;
	private double ticketPrice;
	private int discount;
	private double avrageRate;
	private Destination destination;
	private List<Seat> seats = new ArrayList<Seat>();

	public FlightResponse(long id, String startingPoint, String endingPoint, Date dateOfTakeOff, Date dateOfLanding,
			int timeOfFlight, int distanceOfFlight, int numberOfTransfers, List<String> locationOfTransfer,
			double ticketPrice, int discount, double avrageRate, Destination destination, List<Seat> seats) {
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
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getEndingPoint() {
		return endingPoint;
	}

	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}

	public Date getDateOfTakeOff() {
		return dateOfTakeOff;
	}

	public void setDateOfTakeOff(Date dateOfTakeOff) {
		this.dateOfTakeOff = dateOfTakeOff;
	}

	public Date getDateOfLanding() {
		return dateOfLanding;
	}

	public void setDateOfLanding(Date dateOfLanding) {
		this.dateOfLanding = dateOfLanding;
	}

	public int getTimeOfFlight() {
		return timeOfFlight;
	}

	public void setTimeOfFlight(int timeOfFlight) {
		this.timeOfFlight = timeOfFlight;
	}

	public int getDistanceOfFlight() {
		return distanceOfFlight;
	}

	public void setDistanceOfFlight(int distanceOfFlight) {
		this.distanceOfFlight = distanceOfFlight;
	}

	public int getNumberOfTransfers() {
		return numberOfTransfers;
	}

	public void setNumberOfTransfers(int numberOfTransfers) {
		this.numberOfTransfers = numberOfTransfers;
	}

	public List<String> getLocationOfTransfer() {
		return locationOfTransfer;
	}

	public void setLocationOfTransfer(List<String> locationOfTransfer) {
		this.locationOfTransfer = locationOfTransfer;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getAvrageRate() {
		return avrageRate;
	}

	public void setAvrageRate(double avrageRate) {
		this.avrageRate = avrageRate;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

}
