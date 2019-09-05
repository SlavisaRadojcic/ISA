package com.ftn.isa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ftn.isa.model.Destination;
import com.ftn.isa.payload.DestinationDTO;
import com.ftn.isa.repository.AirplaneCompanyRepository;
import com.ftn.isa.repository.DestinationRepository;
import com.ftn.isa.repository.FlightRepository;

@ExtendWith(MockitoExtension.class)
class DestinationServiceImplTest {
	
	@Mock
	AirplaneCompanyRepository airplaneCompanyRepository;
	@Mock
	DestinationRepository destinationRepository;
	@Mock
	FlightService flightService;
	@Mock
	FlightRepository flightRepository;
	@InjectMocks
	DestinationServiceImpl destinationService;
	
	@DisplayName("Get all Destinations")
	@Test
	void getAllTest() {
		List<Destination> destinations = new ArrayList<>();
		destinations.add(new Destination());
		
		when(destinationRepository.findAll()).thenReturn(destinations);
		
		List<DestinationDTO> destinationDTOs = destinationService.getAll();
		
		verify(destinationRepository).findAll();
		
		assertEquals(1, destinationDTOs.size());
	}
	
	@Disabled
	@DisplayName("Get by id Destination")
	@Test
	void getByIdTest() {
		Destination destination = new Destination();
		
		when(destinationRepository.findById(anyLong())).thenReturn(Optional.of(destination));
		
		DestinationDTO destinationDTO = destinationService.getById(1L);
		
		verify(destinationRepository).findById(anyLong());
		
		assertNotNull(destinationDTO);
	}

	@DisplayName("Save Destination")
	@Test
	void saveTest() {
		Destination destination = new Destination();
		
		when(destinationRepository.save(any(Destination.class))).thenReturn(destination);
		
		DestinationDTO destinationDTO = destinationService.save(new DestinationDTO());
		
		verify(destinationRepository).save(any(Destination.class));
		
		assertNotNull(destinationDTO);
	}
	
	@DisplayName("Delete Destination")
	@Test
	void deleteTest() {
		destinationService.delete(anyLong());
		
		verify(destinationRepository).deleteById(anyLong());
	}

}
