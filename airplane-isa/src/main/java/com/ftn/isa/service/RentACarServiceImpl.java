package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Hotel;
import com.ftn.isa.model.RentACar;
import com.ftn.isa.repository.RentACarRepository;

@Service
public class RentACarServiceImpl implements RentACarService {

	@Autowired
	RentACarRepository rentACarRepository;
	
	@Override
	public List<RentACar> getAll() {
		return rentACarRepository.findAll();
	}

	@Override
	public RentACar getByName(String name) {
		return rentACarRepository.findByName(name);
	}

	@Override
	public RentACar getById(long id) {
		return rentACarRepository.getOne(id);
	}

	@Override
	public RentACar getByNameAndAddress(String name, String address) {
		return rentACarRepository.findByNameAndAddress(name, address);
	}

	@Override
	public RentACar vote(long id, double rate) {
		RentACar rentACar = rentACarRepository.getOne(id);
		
		if(rentACar.getAvrageRate() == 0) {
			rentACar.setAvrageRate(rate);
		} else {
			rentACar.setAvrageRate((rentACar.getAvrageRate() + rate) / 2);
		}
		
		return rentACarRepository.save(rentACar);
	}

}
