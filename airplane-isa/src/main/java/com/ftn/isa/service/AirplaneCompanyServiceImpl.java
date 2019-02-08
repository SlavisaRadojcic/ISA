package com.ftn.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.payload.AirplaneCompanyDTO;
import com.ftn.isa.payload.DestinationDTO;
import com.ftn.isa.repository.AirplaneCompanyRepository;

@Service
public class AirplaneCompanyServiceImpl implements AirplaneCompanyService {
	
	@Autowired
	AirplaneCompanyRepository airplaneCompanyRepository;
	
	@Autowired
	DestinationService destinationService;

	@Override
	public List<AirplaneCompanyDTO> getAll() {
		List<AirplaneCompany> airplaneCompanies = airplaneCompanyRepository.findAll();
		List<AirplaneCompanyDTO> airplaneCompaniesDTO = new ArrayList<>();
		
		for(AirplaneCompany airplaneCompany: airplaneCompanies) {
			airplaneCompaniesDTO.add(new AirplaneCompanyDTO().convertToDTO(airplaneCompany));
		}
		
		return airplaneCompaniesDTO;
	}

	@Override
	public AirplaneCompanyDTO save(AirplaneCompanyDTO airplaneCompanyDTO) {
		AirplaneCompany airplaneCompany = new AirplaneCompanyDTO().convertToModel(airplaneCompanyDTO);
		airplaneCompany = airplaneCompanyRepository.save(airplaneCompany);
		
		AirplaneCompanyDTO newCompanyDTO = new AirplaneCompanyDTO().convertToDTO(airplaneCompany);
		
		return newCompanyDTO;
	}

	@Override
	public void delete(long id) {
		airplaneCompanyRepository.deleteById(id);
	}

	@Override
	public AirplaneCompanyDTO getById(long id) {
		AirplaneCompany airplaneCompany = airplaneCompanyRepository.findById(id)
				.orElseThrow(() -> new UsernameNotFoundException("Airplane company not found with id : " + id));
		
		List<DestinationDTO> destinations = destinationService.getAllByComapnyId(airplaneCompany.getId());
		AirplaneCompanyDTO companyDTO = new AirplaneCompanyDTO().convertToDTO(airplaneCompany);
		companyDTO.setDestinations(destinations);
		
		return companyDTO;
	}

	@Override
	public AirplaneCompanyDTO vote(long companyId, double rate) {
		AirplaneCompany company = airplaneCompanyRepository.getOne(companyId);
		
		if(company.getAvrageRate() == 0) {
			company.setAvrageRate(rate);
		} else {
			company.setAvrageRate((company.getAvrageRate() + rate) / 2);
		}
		
		company = airplaneCompanyRepository.save(company);
		
		AirplaneCompanyDTO companyDTO = new AirplaneCompanyDTO().convertToDTO(company);
		
		return companyDTO;
	}
	
	
}
