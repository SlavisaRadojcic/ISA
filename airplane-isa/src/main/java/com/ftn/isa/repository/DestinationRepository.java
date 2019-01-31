package com.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Destination;

@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long>{

}
