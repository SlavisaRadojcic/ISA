package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.repository.AirplaneCompanyRepository;

@Service
public class AirplaneCompanyServiceImpl implements AirplaneCompanyService {
	
	@Autowired
	AirplaneCompanyRepository airplaneCompanyRepository;

	@Override
	public List<AirplaneCompany> getAll() {
		return airplaneCompanyRepository.findAll();
	}

	@Override
	public AirplaneCompany save(AirplaneCompany airplaneCompany) {
		return airplaneCompanyRepository.save(airplaneCompany);
	}

	@Override
	public void delete(long id) {
		airplaneCompanyRepository.deleteById(id);
	}

	@Override
	public AirplaneCompany getById(long id) {
		return airplaneCompanyRepository.getOne(id);
	}
	
	
}
