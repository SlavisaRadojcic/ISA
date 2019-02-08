package com.ftn.isa.payload;

import com.ftn.isa.model.Seat;

public class SeatDTO {

	private long id;
	private String name;
	private boolean discounted;
	private boolean available;
	private int flightId;
	private FlightDTO flight;

	public SeatDTO() {
	}

	public SeatDTO(long id, String name, boolean discounted, boolean available, FlightDTO flight) {
		this.id = id;
		this.name = name;
		this.discounted = discounted;
		this.available = available;
		this.flight = flight;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDiscounted() {
		return discounted;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public FlightDTO getFlight() {
		return flight;
	}

	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Seat convertToModel(SeatDTO seatDTO) {
		Seat seat = new Seat();

		seat.setId(seatDTO.getId());
		seat.setName(seatDTO.getName());
		seat.setDiscounted(seatDTO.isDiscounted());
		seat.setAvailable(seatDTO.isAvailable());
		if (seatDTO.getFlight() != null) {
			seat.setFlight(new FlightDTO().convertToModel(seatDTO.getFlight()));
		}

		return seat;
	}

	public SeatDTO convertToDTO(Seat seat) {
		FlightDTO flightDTO = new FlightDTO();
		if (seat.getFlight() != null) {
			flightDTO = flightDTO.convertToDTO(seat.getFlight());
		}

		return new SeatDTO(seat.getId(), seat.getName(), seat.isDiscounted(), seat.isAvailable(), flightDTO);
	}
}
