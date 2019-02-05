package com.ftn.isa.service;

import java.util.List;

import com.ftn.isa.model.Ticket;

public interface TicketService {

	List<Ticket> getTicketsByFlight();
	
	List<Ticket> getTicketsOnDiscount();
}
