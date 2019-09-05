package com.ftn.isa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ftn.isa.model.AirplaneCompany;
import com.ftn.isa.payload.AirplaneCompanyDTO;
import com.ftn.isa.repository.AirplaneCompanyRepository;

@ExtendWith(MockitoExtension.class)
class AirplaneCompanyServiceImplTest {

	@Mock
	AirplaneCompanyRepository airplaneCompanyRepository;
	@Mock
	DestinationService destinationService;
	@InjectMocks
	AirplaneCompanyServiceImpl airplaneCompanyService;

	@DisplayName("Get all Airplane companies")
	@Test
	void getAllTest() {
		List<AirplaneCompany> airplaneCompanies = new ArrayList<>();
		airplaneCompanies.add(new AirplaneCompany());

		when(airplaneCompanyRepository.findAll()).thenReturn(airplaneCompanies);

		List<AirplaneCompanyDTO> result = airplaneCompanyService.getAll();

		verify(airplaneCompanyRepository).findAll();

		assertEquals(1, result.size());
	}

	@DisplayName("Get by id Airplane company")
	@Test
	void getByIdTest() {
		AirplaneCompany airplaneCompany = new AirplaneCompany();

		when(airplaneCompanyRepository.findById(anyLong())).thenReturn(Optional.of(airplaneCompany));

		AirplaneCompanyDTO result = airplaneCompanyService.getById(1L);

		verify(airplaneCompanyRepository).findById(anyLong());

		assertNotNull(result);
	}

	@DisplayName("Save Airplane company")
	@Test
	void saveTest() {
		AirplaneCompany airplaneCompany = new AirplaneCompany();

		when(airplaneCompanyRepository.save(any(AirplaneCompany.class))).thenReturn(airplaneCompany);

		AirplaneCompanyDTO result = airplaneCompanyService.save(new AirplaneCompanyDTO());

		verify(airplaneCompanyRepository).save(any(AirplaneCompany.class));

		assertNotNull(result);
	}

	@DisplayName("Delete Airplane company")
	@Test
	void deleteTest() {
		airplaneCompanyService.delete(1L);

		verify(airplaneCompanyRepository).deleteById(anyLong());
	}

	@DisplayName("Vote Airplane company")
	@Test
	void voteTest() {
		AirplaneCompany airplaneCompany = new AirplaneCompany();
		airplaneCompany.setAvrageRate(5);
		
		when(airplaneCompanyRepository.save(any(AirplaneCompany.class))).thenReturn(airplaneCompany);

		AirplaneCompanyDTO result = airplaneCompanyService.save(new AirplaneCompanyDTO());

		verify(airplaneCompanyRepository).save(any(AirplaneCompany.class));

		assertEquals(5, result.getAvrageRate().doubleValue());
	}

}
