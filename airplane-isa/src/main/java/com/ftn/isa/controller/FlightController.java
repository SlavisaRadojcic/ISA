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
import com.ftn.isa.payload.SearchDTO;
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

	@GetMapping("/vote/{flightId}/{flightRate}")
	@PreAuthorize("hasRole('USER')")
	public FlightDTO vote(@PathVariable long flightId, @PathVariable double flightRate) {
		return flightService.vote(flightId, flightRate);
	}

	@GetMapping("/destination/{id}")
	@PreAuthorize("hasRole('USER')")
	public List<FlightDTO> getFlightByDestinationId(@PathVariable long id) {
		return flightService.getByDestinationId(id);
	}
	
	@GetMapping(path = "/discount")
	public List<FlightDTO> getAllFlightsWithDiscount() {
		return flightService.getAllFilightsWithDiscount();
	}
	
	@PostMapping(path = "/search")
	public List<FlightDTO> searchFlights(@RequestBody SearchDTO dto) {
		return flightService.search(dto);
	}
	
	
}
