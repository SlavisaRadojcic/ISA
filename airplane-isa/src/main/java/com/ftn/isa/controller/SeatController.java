package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.model.Seat;
import com.ftn.isa.service.SeatService;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

	@Autowired
	SeatService seatService;
	
	@GetMapping("/{flightId}")
	public List<Seat> getAllByFlightId(@PathVariable long flightId) {
		return seatService.getAllByFlightId(flightId);
	}
	
	@PostMapping
	public Seat save(@RequestBody Seat seat) {
		return seatService.save(seat);
	}
	
	@PostMapping("/reserve/{id}")
	public Seat reserve(@PathVariable long id) {
		return seatService.reserve(id);
	}
	
	@PostMapping("/cancel/{id}")
	public Seat cancel(@PathVariable long id) {
		return seatService.cancelReservation(id);
	}
}
