package com.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.RentACar;

@Repository
public interface RentACarRepository extends JpaRepository<RentACar, Long>{

}
