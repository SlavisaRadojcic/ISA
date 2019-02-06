package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.FlightRequest;
import com.ftn.isa.payload.FlightResponse;

public interface FlightService {

	List<FlightResponse> getAll();
	
	FlightResponse save(FlightRequest flightRequest);
	
	FlightResponse getById(long id);
	
	void delete(long id);
	
	FlightResponse vote(long flightId, double rate);
	
}
