package com.ftn.isa.service;

import com.ftn.isa.model.Destination;
import com.ftn.isa.model.Flight;
import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.repository.DestinationRepository;
import com.ftn.isa.repository.FlightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	DestinationRepository destinationRepository;

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


}
