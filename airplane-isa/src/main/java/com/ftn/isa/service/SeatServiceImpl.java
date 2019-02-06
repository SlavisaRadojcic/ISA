package com.ftn.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Seat;
import com.ftn.isa.model.User;
import com.ftn.isa.repository.SeatRepository;
import com.ftn.isa.repository.UserRepository;
import com.ftn.isa.security.UserPrincipal;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<Seat> getAllByFlightId(long id) {
		return seatRepository.findByFlightId(id);
	}

	@Override
	public List<Seat> getAllOnDiscount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Seat save(Seat seat) {
		return seatRepository.save(seat);
	}

	@Override
	public void delete(long id) {
		seatRepository.deleteById(id);
	}

	@Override
	public Seat reserve(long id) {
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userRepository.findByEmail(userPrincipal.getEmail());
		
		Seat seat = seatRepository.getOne(id);
		seat.setAvailable(false);
		seat.setUser(user);
		
		return seatRepository.save(seat);
	}

	@Override
	public Seat cancelReservation(long id) {
		Seat seat = seatRepository.getOne(id);
		seat.setAvailable(true);
		seat.setUser(null);
		
		return seatRepository.save(seat);
	}
	

}
