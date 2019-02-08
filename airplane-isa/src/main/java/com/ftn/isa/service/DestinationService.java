package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.DestinationDTO;

public interface DestinationService {

	List<DestinationDTO> getAll();
	
	DestinationDTO save(DestinationDTO destination);
	
	void delete(long id);
	
	List<DestinationDTO> getAllByComapnyId(long comapnyId);
	
	DestinationDTO getById(long id);
}
