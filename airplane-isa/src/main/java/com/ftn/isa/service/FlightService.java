package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.Flight;

public interface FlightService {

	List<Flight> getAll();
	
	Flight save(Flight flight);
	
	Flight getById(long id);
	
	void delete(long id);
}
