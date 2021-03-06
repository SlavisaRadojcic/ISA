package com.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Seat;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>{

	List<Seat> findByFlightId(long id);
	
	List<Seat> findByDiscounted(boolean discounted);
	
	List<Seat> findByUser(long id);
}
