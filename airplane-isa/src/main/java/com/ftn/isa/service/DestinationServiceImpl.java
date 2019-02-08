package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.model.Destination;
import com.ftn.isa.payload.AirplaneCompanyDTO;
import com.ftn.isa.payload.DestinationDTO;
import com.ftn.isa.repository.AirplaneCompanyRepository;
import com.ftn.isa.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	AirplaneCompanyRepository airplaneCompanyRepository;
	
	@Autowired
	DestinationRepository destinationRepository;
	
	@Autowired
	FlightService flightService;
	
	@Override
	public DestinationDTO save(DestinationDTO destinationDTO) {
		AirplaneCompany company = airplaneCompanyRepository.getOne(destinationDTO.getCompanyId());
		destinationDTO.setAirplaneCompanyDTO(new AirplaneCompanyDTO().convertToDTO(company));
		Destination destination = new DestinationDTO().convertToModel(destinationDTO);
		destination = destinationRepository.save(destination);
		
		DestinationDTO newDestination = new DestinationDTO().convertToDTO(destination);
		
		return newDestination;
	}

	@Override
	public void delete(long id) {
		destinationRepository.deleteById(id);
	}

	@Override
	public List<DestinationDTO> getAllByComapnyId(long comapnyId) {
		List<Destination> destinations = destinationRepository.findByAirplaneCompanyId(comapnyId); 
		List<DestinationDTO> destinationsDTO = new ArrayList<>();
		
		for(Destination destination: destinations) {
			destinationsDTO.add(new DestinationDTO().convertToDTO(destination, flightService.getByDestinationId(destination.getId())));
		}
		
		return destinationsDTO;
	}

	@Override
	public List<DestinationDTO> getAll() {
		List<Destination> destinations = destinationRepository.findAll();
		List<DestinationDTO> destinationsDTO = new ArrayList<>();
		
		for(Destination destination: destinations) {
			destinationsDTO.add(new DestinationDTO().convertToDTO(destination, flightService.getByDestinationId(destination.getId())));
		}
		
		return destinationsDTO;
	}

	@Override
	public DestinationDTO getById(long id) {
		Destination destination = destinationRepository.getOne(id);
		DestinationDTO destinationDTO = new DestinationDTO().convertToDTO(destination, flightService.getByDestinationId(destination.getId()));
		
		return destinationDTO;
	}

}
