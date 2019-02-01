package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.AirplaneCompany;

public interface AirplaneCompanyService {

	List<AirplaneCompany> getAll();
	
	AirplaneCompany save(AirplaneCompany airplaneCompany);
	
	void delete(long id);
	
	AirplaneCompany getById(long id);
	
}
