package com.ftn.isa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ftn.isa.model.Destination;
import com.ftn.isa.model.Flight;
import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.repository.DestinationRepository;
import com.ftn.isa.repository.FlightRepository;

@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {
	
	@Mock
	FlightRepository flightRepository;
	@Mock
	DestinationRepository destinationRepository;
	@InjectMocks
	FlightServiceImpl flightService;

	@DisplayName("Get all Flights")
	@Test
	void getAllTest() {
		List<Flight> flights = new ArrayList<>();
		Flight flight = new Flight();
		flight.setDestination(new Destination());
		flights.add(flight);
		
		when(flightRepository.findAll()).thenReturn(flights);
		
		List<FlightDTO> flightDTOs = flightService.getAll();
		
		verify(flightRepository).findAll();
		
		assertEquals(1, flightDTOs.size());
	}
	
	@DisplayName("Get by id Flights")
	@Test
	void getByIdTest() {
		Flight flight = new Flight();
		flight.setDestination(new Destination());
		
		when(flightRepository.getOne(anyLong())).thenReturn(flight);
		
		FlightDTO flightDTOs = flightService.getById(1L);
		
		verify(flightRepository).getOne(anyLong());
		
		assertNotNull(flightDTOs);
	}
	
	@Disabled
	@DisplayName("Save Flights")
	@Test
	void saveTest() {
		Flight flight = new Flight();
		flight.setDestination(new Destination());
		
		when(flightRepository.save(any(Flight.class))).thenReturn(flight);
		
		FlightDTO flightDTOs = flightService.save(new FlightDTO());
		
		verify(flightRepository).save(any(Flight.class));
		
		assertNotNull(flightDTOs);
	}
	
	@DisplayName("Delete Flights")
	@Test
	void deleteTest() {
		flightService.delete(anyLong());
		
		verify(flightRepository).deleteById(anyLong());
	}
	
	@Disabled
	@DisplayName("Vote Flights")
	@Test
	void voteTest() {
		Flight flight = new Flight();
		flight.setDestination(new Destination());
		flight.setAvrageRate(5);
		
		when(flightRepository.save(any(Flight.class))).thenReturn(flight);
		
		FlightDTO flightDTOs = flightService.save(new FlightDTO());
		
		verify(flightRepository).save(any(Flight.class));
		
		assertEquals(5, flightDTOs.getAvrageRate().doubleValue());
	}
	
	@DisplayName("Get by Destination id Flights")
	@Test
	void getByDestinationIdTest() {
		List<Flight> flights = new ArrayList<>();
		Flight flight = new Flight();
		flight.setDestination(new Destination());
		flights.add(flight);
		
		when(flightRepository.findByDestinationId(anyLong())).thenReturn(flights);
		
		List<FlightDTO> flightDTOs = flightService.getByDestinationId(1L);
		
		verify(flightRepository).findByDestinationId(anyLong());
		
		assertEquals(1, flightDTOs.size());
	}
	
	@DisplayName("Get by discount Flights")
	@Test
	void getAllFilightsWithDiscountTest() {
		List<Flight> flights = new ArrayList<>();
		Flight flight = new Flight();
		flight.setDestination(new Destination());
		flight.setDiscount(10);
		flight.setDateOfTakeOff(new Date());
		flights.add(flight);
		
		when(flightRepository.findAll()).thenReturn(flights);
		
		List<FlightDTO> flightDTOs = flightService.getAllFilightsWithDiscount();
		
		verify(flightRepository).findAll();
		
		assertEquals(0, flightDTOs.size());
	}

}
