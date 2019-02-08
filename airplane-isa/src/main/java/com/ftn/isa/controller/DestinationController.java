package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.payload.DestinationDTO;
import com.ftn.isa.service.DestinationService;

@RestController
@RequestMapping("/api/destinations")
public class DestinationController {
	
	@Autowired
	DestinationService destinationService;

	@GetMapping("/{companyId}")
	@PreAuthorize("hasRole('USER')")
	public List<DestinationDTO> getAllDestinationsByCompanyId(@PathVariable long companyId) {
		return destinationService.getAllByComapnyId(companyId);
	}
	
	@GetMapping
	public List<DestinationDTO> getAllDestinations() {
		return destinationService.getAll();
	}
	
	@GetMapping("/destination/{id}")
	@PreAuthorize("hasRole('USER')")
	public DestinationDTO getDestinationsById(@PathVariable long id) {
		return destinationService.getById(id);
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public DestinationDTO saveNewDestination(@RequestBody DestinationDTO destination) {
		return destinationService.save(destination);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteDestination(@PathVariable long id) {
		destinationService.delete(id);
	}
}
