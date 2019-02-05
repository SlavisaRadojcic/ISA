package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.model.Flight;
import com.ftn.isa.service.FlightService;

@RestController
@RequestMapping("/api/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	@GetMapping
	public List<Flight> getAllAirplaneCompanies() {
		return flightService.getAll();
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Flight saveAirplaneCompany(@RequestBody Flight flight) {
		return flightService.save(flight);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAirplaneCompany(@PathVariable long id) {
		flightService.delete(id);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public Flight editAirplaneCompany(@RequestBody Flight flight) {
		return flightService.save(flight);
	}
}
