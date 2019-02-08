package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.payload.AirplaneCompanyDTO;

public interface AirplaneCompanyService {

	List<AirplaneCompanyDTO> getAll();
	
	AirplaneCompanyDTO save(AirplaneCompanyDTO airplaneCompany);
	
	void delete(long id);
	
	AirplaneCompanyDTO getById(long id);
	
	AirplaneCompanyDTO vote(long companyId, double rate);
}
