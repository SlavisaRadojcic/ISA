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
		List<AirplaneCompanyDTO> dtos = new ArrayList<>();

		for(AirplaneCompany airplaneCompany: airplaneCompanies) {
			AirplaneCompanyDTO dto = new AirplaneCompanyDTO(airplaneCompany);
			List<DestinationDTO> destinationDTOS = destinationService.getAll();
			dto.setDestinations(destinationDTOS);

			dtos.add(dto);

		}

		return dtos;
	}

	@Override
	public AirplaneCompanyDTO save(AirplaneCompanyDTO dto) {
		AirplaneCompany airplaneCompany = new AirplaneCompany();
		if(dto.getId() != null) {
			airplaneCompany.setId(dto.getId());
		}
		airplaneCompany.setAddress(dto.getAddress());
		if(dto.getId() == null) {
			airplaneCompany.setAvrageRate(0);
		} else {
			airplaneCompany.setAvrageRate(dto.getAvrageRate());
		}
		airplaneCompany.setLuggagePrice(dto.getLuggagePrice() != null ? dto.getLuggagePrice() : 0);
		airplaneCompany.setLuggageType(dto.getLuggageInfo());
		airplaneCompany.setName(dto.getName());
		airplaneCompany.setPromoDescription(dto.getPromoDescription());

		// FIXME
//		List<Destination> destinations = new ArrayList<>();
//		List<Flight> flights = new ArrayList<>();
//		List<Seat> seats = new ArrayList<>();
//		User user = new User();
//
//		dto.getDestinations().forEach(destinationDTO -> {
//			Destination destination = new Destination();
//			destination.setName(destinationDTO.getName());
//		});
//
//		airplaneCompany.setDestinations();

		return new AirplaneCompanyDTO(airplaneCompanyRepository.save(airplaneCompany));
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
		AirplaneCompanyDTO companyDTO = new AirplaneCompanyDTO(airplaneCompany);
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

		return new AirplaneCompanyDTO(airplaneCompanyRepository.save(company));
	}

	@Override
	public AirplaneCompanyDTO getOne() {
		List<AirplaneCompany> airplaneCompanies = airplaneCompanyRepository.findAll();

		AirplaneCompanyDTO dto = new AirplaneCompanyDTO(airplaneCompanies.get(0));
		List<DestinationDTO> destinationDTOS = destinationService.getAll();
		dto.setDestinations(destinationDTOS);

		return dto;
	}


}
