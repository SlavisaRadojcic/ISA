package com.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{

}
