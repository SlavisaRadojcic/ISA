package com.ftn.isa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftn.isa.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Override
	public List<Ticket> getTicketsByFlight() {
		return null;
	}

	@Override
	public List<Ticket> getTicketsOnDiscount() {
		return null;
	}

}
