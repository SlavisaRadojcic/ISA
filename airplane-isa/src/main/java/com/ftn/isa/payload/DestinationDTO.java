package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.List;

import com.ftn.isa.model.Destination;

public class DestinationDTO {

	private Long id;
	private String name;
	private Long companyId;
	private List<FlightDTO> flights = new ArrayList<>();

	public DestinationDTO() {
	}

	public DestinationDTO(Destination destination) {
		this.id = destination.getId();
		this.name = destination.getName();
		this.companyId = destination.getAirplaneCompany() != null ? destination.getAirplaneCompany().getId() : null;

		if (!destination.getFlights().isEmpty()) {
			destination.getFlights().forEach(flight -> this.flights.add(new FlightDTO(flight)));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public List<FlightDTO> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightDTO> flights) {
		this.flights = flights;
	}
}
