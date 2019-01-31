package com.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
