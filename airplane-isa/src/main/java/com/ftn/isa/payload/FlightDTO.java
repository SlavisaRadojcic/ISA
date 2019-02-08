package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ftn.isa.model.Flight;
import com.ftn.isa.model.Seat;

public class FlightDTO {

	private long id;
	private String startingPoint;
	private String endingPoint;
	private Date dateOfTakeOff;
	private Date dateOfLanding;
	private int timeOfFlight;
	private int distanceOfFlight;
	private int numberOfTransfers;
	private String locationOfTransfer;
	private double ticketPrice;
	private int discount;
	private double avrageRate;
	private String flightType;
	private String flightClass;
	private int destinationId;
	private DestinationDTO destination;
	private List<Seat> seats = new ArrayList<Seat>();

	public FlightDTO() {
	}

	public FlightDTO(long id, String startingPoint, String endingPoint, Date dateOfTakeOff, Date dateOfLanding,
			int timeOfFlight, int distanceOfFlight, int numberOfTransfers, String locationOfTransfer,
			double ticketPrice, int discount, double avrageRate, String flightType, String flightClass,
			DestinationDTO destination, List<Seat> seats) {
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
		this.flightType = flightType;
		this.flightClass = flightClass;
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

	public String getLocationOfTransfer() {
		return locationOfTransfer;
	}

	public void setLocationOfTransfer(String locationOfTransfer) {
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

	public int getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(int destinationId) {
		this.destinationId = destinationId;
	}

	public DestinationDTO getDestination() {
		return destination;
	}

	public void setDestination(DestinationDTO destination) {
		this.destination = destination;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Flight convertToModel(FlightDTO flightDTO) {
		Flight flight = new Flight();

		flight.setId(flightDTO.getId());
		flight.setStartingPoint(flightDTO.getStartingPoint());
		flight.setEndingPoint(flightDTO.getEndingPoint());
		flight.setDateOfTakeOff(flightDTO.getDateOfTakeOff());
		flight.setDateOfLanding(flightDTO.getDateOfLanding());
		flight.setTimeOfFlight(flightDTO.getTimeOfFlight());
		flight.setDistanceOfFlight(flightDTO.getDistanceOfFlight());
		flight.setNumberOfTransfers(flightDTO.getNumberOfTransfers());
		flight.setLocationOfTransfer(flightDTO.getLocationOfTransfer());
		flight.setTicketPrice(flightDTO.getTicketPrice());
		flight.setDiscount(flightDTO.getDiscount());
		flight.setAvrageRate(flightDTO.getAvrageRate());
		flight.setFlightType(flightDTO.getFlightType());
		flight.setFlightClass(flightDTO.getFlightClass());
		if (flightDTO.getDestination() != null) {
			flight.setDestination(
					new DestinationDTO().convertToModel(flightDTO.getDestination()));
		}

		return flight;
	}

	public FlightDTO convertToDTO(Flight flight) {
		DestinationDTO destination = new DestinationDTO();
		if (flight.getDestination() != null) {
			destination = destination.convertToDTO(flight.getDestination());
		}
		
		FlightDTO flightDTO = new FlightDTO(flight.getId(), flight.getStartingPoint(), flight.getEndingPoint(), flight.getDateOfTakeOff(), flight.getDateOfLanding(), flight.getTimeOfFlight(),
				flight.getDistanceOfFlight(), flight.getNumberOfTransfers(), flight.getLocationOfTransfer(), flight.getTicketPrice(), flight.getDiscount(), flight.getAvrageRate(), flight.getFlightType(),
				flight.getFlightClass(), destination, flight.getSeats());

		return flightDTO;
	}
}
