package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.Seat;

public interface SeatService {

	List<Seat> getAllByFlightId(long id);
	
	List<Seat> getAllOnDiscount(long id);
	
	Seat save(Seat seat);
	
	List<Seat> saveList(List<Seat> seats);
	
	void delete(long id);
	
	Seat reserve(long id);
	
	Seat cancelReservation(long id);
}
