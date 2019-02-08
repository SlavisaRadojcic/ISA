package com.ftn.isa.payload;

import java.util.ArrayList;
import java.util.List;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.model.Destination;

public class AirplaneCompanyDTO {

	private long id;
	private String name;
	private String address;
	private String promoDescription;
	private String luggageType;
	private int luggagePrice;
	private double avrageRate;
	private List<DestinationDTO> destinations = new ArrayList<DestinationDTO>();

	public AirplaneCompanyDTO(long id, String name, String address, String promoDescription, String luggageType,
			int luggagePrice, double avrageRate) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.promoDescription = promoDescription;
		this.luggageType = luggageType;
		this.luggagePrice = luggagePrice;
		this.avrageRate = avrageRate;
	}
	
	public AirplaneCompanyDTO() {}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPromoDescription() {
		return promoDescription;
	}

	public void setPromoDescription(String promoDescription) {
		this.promoDescription = promoDescription;
	}

	public String getLuggageType() {
		return luggageType;
	}

	public void setLuggageType(String luggageType) {
		this.luggageType = luggageType;
	}

	public int getLuggagePrice() {
		return luggagePrice;
	}

	public void setLuggagePrice(int luggagePrice) {
		this.luggagePrice = luggagePrice;
	}

	public double getAvrageRate() {
		return avrageRate;
	}

	public void setAvrageRate(double avrageRate) {
		this.avrageRate = avrageRate;
	}

	public List<DestinationDTO> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationDTO> destinations) {
		this.destinations = destinations;
	}
	
	public AirplaneCompany convertToModel(AirplaneCompanyDTO airplaneCompanyDTO) {
		AirplaneCompany airplaneCompany = new AirplaneCompany();
		
		airplaneCompany.setId(airplaneCompanyDTO.getId());
		airplaneCompany.setName(airplaneCompanyDTO.getName());
		airplaneCompany.setAddress(airplaneCompanyDTO.getAddress());
		airplaneCompany.setPromoDescription(airplaneCompanyDTO.getPromoDescription());
		airplaneCompany.setLuggageType(airplaneCompanyDTO.getLuggageType());
		airplaneCompany.setLuggagePrice(airplaneCompanyDTO.getLuggagePrice());
		airplaneCompany.setAvrageRate(airplaneCompanyDTO.getAvrageRate());
		
		return airplaneCompany;
	}
	
	public AirplaneCompanyDTO convertToDTO(AirplaneCompany airplaneCompany) {
		return new AirplaneCompanyDTO(airplaneCompany.getId(), airplaneCompany.getName(), airplaneCompany.getAddress(), airplaneCompany.getPromoDescription(), airplaneCompany.getLuggageType(),
				airplaneCompany.getLuggagePrice(), airplaneCompany.getAvrageRate());
	}

}
