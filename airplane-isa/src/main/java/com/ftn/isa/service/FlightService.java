package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.payload.SearchDTO;

public interface FlightService {

	List<FlightDTO> getAll();

	FlightDTO save(FlightDTO flightRequest);

	FlightDTO getById(long id);

	void delete(long id);

	FlightDTO vote(long flightId, double rate);

	List<FlightDTO> getByDestinationId(long id);

	FlightDTO update(FlightDTO flightRequest);
	
	List<FlightDTO> getAllFilightsWithDiscount();
	
	List<FlightDTO> search(SearchDTO dto);
}
