package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.model.Destination;
import com.ftn.isa.model.Flight;
import com.ftn.isa.model.Seat;
import com.ftn.isa.payload.DestinationDTO;
import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.repository.AirplaneCompanyRepository;
import com.ftn.isa.repository.DestinationRepository;
import com.ftn.isa.repository.FlightRepository;

@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {

	AirplaneCompanyRepository airplaneCompanyRepository;
	DestinationRepository destinationRepository;
	FlightService flightService;
	FlightRepository flightRepository;

	public DestinationServiceImpl(AirplaneCompanyRepository airplaneCompanyRepository,
			DestinationRepository destinationRepository, FlightService flightService,
			FlightRepository flightRepository) {
		this.airplaneCompanyRepository = airplaneCompanyRepository;
		this.destinationRepository = destinationRepository;
		this.flightService = flightService;
		this.flightRepository = flightRepository;
	}

	@Override
	public DestinationDTO save(DestinationDTO dto) {
		AirplaneCompany company = airplaneCompanyRepository.getOne(dto.getCompanyId());

		List<Flight> flights = new ArrayList<>();
		dto.getFlights().forEach(flightDTO -> {
			Flight flight = new Flight();
			BeanUtils.copyProperties(flightDTO, flight, "seats");

			List<Seat> seats = new ArrayList<>();
			flightDTO.getSeats().forEach(seatDTO -> {
				Seat seat = new Seat();
				BeanUtils.copyProperties(seatDTO, seat, "user");

				seats.add(seat);
			});

			flight.setSeats(seats);
		});

		Destination destination = new Destination();
		BeanUtils.copyProperties(dto, destination, "id", "flights");
		destination.setFlights(flights);
		destination.setAirplaneCompany(company);

		return new DestinationDTO(destinationRepository.save(destination));
	}

	@Override
	public void delete(long id) {
		destinationRepository.deleteById(id);
	}

	@Override
	public List<DestinationDTO> getAllByComapnyId(long comapnyId) {
		List<Destination> destinations = destinationRepository.findByAirplaneCompanyId(comapnyId);
		return getDestinationDTOs(destinations);
	}

	private List<DestinationDTO> getDestinationDTOs(List<Destination> destinations) {
		List<DestinationDTO> destinationsDTO = new ArrayList<>();

		for (Destination destination : destinations) {
			List<FlightDTO> flights = flightService.getByDestinationId(destination.getId());
			DestinationDTO destinationDTO = new DestinationDTO(destination);
			destinationDTO.setFlights(flights);

			destinationsDTO.add(destinationDTO);
		}

		return destinationsDTO;
	}

	@Override
	public List<DestinationDTO> getAll() {
		List<Destination> destinations = destinationRepository.findAll();
		return getDestinationDTOs(destinations);
	}

	@Override
	public DestinationDTO getById(long id) {
		Destination destination = destinationRepository.getOne(id);
		DestinationDTO dto = new DestinationDTO(destination);
		List<FlightDTO> flights = flightService.getByDestinationId(destination.getId());
		dto.setFlights(flights);

		return dto;
	}

}
