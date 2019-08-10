package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.SeatDTO;

public interface SeatService {

	List<SeatDTO> getAllByFlightId(long id);

	List<SeatDTO> getAllOnDiscount(long id);

	SeatDTO getById(long id);

	SeatDTO save(SeatDTO seat);

	List<SeatDTO> saveList(List<SeatDTO> seats);

	void delete(long id);

	void deleteSeats(List<SeatDTO> seats);

	SeatDTO reserve(long id);

	SeatDTO cancelReservation(long id);

	List<SeatDTO> getAllByUserid(long id);
	
	SeatDTO fastReserve(long flightId);
}
