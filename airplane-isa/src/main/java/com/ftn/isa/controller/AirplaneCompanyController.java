package com.ftn.isa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.service.AirplaneCompanyServiceImpl;

@RestController
@RequestMapping(value = "/airplane-companies")
public class AirplaneCompanyController {
	
	@Autowired
	AirplaneCompanyServiceImpl airplaneCompanyService;

	@RequestMapping(value = "")
	public List<AirplaneCompany> getAllCustomers() {
		return airplaneCompanyService.getAll();
	}
}
