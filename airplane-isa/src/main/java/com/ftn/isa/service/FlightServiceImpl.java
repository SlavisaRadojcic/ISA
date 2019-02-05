package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Flight;
import com.ftn.isa.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public List<Flight> getAll() {
		return flightRepository.findAll();
	}

	@Override
	public Flight save(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public Flight getById(long id) {
		return flightRepository.getOne(id);
	}

	@Override
	public void delete(long id) {
		flightRepository.deleteById(id);
	}

	
}
