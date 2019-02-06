package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.RentACar;

public interface RentACarService {

	List<RentACar> getAll();
	
	RentACar getByName(String name);
	
	RentACar getById(long id);
	
	RentACar getByNameAndAddress(String name, String address);
	
	RentACar vote(long id, double rate);
}
