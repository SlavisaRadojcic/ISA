package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.List;

import com.ftn.isa.model.Destination;

public class DestinationDTO {
	
	private long id;
	private String name;
	private long companyId;
	private AirplaneCompanyDTO airplaneCompanyDTO;
	private List<FlightDTO> flightsDTO = new ArrayList<FlightDTO>();

	public DestinationDTO() {
	}

	public DestinationDTO(long id, String name, AirplaneCompanyDTO airplaneCompanyDTO, List<FlightDTO> flights) {
		super();
		this.id = id;
		this.name = name;
		if (airplaneCompanyDTO != null) {
			this.airplaneCompanyDTO = airplaneCompanyDTO;
		}
		if(flights != null) {
			this.flightsDTO = flights;
		}
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

	public AirplaneCompanyDTO getAirplaneCompanyDTO() {
		return airplaneCompanyDTO;
	}

	public void setAirplaneCompanyDTO(AirplaneCompanyDTO airplaneCompanyDTO) {
		this.airplaneCompanyDTO = airplaneCompanyDTO;
	}

	public List<FlightDTO> getFlights() {
		return flightsDTO;
	}

	public void setFlights(List<FlightDTO> flights) {
		this.flightsDTO = flights;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public Destination convertToModel(DestinationDTO destinationDTO) {
		Destination destination = new Destination();

		destination.setId(destinationDTO.getId());
		destination.setName(destinationDTO.getName());
		if (destinationDTO.getAirplaneCompanyDTO() != null) {
			destination.setAirplaneCompany(
					new AirplaneCompanyDTO().convertToModel(destinationDTO.getAirplaneCompanyDTO()));
		}

		return destination;
	}

	public DestinationDTO convertToDTO(Destination destination) {
		AirplaneCompanyDTO company = new AirplaneCompanyDTO();
		if (destination.getAirplaneCompany() != null) {
			company = company.convertToDTO(destination.getAirplaneCompany());
		}
		
		return new DestinationDTO(destination.getId(), destination.getName(), company, flightsDTO);
	}
	
	public DestinationDTO convertToDTO(Destination destination, List<FlightDTO> flightsDTO) {
		AirplaneCompanyDTO company = new AirplaneCompanyDTO();
		if (destination.getAirplaneCompany() != null) {
			company = company.convertToDTO(destination.getAirplaneCompany());
		}
		
		return new DestinationDTO(destination.getId(), destination.getName(), company, flightsDTO);
	}
}
