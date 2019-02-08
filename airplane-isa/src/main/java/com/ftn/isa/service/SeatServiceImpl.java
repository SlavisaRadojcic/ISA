package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.Seat;
import com.ftn.isa.model.User;
import com.ftn.isa.payload.FlightDTO;
import com.ftn.isa.payload.SeatDTO;
import com.ftn.isa.repository.SeatRepository;
import com.ftn.isa.repository.UserRepository;
import com.ftn.isa.security.UserPrincipal;

@Service
public class SeatServiceImpl implements SeatService {
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FlightService flightService;

	@Override
	public List<SeatDTO> getAllByFlightId(long id) {
		List<Seat> seats = seatRepository.findByFlightId(id);
		List<SeatDTO> seatsDTO = new ArrayList<>();
		
		for(Seat seat: seats) {
			seatsDTO.add(new SeatDTO().convertToDTO(seat));
		}
		
		return seatsDTO;
	}

	@Override
	public List<SeatDTO> getAllOnDiscount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SeatDTO save(SeatDTO seatDTO) {
		FlightDTO flightDTO = flightService.getById(seatDTO.getFlightId());
		seatDTO.setFlight(flightDTO);
		Seat seat = new SeatDTO().convertToModel(seatDTO);
		
		seatRepository.save(seat);
		
		SeatDTO newSeatDTO = new SeatDTO().convertToDTO(seat);
		
		return newSeatDTO;
	}
	
	@Override
	public List<SeatDTO> saveList(List<SeatDTO> seatsDTO) {
		for(SeatDTO seatDTO: seatsDTO) {
			seatDTO = save(seatDTO);
		}
		
		return seatsDTO;
	}

	@Override
	public void delete(long id) {
		seatRepository.deleteById(id);
	}

	@Override
	public SeatDTO reserve(long id) {
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userRepository.findByEmail(userPrincipal.getEmail());
		
		Seat seat = seatRepository.getOne(id);
		seat.setAvailable(false);
		seat.setUser(user);
		
		seatRepository.save(seat);
		
		SeatDTO seatDTO = new SeatDTO().convertToDTO(seat);
		
		return seatDTO;
	}

	@Override
	public SeatDTO cancelReservation(long id) {
		Seat seat = seatRepository.getOne(id);
		seat.setAvailable(true);
		seat.setUser(null);
		
		seatRepository.save(seat);
		
		SeatDTO seatDTO = new SeatDTO().convertToDTO(seat);
		
		return seatDTO;
	}

	@Override
	public SeatDTO getById(long id) {
		Seat seat = seatRepository.getOne(id);
		
		SeatDTO seatDTO = new SeatDTO().convertToDTO(seat);
		
		return seatDTO;
	}

	@Override
	public List<SeatDTO> getAllByUserid(long id) {
		List<Seat> seats = seatRepository.findByUserId(id);
		List<SeatDTO> seatsDTO = new ArrayList<>();
		
		for(Seat seat: seats) {
			seatsDTO.add(new SeatDTO().convertToDTO(seat));
		}
		
		return seatsDTO;
	}

}
