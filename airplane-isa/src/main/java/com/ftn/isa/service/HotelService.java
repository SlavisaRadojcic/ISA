package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.Hotel;

public interface HotelService {

	List<Hotel> getAll();
	
	Hotel getByName(String name);
	
	Hotel getById(long id);
	
	Hotel getByNameAndAddress(String name, String address);
	
	Hotel vote(long id, double rate);
	
}
