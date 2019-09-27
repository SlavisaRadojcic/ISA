package com.ftn.isa.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ftn.isa.model.Flight;
import com.ftn.isa.model.Seat;
import com.ftn.isa.model.User;
import com.ftn.isa.payload.SeatDTO;
import com.ftn.isa.repository.FlightRepository;
import com.ftn.isa.repository.SeatRepository;
import com.ftn.isa.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class SeatServiceImplTest {
	
	@Mock
	SeatRepository seatRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	FlightRepository flightRepository;
	@InjectMocks
	SeatServiceImpl seatService;

	@DisplayName("Get all by Flight id Seats")
	@Test
	void getAllByFlightIdTest() {
		List<Seat> seats = new ArrayList<>();
		Seat seat = new Seat();
		Flight flight = new Flight();
		seat.setFlight(flight);
		seats.add(seat);
		
		when(seatRepository.findByFlightId(anyLong())).thenReturn(seats);
		
		List<SeatDTO> seatDTOs = seatService.getAllByFlightId(1L);
		
		verify(seatRepository).findByFlightId(anyLong());
		
		assertNotNull(seatDTOs.get(0).getFlightId());
	}
	
	@Disabled
	@DisplayName("Save Seat")
	@Test
	void saveSeat() {
		Seat seat = new Seat();
		Flight flight = new Flight();
		seat.setFlight(flight);
		
		when(seatRepository.save(any(Seat.class))).thenReturn(seat);
		
		SeatDTO seatDTO = seatService.save(new SeatDTO());
		
		verify(seatRepository).save(any(Seat.class));
		
		assertNotNull(seatDTO);
	}
	
	@DisplayName("Delete Seat")
	@Test
	void deleteSeatTest() {
		seatService.delete(anyLong());
		
		verify(seatRepository).deleteById(anyLong());
	}
	
	@Disabled
	@DisplayName("Reserve Seat")
	@Test
	void reserveSeatTest() {
		Seat seat = new Seat();
		User user = new User();
		seat.setUser((int) user.getId());
		seat.setAvailable(false);
		
		when(seatRepository.save(any(Seat.class))).thenReturn(seat);
		
		SeatDTO seatDTO = seatService.save(new SeatDTO());
		
		verify(seatRepository).save(any(Seat.class));
		
		assertNotNull(seatDTO);
	}
	
	@Disabled
	@DisplayName("Cancel reservation Seat")
	@Test
	void cancelReservationSeatTest() {
		Seat seat = new Seat();
		seat.setUser(null);
		seat.setAvailable(true);
		
		when(seatRepository.save(any(Seat.class))).thenReturn(seat);
		
		SeatDTO seatDTO = seatService.save(new SeatDTO());
		
		verify(seatRepository).save(any(Seat.class));
		
		assertNotNull(seatDTO);
	}
	
	@DisplayName("Get by id Seat")
	@Test
	void getByIdTest() {
		Seat seat = new Seat();
		Flight flight = new Flight();
		seat.setFlight(flight);
		
		when(seatRepository.getOne(anyLong())).thenReturn(seat);
		
		SeatDTO seatDTO = seatService.getById(1L);
		
		verify(seatRepository).getOne(anyLong());
		
		assertNotNull(seatDTO);
	}

}
