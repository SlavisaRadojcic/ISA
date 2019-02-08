package com.ftn.isa.payload;

import com.ftn.isa.model.AirplaneCompany;

import java.util.ArrayList;
import java.util.List;

public class AirplaneCompanyDTO {

	private Long id;
	private String name;
	private String address;
	private String promoDescription;
	private String luggageType;
	private Integer luggagePrice;
	private Double avrageRate;
	private List<DestinationDTO> destinations = new ArrayList<>();

	public AirplaneCompanyDTO(AirplaneCompany airplaneCompany) {
		this.id = airplaneCompany.getId();
		this.name = airplaneCompany.getName();
		this.address = airplaneCompany.getAddress();
		this.promoDescription = airplaneCompany.getPromoDescription();
		this.luggageType = airplaneCompany.getLuggageType();
		this.luggagePrice = airplaneCompany.getLuggagePrice();
		this.avrageRate = airplaneCompany.getAvrageRate();

		if (!airplaneCompany.getDestinations().isEmpty()) {
			airplaneCompany.getDestinations()
					.forEach(destination -> this.destinations.add(new DestinationDTO(destination)));
		}
	}

	public AirplaneCompanyDTO() {}

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

	public Integer getLuggagePrice() {
		return luggagePrice;
	}

	public void setLuggagePrice(Integer luggagePrice) {
		this.luggagePrice = luggagePrice;
	}

	public Double getAvrageRate() {
		return avrageRate;
	}

	public void setAvrageRate(Double avrageRate) {
		this.avrageRate = avrageRate;
	}

	public List<DestinationDTO> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<DestinationDTO> destinations) {
		this.destinations = destinations;
	}
}
