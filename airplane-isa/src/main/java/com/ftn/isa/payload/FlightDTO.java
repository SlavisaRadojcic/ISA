package com.ftn.isa.payload;

import com.ftn.isa.model.Flight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightDTO {

	private Long id;
	private Long destinationId;
	private String destinationName;
	private String startingPoint;
	private String endingPoint;
	private Date dateOfTakeOff;
	private Date dateOfLanding;
	private Integer timeOfFlight;
	private Integer distanceOfFlight;
	private Integer numberOfTransfers;
	private List<String> locationOfTransfer;
	private Double ticketPrice;
	private Integer discount;
	private Double avrageRate;
	private String flightType;
	private String flightClass;
	private List<SeatDTO> seats = new ArrayList<>();

	public FlightDTO() {
	}

	public FlightDTO(Flight flight) {
		this.id = flight.getId();
		this.startingPoint = flight.getStartingPoint();
		this.endingPoint = flight.getEndingPoint();
		this.dateOfTakeOff = flight.getDateOfTakeOff();
		this.dateOfLanding = flight.getDateOfLanding();
		this.timeOfFlight = flight.getTimeOfFlight();
		this.distanceOfFlight = flight.getDistanceOfFlight();
		this.numberOfTransfers = flight.getNumberOfTransfers();
		this.locationOfTransfer = flight.getLocationOfTransfer() != null ? Arrays.asList(flight.getLocationOfTransfer().split(",")) : new ArrayList<>();
		this.ticketPrice = flight.getTicketPrice();
		this.discount = flight.getDiscount();
		this.avrageRate = flight.getAvrageRate();
		this.flightType = flight.getFlightType();
		this.flightClass = flight.getFlightClass();
		this.destinationId = flight.getDestination().getId();
		this.destinationName = flight.getDestination().getName();

		if (!flight.getSeats().isEmpty()) {
			flight.getSeats().forEach(seat -> this.seats.add(new SeatDTO(seat)));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}

	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
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

	public Integer getTimeOfFlight() {
		return timeOfFlight;
	}

	public void setTimeOfFlight(Integer timeOfFlight) {
		this.timeOfFlight = timeOfFlight;
	}

	public Integer getDistanceOfFlight() {
		return distanceOfFlight;
	}

	public void setDistanceOfFlight(Integer distanceOfFlight) {
		this.distanceOfFlight = distanceOfFlight;
	}

	public Integer getNumberOfTransfers() {
		return numberOfTransfers;
	}

	public void setNumberOfTransfers(Integer numberOfTransfers) {
		this.numberOfTransfers = numberOfTransfers;
	}

	public List<String> getLocationOfTransfer() {
		return locationOfTransfer;
	}

	public void setLocationOfTransfer(List<String> locationOfTransfer) {
		this.locationOfTransfer = locationOfTransfer;
	}

	public Double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(Double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Double getAvrageRate() {
		return avrageRate;
	}

	public void setAvrageRate(Double avrageRate) {
		this.avrageRate = avrageRate;
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

	public List<SeatDTO> getSeats() {
		return seats;
	}

	public void setSeats(List<SeatDTO> seats) {
		this.seats = seats;
	}
}
