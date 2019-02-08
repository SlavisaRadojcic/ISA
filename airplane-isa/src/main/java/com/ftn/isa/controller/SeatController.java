package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.payload.SeatDTO;
import com.ftn.isa.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

	@Autowired
	SeatService seatService;
	
	@GetMapping("/flight/{flightId}")
	@PreAuthorize("hasRole('USER')")
	public List<SeatDTO> getAllByFlightId(@PathVariable long flightId) {
		return seatService.getAllByFlightId(flightId);
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public SeatDTO getAllById(@PathVariable long id) {
		return seatService.getById(id);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public SeatDTO save(@RequestBody SeatDTO seat) {
		return seatService.save(seat);
	}
	
	@PostMapping("/list")
	@PreAuthorize("hasRole('ADMIN')")
	public List<SeatDTO> save(@RequestBody List<SeatDTO> seats) {
		return seatService.saveList(seats);
	}
	
	@PostMapping("/reserve/{id}")
	@PreAuthorize("hasRole('USER')")
	public SeatDTO reserve(@PathVariable long id) {
		return seatService.reserve(id);
	}
	
	@PostMapping("/cancel/{id}")
	@PreAuthorize("hasRole('USER')")
	public SeatDTO cancel(@PathVariable long id) {
		return seatService.cancelReservation(id);
	}
}
