package com.ftn.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ftn.isa.model.AirplaneCompany;

@Repository
public interface AirplaneCompanyRepository extends JpaRepository<AirplaneCompany, Long> {

}
