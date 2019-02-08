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

import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.service.FlightService;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

	@Autowired
	FlightService flightService;

	@GetMapping
	public List<FlightDTO> getAllAirplaneCompanies() {
		return flightService.getAll();
	}

	@GetMapping("/{id}")
	public FlightDTO getFlightById(@PathVariable long id) {
		return flightService.getById(id);
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public FlightDTO saveFlight(@RequestBody FlightDTO flightRequest) {
		return flightService.save(flightRequest);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteFlight(@PathVariable long id) {
		flightService.delete(id);
	}

	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public FlightDTO editAirplaneCompany(@RequestBody FlightDTO flightRequest) {
		return flightService.update(flightRequest);
	}

	@PostMapping("/vote/{flightId}/{rate}")
	@PreAuthorize("hasRole('USER')")
	public FlightDTO vote(@PathVariable long flightId, @PathVariable double rate) {
		return flightService.vote(flightId, rate);
	}

	@GetMapping("/destination/{id}")
	@PreAuthorize("hasRole('USER')")
	public List<FlightDTO> getFlightByDestinationId(@PathVariable long id) {
		return flightService.getByDestinationId(id);
	}
}
