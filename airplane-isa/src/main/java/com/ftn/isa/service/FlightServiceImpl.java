package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Flight;
import com.ftn.isa.payload.DestinationDTO;
import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	DestinationService destinationService;
	
	@Override
	public List<FlightDTO> getAll() {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<Flight> flights = flightRepository.findAll();
		
		for(Flight flight: flights) {
			String[] transfers = flight.getLocationOfTransfer().split(",");
			List<String> transfersList = new ArrayList<>();
			for(String transfer: transfers) {
				transfersList.add(transfer);
			}
			
			FlightDTO flightDTO = new FlightDTO().convertToDTO(flight);
			
			flightsDTO.add(flightDTO);
			
		}
		
		return flightsDTO;
	}

	@Override
	public FlightDTO save(FlightDTO flightDTO) {
		DestinationDTO destinationDTO = destinationService.getById(flightDTO.getDestinationId());
		flightDTO.setDestination(destinationDTO);
		Flight flight = new FlightDTO().convertToModel(flightDTO);
		
		Flight newFlight = flightRepository.save(flight);
		
		String[] transfers = newFlight.getLocationOfTransfer().split(",");
		List<String> transfersList = new ArrayList<>();
		for(String transfer: transfers) {
			transfersList.add(transfer);
		}
		
		FlightDTO newFlightDTO = new FlightDTO().convertToDTO(newFlight);
		
		return newFlightDTO;
	}

	@Override
	public FlightDTO getById(long id) {
		Flight flight = flightRepository.getOne(id);
		
		String[] transfers = flight.getLocationOfTransfer().split(",");
		List<String> transfersList = new ArrayList<>();
		for(String transfer: transfers) {
			transfersList.add(transfer);
		}
		
		FlightDTO newFlightDTO = new FlightDTO().convertToDTO(flight);
		
		return newFlightDTO;
	}

	@Override
	public void delete(long id) {
		flightRepository.deleteById(id);
	}

	@Override
	public FlightDTO vote(long flightId, double rate) {
		Flight flight = flightRepository.getOne(flightId);
		
		if(flight.getAvrageRate() == 0) {
			flight.setAvrageRate(rate);
		} else {
			flight.setAvrageRate((flight.getAvrageRate() + rate) / 2);
		}
		
		flightRepository.save(flight);
		
		String[] transfers = flight.getLocationOfTransfer().split(",");
		List<String> transfersList = new ArrayList<>();
		for(String transfer: transfers) {
			transfersList.add(transfer);
		}
		
		FlightDTO newFlightDTO = new FlightDTO().convertToDTO(flight);
		
		return newFlightDTO;
	}

	@Override
	public List<FlightDTO> getByDestinationId(long id) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<Flight> flights = flightRepository.findByDestinationId(id);
		for(Flight flight: flights) {
			String[] transfers = flight.getLocationOfTransfer().split(",");
			List<String> transfersList = new ArrayList<>();
			for(String transfer: transfers) {
				transfersList.add(transfer);
			}
			
			FlightDTO flightDTO = new FlightDTO().convertToDTO(flight);
			
			flightsDTO.add(flightDTO);
			
		}
		
		return flightsDTO;
	}

	
}
