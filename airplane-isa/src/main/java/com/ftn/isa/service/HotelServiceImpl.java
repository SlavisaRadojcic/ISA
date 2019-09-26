package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ftn.isa.model.Hotel;
import com.ftn.isa.repository.HotelRepository;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getByName(String name) {
		return hotelRepository.findByName(name);
	}

	@Override
	public Hotel getById(long id) {
		return hotelRepository.getOne(id);
	}

	@Override
	public Hotel getByNameAndAddress(String name, String address) {
		return hotelRepository.findByNameAndAddress(name, address);
	}

	@Override
	public Hotel vote(long id, double rate) {
		Hotel hotel = hotelRepository.getOne(id);
		
		if(hotel.getAvrageRate() == 0) {
			hotel.setAvrageRate(rate);
		} else {
			hotel.setAvrageRate((hotel.getAvrageRate() + rate) / 2);
		}
		
		return hotelRepository.save(hotel);
	}
	
	
}
