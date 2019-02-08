package com.ftn.isa.service;

import com.ftn.isa.model.Flight;
import com.ftn.isa.model.Seat;
import com.ftn.isa.model.User;
import com.ftn.isa.payload.SeatDTO;
import com.ftn.isa.repository.FlightRepository;
import com.ftn.isa.repository.SeatRepository;
import com.ftn.isa.repository.UserRepository;
import com.ftn.isa.security.UserPrincipal;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

	@Autowired
	SeatRepository seatRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	FlightRepository flightRepository;

	@Override
	public List<SeatDTO> getAllByFlightId(long id) {
		List<Seat> seats = seatRepository.findByFlightId(id);
		List<SeatDTO> seatsDTO = new ArrayList<>();

		for(Seat seat: seats) {
			seatsDTO.add(new SeatDTO(seat));
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
		Flight flight = flightRepository.getOne(seatDTO.getFlightId());

		Seat seat = new Seat();
		BeanUtils.copyProperties(seatDTO, seat, "flight");
		seat.setFlight(flight);

		return new SeatDTO(seatRepository.save(seat));
	}

	@Override
	public List<SeatDTO> saveList(List<SeatDTO> seatsDTO) {
		for(SeatDTO seatDTO: seatsDTO) {
			this.save(seatDTO);
		}

		return seatsDTO;
	}

	@Override
	public void delete(long id) {
		seatRepository.deleteById(id);
	}

	@Override
	public void deleteSeats(List<SeatDTO> seats) {
		List<Seat> seatsDb = new ArrayList<>();
		seats.forEach(seatDTO -> {
			Seat seatDb = new Seat();
			BeanUtils.copyProperties(seatDTO, seatDb);

			seatsDb.add(seatDb);
		});
		seatRepository.deleteInBatch(seatsDb);
	}

	@Override
	public SeatDTO reserve(long id) {
		UserPrincipal userPrincipal = (UserPrincipal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userRepository.findByEmail(userPrincipal.getEmail());

		Seat seat = seatRepository.getOne(id);
		seat.setAvailable(false);
		seat.setUser(user);

		return new SeatDTO(seatRepository.save(seat));
	}

	@Override
	public SeatDTO cancelReservation(long id) {
		Seat seat = seatRepository.getOne(id);
		seat.setAvailable(true);
		seat.setUser(null);

		return new SeatDTO(seatRepository.save(seat));
	}

	@Override
	public SeatDTO getById(long id) {
		return new SeatDTO(seatRepository.getOne(id));
	}

	@Override
	public List<SeatDTO> getAllByUserid(long id) {
		List<Seat> seats = seatRepository.findByUserId(id);
		List<SeatDTO> seatsDTO = new ArrayList<>();

		for(Seat seat: seats) {
			seatsDTO.add(new SeatDTO(seat));
		}

		return seatsDTO;
	}

}
