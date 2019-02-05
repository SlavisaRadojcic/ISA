package com.ftn.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>{

	List<Destination> findByAirplaneCompanyId(long id);
}
