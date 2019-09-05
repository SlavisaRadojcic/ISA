package com.ftn.isa.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Destination;
import com.ftn.isa.model.Flight;
import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.payload.SearchDTO;
import com.ftn.isa.repository.DestinationRepository;
import com.ftn.isa.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	FlightRepository flightRepository;
	DestinationRepository destinationRepository;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	
	public FlightServiceImpl(FlightRepository flightRepository, DestinationRepository destinationRepository) {
		this.flightRepository = flightRepository;
		this.destinationRepository = destinationRepository;
	}

	@Override
	public List<FlightDTO> getAll() {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<Flight> flights = flightRepository.findAll();

		for(Flight flight: flights) {
			flightsDTO.add(new FlightDTO(flight));
		}

		return flightsDTO;
	}

	@Override
	public FlightDTO getById(long id) {
		Flight flight = flightRepository.getOne(id);

		return new FlightDTO(flight);
	}

	@Override
	public FlightDTO save(FlightDTO flightDTO) {
		Destination destination = destinationRepository.getOne(flightDTO.getDestinationId());
		Flight flight = new Flight();

		flight.setDestination(destination);
		BeanUtils.copyProperties(flightDTO, flight, "id", "avrageRate", "seats");

		return new FlightDTO(flightRepository.save(flight));
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

		return new FlightDTO(flightRepository.save(flight));
	}

	@Override
	public List<FlightDTO> getByDestinationId(long id) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<Flight> flights = flightRepository.findByDestinationId(id);

		for(Flight flight: flights) {
			flightsDTO.add(new FlightDTO(flight));
		}

		return flightsDTO;
	}

	@Override
	public FlightDTO update(FlightDTO dto) {
		Flight flightDb = flightRepository.findById(dto.getId()).orElse(null);
		if (flightDb != null) {
			BeanUtils.copyProperties(dto, flightDb, "id", "avrageRate", "destination", "seats");
		}

		try {
			flightRepository.save(flightDb);
		} catch (Exception e) {
			// FIXME
			e.printStackTrace();
		}

		return new FlightDTO();
	}

	@Override
	public List<FlightDTO> getAllFilightsWithDiscount() {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<Flight> flights = flightRepository.findAll();

		for(Flight flight: flights) {
			if(flight.getDateOfTakeOff().compareTo(new Date()) > 0 && flight.getDiscount() > 0)
				flightsDTO.add(new FlightDTO(flight));
		}

		return flightsDTO;
	}

	@Override
	public List<FlightDTO> search(SearchDTO dto) {
		List<FlightDTO> flightsDTO = new ArrayList<>();
		List<Flight> flights = flightRepository.findAll();
		
		for(Flight flight: flights) {
			if(flight.getStartingPoint().equals(dto.getFrom())) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(flight.getEndingPoint().equals(dto.getTo())) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(dto.getDepart() != null && sdf.format(flight.getDateOfTakeOff()).equals(sdf.format(dto.getDepart()))) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(dto.getArrival()!= null && sdf.format(flight.getDateOfLanding()).equals(sdf.format(dto.getArrival()))) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(flight.getFlightClass() != null && flight.getFlightClass().equals(dto.getFlightClass())) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(flight.getFlightType() != null && flight.getFlightType().equals(dto.getFlightType())) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(flight.getTicketPrice() <= dto.getTicketPrice()) {
				flightsDTO.add(new FlightDTO(flight));
			} else if(flight.getDistanceOfFlight() <= dto.getDistanceOfFlight()) {
				flightsDTO.add(new FlightDTO(flight));
			}
		}
		
		return flightsDTO;
	}

}
