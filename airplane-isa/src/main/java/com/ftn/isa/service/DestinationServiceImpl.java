package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Destination;
import com.ftn.isa.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	DestinationRepository destinationRepository;
	
	@Override
	public Destination save(Destination destination) {
		return destinationRepository.save(destination);
	}

	@Override
	public void delete(long id) {
		destinationRepository.deleteById(id);
	}

	@Override
	public List<Destination> getAllByComapnyId(long comapnyId) {
		return destinationRepository.findByAirplaneCompanyId(comapnyId);
	}

	@Override
	public List<Destination> getAll() {
		return destinationRepository.findAll();
	}

}
