package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Flight;
import com.ftn.isa.payload.FlightRequest;
import com.ftn.isa.payload.FlightResponse;
import com.ftn.isa.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;
	
	@Override
	public List<FlightResponse> getAll() {
		List<FlightResponse> flightsResponse = new ArrayList<>();
		List<Flight> flights = flightRepository.findAll();
		
		for(Flight flight: flights) {
			String[] transfers = flight.getLocationOfTransfer().split(",");
			List<String> transfersList = new ArrayList<>();
			for(String transfer: transfers) {
				transfersList.add(transfer);
			}
			
			FlightResponse flightResponse = new FlightResponse(flight.getId(), flight.getStartingPoint(), flight.getEndingPoint(), flight.getDateOfTakeOff(), flight.getDateOfLanding(), flight.getTimeOfFlight(),
					flight.getDistanceOfFlight(), flight.getNumberOfTransfers(), transfersList, flight.getTicketPrice(), flight.getDiscount(), flight.getAvrageRate(), flight.getDestination(), flight.getSeats());
			
			flightsResponse.add(flightResponse);
			
		}
		
		return flightsResponse;
	}

	@Override
	public FlightResponse save(FlightRequest flightRequest) {
		Flight flight = new FlightRequest().convertToFlight(flightRequest);
		
		Flight newFlight = flightRepository.save(flight);
		
		String[] transfers = newFlight.getLocationOfTransfer().split(",");
		List<String> transfersList = new ArrayList<>();
		for(String transfer: transfers) {
			transfersList.add(transfer);
		}
		
		FlightResponse flightResponse = new FlightResponse(newFlight.getId(), newFlight.getStartingPoint(), newFlight.getEndingPoint(), newFlight.getDateOfTakeOff(), newFlight.getDateOfLanding(),
				newFlight.getTimeOfFlight(), newFlight.getDistanceOfFlight(), newFlight.getNumberOfTransfers(), transfersList, newFlight.getTicketPrice(), newFlight.getDiscount(),
				newFlight.getAvrageRate(), newFlight.getDestination(), newFlight.getSeats());
		
		return flightResponse;
	}

	@Override
	public FlightResponse getById(long id) {
		Flight flight = flightRepository.getOne(id);
		
		String[] transfers = flight.getLocationOfTransfer().split(",");
		List<String> transfersList = new ArrayList<>();
		for(String transfer: transfers) {
			transfersList.add(transfer);
		}
		
		FlightResponse flightResponse = new FlightResponse(flight.getId(), flight.getStartingPoint(), flight.getEndingPoint(), flight.getDateOfTakeOff(), flight.getDateOfLanding(), flight.getTimeOfFlight(),
				flight.getDistanceOfFlight(), flight.getNumberOfTransfers(), transfersList, flight.getTicketPrice(), flight.getDiscount(), flight.getAvrageRate(), flight.getDestination(), flight.getSeats());
		
		return flightResponse;
	}

	@Override
	public void delete(long id) {
		flightRepository.deleteById(id);
	}

	@Override
	public FlightResponse vote(long flightId, double rate) {
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
		
		FlightResponse flightResponse = new FlightResponse(flight.getId(), flight.getStartingPoint(), flight.getEndingPoint(), flight.getDateOfTakeOff(), flight.getDateOfLanding(), flight.getTimeOfFlight(),
				flight.getDistanceOfFlight(), flight.getNumberOfTransfers(), transfersList, flight.getTicketPrice(), flight.getDiscount(), flight.getAvrageRate(), flight.getDestination(), flight.getSeats());
		
		return flightResponse;
	}

	
}
