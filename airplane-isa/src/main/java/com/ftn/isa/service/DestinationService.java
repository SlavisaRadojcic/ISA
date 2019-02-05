package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.Destination;

public interface DestinationService {

	List<Destination> getAll();
	
	Destination save(Destination destination);
	
	void delete(long id);
	
	List<Destination> getAllByComapnyId(long comapnyId);
}
