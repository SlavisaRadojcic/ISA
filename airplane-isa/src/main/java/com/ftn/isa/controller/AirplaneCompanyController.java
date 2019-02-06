package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.service.AirplaneCompanyServiceImpl;

@RestController
@RequestMapping("/api/airplane-companies")
public class AirplaneCompanyController {
	
	@Autowired
	AirplaneCompanyServiceImpl airplaneCompanyService;

	@GetMapping
	public List<AirplaneCompany> getAllAirplaneCompanies() {
		return airplaneCompanyService.getAll();
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public AirplaneCompany saveAirplaneCompany(@RequestBody AirplaneCompany airplaneCompany) {
		return airplaneCompanyService.save(airplaneCompany);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteAirplaneCompany(@PathVariable long id) {
		airplaneCompanyService.delete(id);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public AirplaneCompany editAirplaneCompany(@RequestBody AirplaneCompany airplaneCompany) {
		return airplaneCompanyService.save(airplaneCompany);
	}
	
	@PostMapping("/vote/{companyId}/{rate}")
	@PreAuthorize("hasRole('USER')")
	public AirplaneCompany saveAirplaneCompany(@PathVariable long companyId, @PathVariable double rate) {
		return airplaneCompanyService.vote(companyId, rate);
	}
}
