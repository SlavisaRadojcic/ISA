package com.ftn.isa.payload;

import com.ftn.isa.model.Seat;

public class SeatDTO {

	private Long id;
	private Long flightId;
	private String name;
	private boolean discounted;
	private boolean available;
	private UserDTO user;

	public SeatDTO() {
	}

	public SeatDTO(Seat seat) {
		this.id = seat.getId();
		this.name = seat.getName();
		this.flightId = seat.getFlight().getId();
		this.discounted = seat.isDiscounted();
		this.available = seat.isAvailable();

		if (seat.getUser() != null) {
			this.user = new UserDTO(seat.getUser());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
