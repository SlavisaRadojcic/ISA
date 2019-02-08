package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.FlightDTO;

public interface FlightService {

	List<FlightDTO> getAll();
	
	FlightDTO save(FlightDTO flightRequest);
	
	FlightDTO getById(long id);
	
	void delete(long id);
	
	FlightDTO vote(long flightId, double rate);
	
	List<FlightDTO> getByDestinationId(long id);
	
}
